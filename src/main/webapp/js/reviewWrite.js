document.addEventListener("DOMContentLoaded", function() {
  let reservationInfoId;
  let productId;

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

  const Product = function(productId) {
    this.getProductApi(productId);
  };

  Product.prototype = {
    getProductApi: function(productId) {
      sendAjax("./api/comments/" + productId);
    },

    setProdudctTitle: function(productData) {
      document.querySelector(".top_title .title").innerHTML =
        productData.productDescription;
    }
  };

  const setApiData = function(jsonData) {
    console.log(jsonData);
    Product.prototype.setProdudctTitle(jsonData);
    CommentInput.prototype.createAllHiddenInput();
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
        CommentImage.prototype.checkFileType
      );
    },

    registerDelBtnEvent: function() {
      CommentImage.prototype.delBtn.addEventListener(
        "click",
        CommentImage.prototype.test7
      );
    },

    checkFileType: function() {
      const uploadedFile = event.target.files[0];
      if (!CommentImage.prototype.validImageType(uploadedFile)) {
        console.warn("invalid image file type");
        return;
      }

      const imgThumb = document.querySelector(".item_thumb");
      imgThumb.src = window.URL.createObjectURL(uploadedFile);
    },

    validImageType: function(image) {
      const result =
        ["image/jpeg", "image/png", "image/jpg"].indexOf(image.type) > -1;
      return result;
    },

    test7: function() {
      uploadedFile = CommentImage.prototype.uploadedFile;

      CommentImage.prototype.uploadedFile.reset();
      uploadedFile.value == "";

      console.log(uploadedFile.files[0]);

    }
  };

  const initJS = function() {
    reservationInfoId = getParameterByName("reservationInfoId");
    productId = getParameterByName("productId");

    new Product(productId);
    new StarScore();
    new Comment();
    new CommentImage();
    new SubmitBtn();
  };

  const CommentInput = function() {
    this.createAllHiddenInput();
  };

  CommentInput.prototype = {
    createAllHiddenInput: function() {
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

  const InputCondition = function() {};

  InputCondition.prototype = {
    isAllConditionValid: function() {
      const isScoreChecked = InputCondition.prototype.isScoreChecked();
      const isCommentFilled = InputCondition.prototype.isCommentFilled();

      return isScoreChecked && isCommentFilled;
    },

    // 별점 점수 검사
    isScoreChecked: function() {
      const starScore = document.querySelector(".rating .star_rank").innerHTML;
      return starScore >= 1 && starScore <= 5;
    },

    // 코멘트 길이 검사
    isCommentFilled: function() {
      const commentArea = document.querySelector(".review_textarea");
      const commentLength = commentArea.value.length;

      return commentLength >= 5 && commentLength <= 400;
    }

    // 파일 타입 검사는 파일 업로드될 때
  };

  const SubmitBtn = function() {
    this.registerEvent();
  };

  SubmitBtn.prototype = {
    registerBtn: document.querySelector("#fileForm .bk_btn"),

    registerEvent: function() {
      SubmitBtn.prototype.registerBtn.addEventListener(
        "click",
        SubmitBtn.prototype.clickSubmitBtn
      );
    },

    clickSubmitBtn: function() {
      event.preventDefault();

      //검사
      if (!InputCondition.prototype.isAllConditionValid()) return;

      SubmitBtn.prototype.createCommentFormData();
    },

    createCommentFormData: function() {
      // checked된 별점 모두는 form data로 전송 X
      const ratings = document.querySelectorAll(".rating_rdo");

      ratings.forEach(function(rating) {
        rating.disabled = true;
      });

      // 최종 score만 form data로 전송
      const score = document.querySelector(".star_rank").innerHTML;
      CommentInput.prototype.createHiddenInput("score", score);

      const commentFormData = new FormData(document.querySelector("#fileForm"));
      console.log(commentFormData);
      SubmitBtn.prototype.sendCommentForm(commentFormData);
    },

    sendCommentForm: function(commentFormData) {
      let oReq = new XMLHttpRequest();
      oReq.open(
        "POST",
        "./api/reservations/" + reservationInfoId + "/comments"
      );
      oReq.addEventListener("load", function() {
        if (oReq.status === 200) {
          alert("리뷰가 등록되었습니다");
          document.location.href = "./";
        } else if (oReq.status !== 200) {
          alert("Request failed.  Returned status of " + oReq.status);
        }
      });

      oReq.send(commentFormData);
    }
  };

  initJS();
});
