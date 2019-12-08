document.addEventListener("DOMContentLoaded", function() {
  let reservationEmail = "";

  Handlebars.registerHelper("priceFormat", function(price) {
    return price.toLocaleString();
  });

  Handlebars.registerHelper("dateFormat", function(reservationDate) {
    const yyyy = reservationDate.substr(0, 4),
      mm = reservationDate.substr(5, 2),
      dd = reservationDate.substr(8, 2);

    const formattedDate = yyyy + "." + (mm - 1 + 1) + "." + (dd - 1 + 1);
    const weekDay = ["(일)", "(월)", "(화)", "(수)", "(목)", "(금)", "(토)"];
    const dayOfWeek = weekDay[new Date(formattedDate).getDay()];

    return formattedDate + " " + dayOfWeek;
  });

  Handlebars.registerHelper("isCompleted", function(reservationDate) {
    const now = new Date().getTime();
    const reservationTime = new Date(reservationDate).getTime();

    if (now >= reservationTime) return true;
    else return false;
  });

  const addTemplate = function(origTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(origTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  };

  const ReservationInfo = function(reservationData) {
    this.setReservationList(reservationData);
  };

  ReservationInfo.prototype = {
    setReservationList: function(reservationData) {
      ReservationInfo.prototype.initializeReservationAll();

      let totalCountSummary = reservationData.reservations.length;
      let plannedCountSummary = 0;
      let completedCountSummary = 0;
      let cancelCountSummary = 0;

      console.log(reservationData);

      reservationData.reservations.forEach(function(reservation, index) {
        const now = new Date().getTime();
        const reservationDate = new Date(reservation.reservationDate).getTime();

        if (reservation.cancelYn === true) {
          addTemplate(
            document.getElementById("reserv-confirm"),
            document.querySelector(".card.used.cancel"),
            reservation
          );
          cancelCountSummary += 1;
        } else if (now >= reservationDate) {
          addTemplate(
            document.getElementById("reserv-confirm"),
            document.querySelector(".card.used.complete"),
            reservation
          );
          completedCountSummary += 1;
        } else {
          addTemplate(
            document.getElementById("reserv-confirm"),
            document.querySelector(".card.confirmed"),
            reservation
          );
          plannedCountSummary += 1;
        }
      });

      const countSummaryArray = [
        totalCountSummary,
        plannedCountSummary,
        completedCountSummary,
        cancelCountSummary
      ];

      ReservationInfo.prototype.setReservationCount(countSummaryArray);
    },

    setReservationCount(countArray) {
      const countSummaryList = document.querySelectorAll(
        ".link_summary_board span"
      );

      countSummaryList.forEach(function(countSummary, index) {
        countSummary.innerHTML = countArray[index];
      });
    },

    initializeReservationAll: function() {
      const plannedList = document.querySelectorAll(".card.confirmed article");
      const completedList = document.querySelectorAll(".card.used.complete article");
      const canceledList = document.querySelectorAll(
        ".card.used.cancel article"
      );

      ReservationInfo.prototype.initializeReservation(plannedList);
      ReservationInfo.prototype.initializeReservation(completedList);
      ReservationInfo.prototype.initializeReservation(canceledList);
    },

    initializeReservation: function(reservationList) {
      if (reservationList.length != 0) {
        reservationList.forEach(function(reservation) {
          //console.log(reservation);
          //canceldList 들어오면 여기서 parentNode =null 뜨는데 이유를 모르겠습니다..
          reservation.parentNode.removeChild(reservation);
        });
      }
    }
  };

  const CancelBtn = function() {
    this.setCancelBtn();
  };

  CancelBtn.prototype = {
    setCancelBtn: function() {
      const cancelBtn = document.querySelectorAll(
        ".card.confirmed .booking_cancel .btn"
      );
      console.log(cancelBtn);
      const popupCloseBtn = document.querySelector(".popup_btn_close");
      const disagreeBtn = document.querySelector(".btn_gray");

      cancelBtn.forEach(function(btn) {
        btn.addEventListener("click", CancelBtn.prototype.showCancelPopup);
      });

      popupCloseBtn.addEventListener(
        "click",
        CancelBtn.prototype.hideCancelPopup
      );
      disagreeBtn.addEventListener(
        "click",
        CancelBtn.prototype.hideCancelPopup
      );
    },

    hideCancelPopup: function() {
      const cancelPopup = document.querySelector(".popup_booking_wrapper");
      cancelPopup.setAttribute("style", "display:none;");
    },

    showCancelPopup: function() {
      const cancelPopup = document.querySelector(".popup_booking_wrapper");
      cancelPopup.setAttribute("style", "display:block;");

      let targetedItem;

      if (event.target.tagName == "BUTTON") {
        targetedItem = event.target.parentNode.parentNode;
      } else {
        targetedItem = event.target.parentNode.parentNode.parentNode;
      }

      new CancelPopup(targetedItem);
    }
  };

  const CancelPopup = function(targetedItem) {
    this.setCancelPopupData(targetedItem);
  };

  CancelPopup.prototype = {
    setCancelPopupData: function(targetedItem) {
      const cancelPopup = document.querySelector(".popup_booking_wrapper");
      const reservationInfoId = targetedItem.firstElementChild.id;
      const reservationTitle = targetedItem.children[1].innerHTML;
      const reservationDate =
        targetedItem.children[2].children[0].children[1].innerHTML;

      cancelPopup.querySelector(".pop_tit span").innerHTML = reservationTitle;
      cancelPopup.querySelector(".pop_tit small").innerHTML = reservationDate;

      CancelPopup.prototype.registerAgreeBtnEvent(reservationInfoId);
    },

    registerAgreeBtnEvent: function(reservationInfoId) {
      const agreeBtn = document.querySelector(".btn_green");
      agreeBtn.addEventListener("click", function() {
        CancelPopup.prototype.sendCanceldJSON(reservationInfoId);
      });
    },

    sendCanceldJSON: function(reservationInfoId) {
      let oReq = new XMLHttpRequest();
      oReq.open("PUT", "./api/reservations/" + reservationInfoId);
      oReq.setRequestHeader("Content-Type", "application/json");
      oReq.addEventListener("load", function() {
        if (oReq.status === 200) {
          getReservationApi(reservationEmail);
          CancelBtn.prototype.hideCancelPopup();
        } else if (oReq.status !== 200) {
          alert("Request failed.  Returned status of " + oReq.status);
        }
      });

      oReq.send();
    }
  };

  const setApiData = function(jsonData) {
    new ReservationInfo(jsonData);
    new CancelBtn();
  };

  const sendAjax = function(url) {
    let oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      setApiData(jsonData);
    });

    oReq.open("GET", url);
    oReq.send();
  };

  const getParameterByName = function(parameterName) {
    parameterName = parameterName.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + parameterName + "=([^&#]*)");
    var results = regex.exec(location.search);

    const parameterValue =
      results === null
        ? ""
        : decodeURIComponent(results[1].replace(/\+/g, " "));
    return parameterValue;
  };

  const getReservationApi = function(reservationEmail) {
    sendAjax("./api/reservations?reservationEmail=" + reservationEmail);
  };

  const initJS = function() {
    reservationEmail = getParameterByName("reservationEmail");
    getReservationApi(reservationEmail);
  };

  initJS();
});
