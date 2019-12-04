document.addEventListener("DOMContentLoaded", function() {
  //더보기 버튼
  const moreBtn = document.querySelector(".more .btn");

  const PRODUCT_PER_PAGE = 4;
  const PRODUCT_DEFAULT_START = 0;
  const ALL_CATEGORIES = 0;

  let startProductIndex = PRODUCT_DEFAULT_START;
  let categoryId = ALL_CATEGORIES;

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

  const className = new ClassName();

  const addTemplate = function(origTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(origTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  };

  const Promotion = function(promotionData) {
    this.sliderBox = document.querySelector(".visual_img");
    this.slideIndex = 0;
    this.setPromotionData(promotionData);
  };

  Promotion.prototype = {
    setPromotionData: function(promotionData) {
      addTemplate(
        document.querySelector("#promotionList"),
        this.sliderBox,
        promotionData
      );

      this.createSlides(promotionData.items.length, this.sliderBox);
    },

    createSlides: function(totalPromotionCount, sliderBox) {
      const SLIDE_INTERVAL = 1500;

      setInterval(
        function() {
          this.showSlides(totalPromotionCount, sliderBox);
        }.bind(this),
        SLIDE_INTERVAL
      );
    },

    showSlides: function(totalPromotionCount, sliderBox) {
      sliderBox.style.transition = "0.3s";
      this.slideIndex++;

      sliderBox.addEventListener(
        "transitionend",
        function() {
          if (this.slideIndex >= totalPromotionCount) {
            this.slideIndex = 0;
            sliderBox.style.transition = "none";
            sliderBox.style.transform = "translate(0%)";
          }
        }.bind(this)
      );

      sliderBox.style.transform = "translate(-" + 100 * this.slideIndex + "%)";
    }
  };

  const MoreBtn = function() {
    //더보기버튼
    this.moreBtn = document.querySelector(".more .btn");

    this.registerEvent();
  };

  MoreBtn.prototype = {
    registerEvent: function() {
      this.moreBtn.addEventListener("click", this.clickMoreBtn);
    },

    clickMoreBtn: function() {
      //더보기 버튼 누를 때마다 startProductIndex +4
      startProductIndex += PRODUCT_PER_PAGE;

      getProductApi(categoryId, startProductIndex);
    },

    hideMoreBtn: function() {
      className.addClass(moreBtn, "hide");
    },

    showMoreBtn: function() {
      className.removeClass(moreBtn, "hide");
    }
  };

  const Product = function(productData, start) {
    //본문 좌우 박스
    this.eventBoxes = document.querySelectorAll(".lst_event_box");

    //받아오는 데이터 수
    this.itemCount = productData.items.length;

    this.setProductData(productData, start);
  };

  Product.prototype = {
    setProductData: function(productData, start) {
      //카테고리 탭 바뀌면 상품목록 초기화
      if (start === 0) this.initProductData();

      //총 개수 세팅
      let countSpan = document.querySelector(".event_lst_txt span");
      countSpan.innerHTML = productData.totalCount + "개";

      //좌우 위치 정하는 인덱스
      const halfIndex = parseInt((this.itemCount + 1) / 2);

      productData.items.forEach(
        function(item, index) {
          if (index < halfIndex) {
            addTemplate(
              document.getElementById("itemList"),
              this.eventBoxes[0],
              item
            );
          } else {
            addTemplate(
              document.getElementById("itemList"),
              this.eventBoxes[1],
              item
            );
          }
        }.bind(this)
      );

      // 가져온 데이터가 4개 미만 OR 아이템 리스트 = 총 개수가 되면 더보기버튼 사라짐
      if (
        this.itemCount < PRODUCT_PER_PAGE ||
        document.querySelectorAll(".wrap_event_box li").length ===
          productData.totalCount
      ) {
        MoreBtn.prototype.hideMoreBtn();
      }
    },

    initProductData: function() {
      this.eventBoxes.forEach(function(eventBox) {
        eventBox.innerHTML = "";
      });
    }
  };

  const Category = function() {
    this.getCategoryId(event.target.tagName);
    this.changeCategoryColor(event.target.tagName);
  };

  Category.prototype = {
    getCategoryId: function(clickedTag) {
      let targetSpan;

      if (clickedTag === "SPAN") {
        targetSpan = event.target;
      } else if (clickedTag === "A") {
        targetSpan = event.target.firstElementChild;
      }

      categoryId = targetSpan.parentNode.parentNode.getAttribute(
        "data-category"
      );

      getProductApi(categoryId, PRODUCT_DEFAULT_START);
    },

    changeCategoryColor: function(clickedTag) {
      const categories = document.querySelectorAll(".event_tab_lst .item");

      //전체 카테고리 active 클래스 제거
      categories.forEach(function(category) {
        className.removeClass(category.firstElementChild, "active");
      });

      //클릭한 카테고리에만 active클래스 추가 (target case 나눠서)
      let targetAnchor = null;

      if (clickedTag === "SPAN") {
        targetAnchor = event.target.parentElement;
      } else if (clickedTag === "A") {
        targetAnchor = event.target;
      }

      className.addClass(targetAnchor, "active");
    }
  };

  const Tab = function() {
    this.tabUl = document.querySelector(".event_tab_lst");
    this.registerEvent();
  };

  Tab.prototype = {
    registerEvent: function() {
      this.tabUl.addEventListener("click", this.clickTabBtn);
    },

    clickTabBtn: function() {
      if (event.target.tagName !== "SPAN" && event.target.tagName !== "A")
        return;

      //더보기 버튼 보이게
      MoreBtn.prototype.showMoreBtn();

      //startNum 초기화
      startProductIndex = PRODUCT_DEFAULT_START;

      new Category();
    }
  };

  const setApiData = function(jsonData, url, start) {
    //url 주소로 구분
    if (url.indexOf("products") != -1) {
      new Product(jsonData, start);
      new MoreBtn();
    } else {
      new Promotion(jsonData);
    }
  };

  const sendAjax = function(url, start) {
    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      setApiData(jsonData, url, start);
    });

    oReq.open("GET", url);
    oReq.send();
  };

  const getPromotionApi = function() {
    sendAjax("./api/promotions");
  };

  const getProductApi = function(categoryId, start) {
    sendAjax(
      "./api/products?categoryId=" + categoryId + "&start=" + start,
      start
    );
  };

  const initJS = function() {
    new Tab();
    getProductApi(ALL_CATEGORIES, PRODUCT_DEFAULT_START);
    getPromotionApi();
  };

  initJS();
});
