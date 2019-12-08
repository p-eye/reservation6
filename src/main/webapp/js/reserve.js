document.addEventListener("DOMContentLoaded", function() {
  let jsonData;
  const agreeCheckBox = document.querySelector("input[id=chk3]");

  const ClassName = function() {};

  ClassName.prototype = {
    addClass: function(element, classString) {
      element.className = element.className
        .split(" ")
        .filter(function(name) {
          return name !== classString;
        })
        .concat(classString)
        .join(" ");
    },

    removeClass: function(element, classString) {
      element.className = element.className
        .split(" ")
        .filter(function(name) {
          return name !== classString;
        })
        .join(" ");
    }
  };

  const addTemplate = function(origTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(origTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  };

  Handlebars.registerHelper("priceFormat", function(price) {
    return price.toLocaleString();
  });

  Handlebars.registerHelper("reverseArray", function(array) {
    return array.reverse();
  });

  Handlebars.registerHelper("priceType", function(priceTypeName) {
    if (priceTypeName === "A") return "성인(만 19~64세)";
    if (priceTypeName === "Y") return "청소년(만 13~18세)";
    if (priceTypeName === "B") return "어린이(만 4~12세)";
    if (priceTypeName === "S") return "셋트";
    if (priceTypeName === "D") return "장애인";
    if (priceTypeName === "C") return "지역주민";
    if (priceTypeName === "E") return "얼리버드";
    if (priceTypeName === "V") return "VIP석";
    if (priceTypeName === "R") return "R석";
    if (priceTypeName === "B") return "B석";
    if (priceTypeName === "S") return "S석";
    return "";
  });

  const PlusMinusClassName = function() {};

  PlusMinusClassName.prototype = {
    handlePlusClass: function(eachCountInput, target) {
      ClassName.prototype.removeClass(eachCountInput, "disabled");
      ClassName.prototype.removeClass(
        target.parentNode.firstElementChild,
        "disabled"
      );
      ClassName.prototype.addClass(
        target.parentNode.nextElementSibling,
        "on_color"
      );
    },

    handleMinusClass: function(eachCountInput, target) {
      ClassName.prototype.addClass(eachCountInput, "disabled");
      ClassName.prototype.addClass(target, "disabled");
      ClassName.prototype.removeClass(
        target.parentNode.nextElementSibling,
        "on_color"
      );
    }
  };

  const Price = function(target, countInput) {
    this.calcEachPrice(target, countInput);
    this.calcTotalCount();
  };

  Price.prototype = {
    calcEachPrice: function(target, countInput) {
      const quantityInfo = target.parentNode.parentNode.nextElementSibling;
      const totalPriceClass = target.parentNode.nextElementSibling;
      const productPrice = parseInt(
        quantityInfo
          .querySelector(".product_price .price")
          .innerText.replace(/,/g, "")
      );

      const eachPrice = productPrice * countInput.value;
      totalPriceClass.querySelector(
        ".total_price"
      ).innerText = eachPrice.toLocaleString();
    },

    calcTotalCount: function() {
      const countInputList = document.querySelectorAll(".count_control_input");
      let totalCount = 0;

      countInputList.forEach(function(eachCount) {
        totalCount += parseInt(eachCount.value);
      });

      document.querySelector(
        ".inline_control #totalCount"
      ).innerText = totalCount;
    }
  };

  const PlusMinusBtn = function() {
    this.plusMinusBtn = document.querySelectorAll(".btn_plus_minus");
    console.log(this.plusMinusBtn);
    this.registerEvent();
  };

  PlusMinusBtn.prototype = {
    ////////////////////////////////////////////////// plusminusbtn nodelist null 문제

    plusMinusBtn: document.querySelectorAll(".btn_plus_minus"),

    registerEvent: function() {
      console.log(PlusMinusBtn.prototype.plusMinusBtn);
      this.plusMinusBtn.forEach(function(btn) {
        btn.addEventListener("click", PlusMinusBtn.prototype.clickPlusMinusBtn);
      });
    },

    clickPlusMinusBtn: function() {
      let eachCountInput;

      if (event.target.className.indexOf("ico_plus3") != -1) {
        eachCountInput = this.previousElementSibling;
        eachCountInput.value = ++eachCountInput.value;
        PlusMinusClassName.prototype.handlePlusClass(eachCountInput, this);
      } else if (event.target.className.indexOf("ico_minus3") != -1) {
        eachCountInput = this.nextElementSibling;

        if (eachCountInput.value <= 0) return;
        eachCountInput.value = --eachCountInput.value;

        if (eachCountInput.value === "0") {
          PlusMinusClassName.prototype.handleMinusClass(eachCountInput, this);
        }
      }

      new Price(this, eachCountInput);
    }
  };

  const Product = function(productData) {
    this.setProductData(productData);
  };

  Product.prototype = {
    setProductData: function(productData) {
      console.log(productData);
      const productTitle = productData.displayInfo.productDescription;
      const productImage = "./" + productData.productImages[0].saveFileName;

      document.querySelector(".top_title .title").innerText = productTitle;
      document.querySelector(".preview_txt_tit").innerText = productTitle;
      document.querySelector(".img_thumb").src = productImage;

      addTemplate(
        document.getElementById("productInfo"),
        document.querySelector(".section_store_details"),
        productData
      );

      addTemplate(
        document.getElementById("quantity"),
        document.querySelector(".ticket_body"),
        productData
      );

      new PlusMinusBtn();
    }
  };

  const AgreeBtn = function() {
    this.registerShowBtnEvent();
    this.registerAgreeCheckBoxEvent();
  };

  AgreeBtn.prototype = {
    agreeShowBtn: document.querySelectorAll(".agreement .btn_agreement"),

    registerShowBtnEvent: function() {
      console.log(AgreeBtn.prototype.agreeShowBtn);
      AgreeBtn.prototype.agreeShowBtn.forEach(function(btn) {
        btn.addEventListener("click", AgreeBtn.prototype.clickAgreeShowBtn);
      });
    },

    clickAgreeShowBtn: function() {
      if (this.parentNode.className.indexOf("open") != -1) {
        ClassName.prototype.removeClass(this.parentNode, "open");
        this.firstElementChild.innerText = "보기";
      } else {
        ClassName.prototype.addClass(this.parentNode, "open");
        this.firstElementChild.innerText = "접기";
      }
    },

    registerAgreeCheckBoxEvent: function() {
      agreeCheckBox.addEventListener(
        "change",
        AgreeBtn.prototype.changeAgreeCheckBox
      );
    },

    changeAgreeCheckBox: function() {
      if (this.checked) {
        ClassName.prototype.addClass(this, "checked");

        if (InputCondition.prototype.isAllConditionInputted())
          SubmitBtn.prototype.activateSubmitBtn();
      } else {
        ClassName.prototype.removeClass(this, "checked");
        SubmitBtn.prototype.inactiveSubmitBtn();
      }
    }
  };

  const ReservationInput = function(inputData) {
    this.createAllHiddenInput(inputData);
  };

  ReservationInput.prototype = {
    createAllHiddenInput: function(inputData) {
      const productId = inputData.displayInfo.productId;
      const displayInfoId = inputData.displayInfo.displayInfoId;
      const reservationDate = document.querySelector(".inline_control p")
        .firstElementChild.innerHTML;

      ReservationInput.prototype.createHiddenInput("productId", productId);
      ReservationInput.prototype.createHiddenInput(
        "displayInfoId",
        displayInfoId
      );
      ReservationInput.prototype.createHiddenInput(
        "reservationDate",
        reservationDate
      );
    },

    createHiddenInput: function(name, value) {
      const newInput = document.createElement("input");
      newInput.setAttribute("type", "hidden");
      newInput.setAttribute("name", name);
      newInput.setAttribute("id", name);
      newInput.setAttribute("value", value);

      document.querySelector(".hidden_form").appendChild(newInput);
    }
  };

  const InputCondition = function() {};

  InputCondition.prototype = {
    isAllConditionInputted: function() {
      const isAgreeChecked = this.isAgreeChecked();
      const isProfileValid = this.isProfileFilled();
      const isTotalCountNonZero = this.isTotalCountNonZero();
      return isAgreeChecked && isProfileValid && isTotalCountNonZero;
    },

    //동의여부 검사
    isAgreeChecked: function() {
      return agreeCheckBox.checked;
    },

    //총 예매수 검사
    isTotalCountNonZero: function() {
      const totalCount = document.querySelector("span#totalCount").innerHTML;
      return totalCount != 0;
    },

    //예매자정보 검사
    isProfileFilled: function() {
      const inputList = document.querySelectorAll(".inline_control input");
      const isProfileFilledArray = Array.from(inputList).map(function(input) {
        return InputCondition.prototype.isInputFilled(input);
      });

      const isAllProfileFilled = isProfileFilledArray.every(function(element) {
        return element == true;
      });

      return isAllProfileFilled;
    },

    isInputFilled: function(userInput) {
      if (userInput.value === "") {
        return false;
      } else {
        return true;
      }
    }
  };

  const RegularExp = function() {};

  RegularExp.prototype = {
    isProfileValid: function() {
      const inputList = document.querySelectorAll(".inline_control input");
      const isProfileValidArray = Array.from(inputList).map(function(input) {
        return RegularExp.prototype.checkInputValidity(input);
      });

      const isAllProfileValid = isProfileValidArray.every(function(element) {
        return element == true;
      });

      return isAllProfileValid;
    },

    checkInputValidity: function(userInput) {
      const isInputMatched = !RegularExp.prototype
        .getRegExp(userInput.name)
        .test(userInput.value);

      if (isInputMatched) {
        userInput.nextElementSibling.innerHTML = RegularExp.prototype.getErrorMsg(
          userInput.name
        );
        return false;
      } else {
        userInput.nextElementSibling.innerHTML = "";
        return true;
      }
    },

    getRegExp: function(userInputName) {
      switch (userInputName) {
        case "reservationName":
          return /^[가-힣]{2,4}/;
        case "reservationTel":
          return /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
        case "reservationEmail":
          return /^[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
      }
    },

    getErrorMsg: function(userInputName) {
      switch (userInputName) {
        case "reservationName":
          return "이름 형식을 확인해주세요";
        case "reservationTel":
          return "연락처 형식을 확인해주세요";
        case "reservationEmail":
          return "이메일 형식을 확인해주세요";
      }
    }
  };

  const SubmitBtn = function() {
    this.registerEvent();
  };

  SubmitBtn.prototype = {
    submitBtnWrap: document.querySelector(".bk_btn_wrap"),
    submitBtn: document.querySelector(".box_bk_btn .bk_btn"),

    activateSubmitBtn: function() {
      ClassName.prototype.removeClass(
        SubmitBtn.prototype.submitBtnWrap,
        "disable"
      );
    },

    inactiveSubmitBtn: function() {
      ClassName.prototype.addClass(
        SubmitBtn.prototype.submitBtnWrap,
        "disable"
      );
    },

    isSubmitBtnActivated: function() {
      if (
        SubmitBtn.prototype.submitBtnWrap.className.indexOf("disable") != -1
      ) {
        return false;
      } else return true;
    },

    registerEvent: function() {
      SubmitBtn.prototype.submitBtn.addEventListener(
        "click",
        SubmitBtn.prototype.clickSubmitBtn
      );
    },

    clickSubmitBtn: function() {
      event.preventDefault();

      //예약버튼 활성화 검사
      if (!SubmitBtn.prototype.isSubmitBtnActivated()) return;

      // 조건입력검사
      if (!InputCondition.prototype.isAllConditionInputted()) return;

      //유효성검사
      if (!RegularExp.prototype.isProfileValid()) return;

      SubmitBtn.prototype.createReservationInputObject();
    },

    createReservationInputObject: function() {
      let reservationObj = {};

      //기본 input
      var inputList = document.querySelectorAll(".form_horizontal input");
      for (var i = 0; i < inputList.length; i++) {
        reservationObj[inputList[i].name] = inputList[i].value;
      }

      //price input
      const priceList = document.querySelectorAll(".count_control_input");
      reservationObj.prices = [];

      priceList.forEach(function(countInput) {
        if (countInput.value == 0) return;

        const reservationPriceObject = {
          productPriceId: countInput.id,
          count: countInput.value,
          reservationInfoId: "",
          reservationInfoPriceId: ""
        };

        reservationObj["prices"].push(reservationPriceObject);
      });

      SubmitBtn.prototype.sendReservationInputJSON(reservationObj);
    },

    sendReservationInputJSON: function(reservationObj) {
      let oReq = new XMLHttpRequest();

      oReq.open("POST", "http://localhost:8080/reservation6/api/reservations");
      oReq.setRequestHeader("Content-Type", "application/json");
      oReq.addEventListener("load", function() {
        if (oReq.status === 200) {
          alert("예매가 완료되었습니다");
        } else if (oReq.status !== 200) {
          alert("Request failed.  Returned status of " + oReq.status);
        }
      });

      console.log(reservationObj);
      //   oReq.send(JSON.stringify(reservationObj));
    }
  };

  const setApiData = function(jsonData) {
    new Product(jsonData);
    new ReservationInput(jsonData);
  };

  const sendAjax = function(url) {
    const oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
      jsonData = JSON.parse(oReq.responseText);
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
    new AgreeBtn();
    new SubmitBtn();
  };

  initJS();
});
