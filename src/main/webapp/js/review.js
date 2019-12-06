document.addEventListener("DOMContentLoaded", function() {
  function addTemplate(origTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(origTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  }

  Handlebars.registerHelper("privateEmail", function(reservationEmail) {
    return reservationEmail.substr(0, 4) + "****";
  });

  Handlebars.registerHelper("scoreFormat", function(score) {
    return score + ".0";
  });

  Handlebars.registerHelper("limit", function(arr, limit) {
    if (!Array.isArray(arr)) {
      return [];
    }
    return arr.slice(0, limit);
  });

  Handlebars.registerHelper("dateFormat", function(reservationDate) {
    const yyyy = reservationDate.substr(0, 4);
    const mm = reservationDate.substr(5, 2);
    const dd = reservationDate.substr(8, 2);
    return yyyy + "." + (mm - 1 + 1) + "." + (dd - 1 + 1);
  });

  const Review = function(reviewData) {
    this.getReviewData(reviewData);
  };

  Review.prototype = {
    getReviewData: function(reviewData) {
      addTemplate(
        document.getElementById("reviewList"),
        document.querySelector(".list_short_review"),
        reviewData
      );

      document.querySelectorAll(".review_area h4").forEach(function(span) {
        span.innerHTML = reviewData.displayInfo.productDescription;
      });

      Review.prototype.getReviewScore(reviewData);
    },

    getReviewScore: function(reviewData) {
      //평점 계산
      const starScore = reviewData.averageScore.toFixed(1);
      document.querySelector(
        ".grade_area .text_value span"
      ).innerHTML = starScore;
      document.querySelector(".grade_area .graph_value").style.width =
        starScore * 20 + "%";

      // 등록 개수
      document.querySelector(".grade_area .join_count em").innerHTML =
        (reviewData.comments ? reviewData.comments.length : 0) + "건";
    }
  };

  const setApiData = function(jsonData) {
    new Review(jsonData);
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

  const DisplayInfo = function(displayInfoId) {
    this.getDisplayInfoApi(displayInfoId);
    this.setDisplayInfoLink(displayInfoId);
  };

  DisplayInfo.prototype = {
    getDisplayInfoApi: function(displayInfoId) {
      sendAjax("./api/products/" + displayInfoId);
    },
    setDisplayInfoLink: function(displayInfoId) {
      document
        .querySelector(".btn_back")
        .setAttribute("href", "./detail?displayInfoId=" + displayInfoId);
    }
  };

  const getParameterByName = function(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
    var results = regex.exec(location.search);

    const parameterValue =
      results === null
        ? ""
        : decodeURIComponent(results[1].replace(/\+/g, " "));

    return parameterValue;
  };

  const initJS = function() {
    const displayInfoId = getParameterByName("displayInfoId");
    new DisplayInfo(displayInfoId);
  };

  initJS();
});
