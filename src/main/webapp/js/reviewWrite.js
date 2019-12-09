document.addEventListener("DOMContentLoaded", function() {
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

  const CommentInput = function(inputData) {
    this.createAllHiddenInput(inputData);
  };

  CommentInput.prototype = {
    createAllHiddenInput: function(inputData) {
      const productId = inputData.productId;
      const reservationInfoId = inputData.reservationInfoId;

      this.createHiddenInput("productId", productId);
      this.createHiddenInput("reservationInfoId", reservationInfoId);
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

  const Comment = function() {
    this.registerCommentInfoEvent();
    this.registerCommentAreaEvent();
  };

  Comment.prototype = {
    commentInfo: document.querySelector(".review_write_info"),
    commentArea: document.querySelector(".review_textarea"),

    registerCommentInfoEvent: function() {
      Comment.prototype.commentInfo.addEventListener(
        "click",
        Comment.prototype.hideCommentInfo
      );

      Comment.prototype.commentArea.addEventListener(
        "focusout",
        Comment.prototype.showCommentInfo
      );
    },

    registerCommentAreaEvent: function() {
      Comment.prototype.commentArea.maxLength = 400;

      Comment.prototype.commentArea.addEventListener(
        "keyup",
        Comment.prototype.checkCommentLength
      );

      Comment.prototype.commentArea.addEventListener(
        "keydown",
        Comment.prototype.checkCommentLength
      );
    },

    hideCommentInfo: function() {
      this.setAttribute("style", "display:none;");

      Comment.prototype.commentArea.focus();
      Comment.prototype.commentArea.value = "";
    },

    showCommentInfo: function() {
      if (this.value.length == 0) {
        document.querySelector(".review_write_info").removeAttribute("style");
      }
    },

    checkCommentLength: function() {
      document.querySelector(
        ".guide_review span"
      ).innerHTML = this.value.length;
    }
  };

  const StarScore = function() {
    this.registerEvent();
  };

  StarScore.prototype = {
    ratings: document.querySelectorAll(".rating_rdo"),

    registerEvent: function() {
      StarScore.prototype.ratings.forEach(function(rating) {
        rating.addEventListener("click", function() {
          StarScore.prototype.highlightRating(rating.value);
          StarScore.prototype.setRatingScore(rating.value);
        });
      });
    },

    highlightRating: function(targetedRatingValue) {
      StarScore.prototype.ratings.forEach(function(rating) {
        if (rating.value <= targetedRatingValue) {
          rating.checked = true;
        } else {
          rating.checked = false;
        }
      });
    },

    setRatingScore: function(targetedRatingValue) {
      document.querySelector(".star_rank").innerHTML = targetedRatingValue;
      ClassName.prototype.removeClass(
        document.querySelector(".star_rank"),
        "gray_star"
      );
    }
  };

  const ReservationInfo = function(reservationInfoId) {
    this.getReservationInfoApi(reservationInfoId);
  };

  ReservationInfo.prototype = {
    getReservationInfoApi: function(reservationInfoId) {
      sendAjax("./api/reservations/" + reservationInfoId);
    }
  };

  const Product = function(productData) {
    this.setProductTitle(productData);
  };

  Product.prototype = {
    setProdudctTitle: function(productData) {}
  };

  const setApiData = function(jsonData) {
    console.log(jsonData);
    CommentInput.prototype.createAllHiddenInput(jsonData);
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

  const CommentImage = function() {
    this.registerFileEvent();
    this.registerDelBtnEvent();
  };

  CommentImage.prototype = {
    uploadedFile: document.querySelector("#reviewImageFileOpenInput"),

    delBtn: document.querySelector(".lst_thumb .anchor"),

    registerFileEvent: function() {
      CommentImage.prototype.uploadedFile.addEventListener(
        "change",
        CommentImage.prototype.test6
      );
    },

    registerDelBtnEvent: function() {
      CommentImage.prototype.delBtn.addEventListener(
        "click",
        CommentImage.prototype.test7
      );
    },

    test6: function() {
      console.log(event.target.files[0]);
      const uploadedImage = event.target.files[0];
      if (!CommentImage.prototype.validImageType(uploadedImage)) {
        console.warn("invalid image file type");
        return;
      }

      const elImage = document.querySelector(".item_thumb");
      elImage.src = window.URL.createObjectURL(uploadedImage);
    },

    validImageType: function(image) {
      const result =
        ["image/jpeg", "image/png", "image/jpg"].indexOf(image.type) > -1;
      return result;
    },

    test7: function() {
      console.log("test");
    }
  };

  const initJS = function() {
    const reservationInfoId = getParameterByName("reservationInfoId");
    const productId = getParameterByName("productId");

    new ReservationInfo(reservationInfoId);
    new StarScore();
    new Comment();
    new CommentImage();
    new SubmitBtn();
  };

  const SubmitBtn = function() {
    this.registerEvent();
  };

  SubmitBtn.prototype = {
    registerBtn: document.querySelector("#fileForm .bk_btn"),

    registerEvent: function() {
      SubmitBtn.prototype.registerBtn.addEventListener(
        "click",
        SubmitBtn.prototype.test8
      );
    },

    test8: function() {
      event.preventDefault();
      const score = document.querySelector(".star_rank").innerHTML;
      CommentInput.prototype.createHiddenInput("score", score);

      const formData = new FormData(document.querySelector("#fileForm"));
      console.log(formData);

      //  document.querySelector("#fileForm").submit();
      let oReq = new XMLHttpRequest();
      oReq.open("POST", "http://localhost:8080/reservation6/api/test");
      oReq.addEventListener("load", function() {
        if (oReq.status === 200) {
          alert("리뷰가 등록되었습니다");
          document.location.href = "./main.html";
        } else if (oReq.status !== 200) {
          alert("Request failed.  Returned status of " + oReq.status);
        }
      });

      oReq.send(formData);
    }
  };

  initJS();
});
