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

  const addTemplate = function(origTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(origTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  };

  Handlebars.registerHelper("privateEmail", function(reservationEmail) {
    if (!reservationEmail) return "";
    return reservationEmail.substr(0, 4) + "****";
  });

  Handlebars.registerHelper("scoreFormat", function(score) {
    if (!score) return "0.0";
    return score + ".0";
  });

  Handlebars.registerHelper("limit", function(arr, limit) {
    if (!Array.isArray(arr)) return [];
    return arr.slice(0, limit);
  });

  Handlebars.registerHelper("dateFormat", function(reservationDate) {
    if (!reservationDate) return "";
    const yyyy = reservationDate.substr(0, 4);
    const mm = reservationDate.substr(5, 2);
    const dd = reservationDate.substr(8, 2);
    return yyyy + "." + (mm - 1 + 1) + "." + (dd - 1 + 1);
  });

  const ProductInfo = function(productData) {
    this.registerEvent();
    this.setProductInfoData(productData);
  };

  ProductInfo.prototype = {
    infoTab: document.querySelector(".info_tab_lst"),

    registerEvent: function() {
      ProductInfo.prototype.infoTab.addEventListener("click", function() {
        if (event.target.tagName !== "A" && event.target.tagName !== "SPAN")
          return;

        if (event.target.tagName === "A") {
          ProductInfo.prototype.handleProductInfoClass(event.target.parentNode);
        } else if (event.target.tagName === "SPAN") {
          ProductInfo.prototype.handleProductInfoClass(
            event.target.parentNode.parentNode
          );
        }
      });
    },

    handleProductInfoClass: function(targetList) {
      const detailWrap = document.querySelector(".detail_area_wrap");
      const locationWrap = document.querySelector(".detail_location");

      ClassName.prototype.addClass(targetList.firstElementChild, "active");

      if (targetList === document.querySelectorAll(".info_tab_lst .item")[0]) {
        ProductInfo.prototype.handleActiveClass(
          targetList.nextElementSibling.firstElementChild
        );
        ProductInfo.prototype.handleHideClass(locationWrap, detailWrap);
      } else {
        ProductInfo.prototype.handleActiveClass(
          targetList.previousElementSibling.firstElementChild
        );
        ProductInfo.prototype.handleHideClass(detailWrap, locationWrap);
      }
    },

    handleActiveClass: function(target) {
      ClassName.prototype.removeClass(target, "active");
    },

    handleHideClass: function(add, remove) {
      ClassName.prototype.addClass(add, "hide");
      ClassName.prototype.removeClass(remove, "hide");
    },

    setProductInfoData: function(infoData) {
      addTemplate(
        document.getElementById("location"),
        document.querySelector(".box_store_info"),
        infoData
      );
      document.querySelector(".store_details .dsc").innerHTML =
        infoData.displayInfo.productContent;
    }
  };

  const Review = function(reviewData) {
    this.setReviewData(reviewData);
  };

  Review.prototype = {
    setReviewData: function(reviewData) {
      addTemplate(
        document.getElementById("reviewList"),
        document.querySelector(".list_short_review"),
        reviewData
      );

      Review.prototype.setReviewScore(reviewData);
    },

    setReviewScore: function(reviewData) {
      //평점 계산
      const starScore = reviewData.averageScore.toFixed(1);

      document.querySelector(
        ".grade_area .text_value span"
      ).innerHTML = starScore;
      document.querySelector(".grade_area .graph_value").style.width =
        starScore * 20 + "%";

      // 등록 개수
      if (reviewData.comments != null) {
        document.querySelector(".grade_area .join_count em").innerHTML =
          reviewData.comments.length + "건";
      }
    }
  };

  const MultiProductImages = function(productImageData) {
    this.setMultiProductImages(productImageData);
  };

  MultiProductImages.prototype = {
    productImageBox: document.querySelector(".visual_img"),
    slideIndex: 0,

    setMultiProductImages: function(productImageData) {
      addTemplate(
        document.getElementById("productImage"),
        document.querySelector(".visual_img"),
        productImageData
      );

      document.querySelector(".prev").className = "prev";
      document.querySelector(".nxt").className = "nxt";
      document.querySelector(".figure_pagination").children[1].innerText =
        "/ 2";

      MultiProductImages.prototype.createSlides();
    },

    createSlides: function() {
      MultiProductImages.prototype.slideIndex = 2;
      MultiProductImages.prototype.handleBoxTranslate(
        MultiProductImages.prototype.slideIndex
      );

      document
        .querySelector(".nxt_inn .btn_nxt")
        .addEventListener("click", function() {
          MultiProductImages.prototype.showSlides(
            MultiProductImages.prototype.slideIndex + 1
          );
        });

      document
        .querySelector(".prev_inn .btn_prev")
        .addEventListener("click", function() {
          MultiProductImages.prototype.showSlides(
            MultiProductImages.prototype.slideIndex - 1
          );
        });
    },

    showSlides: function(slideIndex) {
      MultiProductImages.prototype.slideIndex = slideIndex;
      document.querySelector(".figure_pagination").firstElementChild.innerText =
        MultiProductImages.prototype.slideIndex % 2 === 0 ? "1" : "2";
      MultiProductImages.prototype.productImageBox.style.transition = "0.3s";

      MultiProductImages.prototype.handleBoxTranslate(
        MultiProductImages.prototype.slideIndex
      );

      MultiProductImages.prototype.productImageBox.addEventListener(
        "transitionend",
        MultiProductImages.prototype.transitionProductImageBox
      );
    },

    transitionProductImageBox: function() {
      const BEGIN_INDEX = 0,
        END_INDEX = 3;

      if (MultiProductImages.prototype.slideIndex >= END_INDEX) {
        MultiProductImages.prototype.productImageBox.style.transition = "none";
        MultiProductImages.prototype.slideIndex = BEGIN_INDEX + 1;
      } else if (MultiProductImages.prototype.slideIndex <= BEGIN_INDEX) {
        MultiProductImages.prototype.productImageBox.style.transition = "none";
        MultiProductImages.prototype.slideIndex = END_INDEX - 1;
      }

      MultiProductImages.prototype.handleBoxTranslate(
        MultiProductImages.prototype.slideIndex
      );
    },

    handleBoxTranslate: function(translateIndex) {
      MultiProductImages.prototype.productImageBox.style.transform =
        "translate(-" + 100 * translateIndex + "%)";
    }
  };

  const ProductImage = function(productImageData) {
    this.setProductImageData(productImageData);
  };

  ProductImage.prototype = {
    setProductImageData: function(productImageData) {
      addTemplate(
        document.getElementById("productImage"),
        document.querySelector(".visual_img"),
        productImageData
      );

      //상품이미지 두개 이상이면
      if (productImageData.productImages.length > 1) {
        new MultiProductImages(productImageData);
      }

      document.querySelectorAll(".visual_txt_inn h2").forEach(function(span) {
        span.innerHTML = productImageData.displayInfo.productDescription;
      });

      document.querySelector(".detail_info_lst .in_dsc").innerHTML =
        productImageData.displayInfo.productContent;
    }
  };

  const setApiData = function(jsonData) {
    new ProductImage(jsonData);
    new Review(jsonData);
    new ProductInfo(jsonData);
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
        .querySelector(".btn_review_more")
        .setAttribute("href", "./review?displayInfoId=" + displayInfoId);
      document
        .querySelector(".my_reservation")
        .setAttribute("href", "./reserve?displayInfoId=" + displayInfoId);
    }
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

  const clickDescBtn = function() {
    $(".bk_more").toggle();
    $(".store_details").toggleClass("close3");
  };

  const initJS = function() {
    $(".bk_more").on("click", clickDescBtn);

    const displayInfoId = getParameterByName("displayInfoId");
    new DisplayInfo(displayInfoId);
  };

  initJS();
});
