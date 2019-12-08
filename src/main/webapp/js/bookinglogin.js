document.addEventListener("DOMContentLoaded", function() {
  const InputValidation = function() {};

  InputValidation.prototype = {
    checkInput: function(userInput) {
      const testValid = !InputValidation.prototype
        .getRegExp()
        .test(userInput.value);

      if (!InputValidation.prototype.isFilled(userInput)) {
        return false;
      } else if (testValid) {
        userInput.nextElementSibling.innerHTML = InputValidation.prototype.getErrorMsg();
        return false;
      } else {
        userInput.nextElementSibling.innerHTML = "";
        return true;
      }
    },

    isFilled: function(userInput) {
      if (userInput.value === "") {
        userInput.nextElementSibling.innerHTML = "필수 정보입니다";
        return false;
      } else {
        userInput.nextElementSibling.innerHTML = "";
        return true;
      }
    },

    getRegExp: function() {
      return /^[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
    },

    getErrorMsg() {
      return "이메일 형식을 확인해주세요";
    }
  };

  const LoginBtn = function() {
    this.registerEvent();
  };

  LoginBtn.prototype = {
    loginBtn: document.querySelector(".login_btn.confirm"),

    registerEvent: function() {
      LoginBtn.prototype.loginBtn.addEventListener(
        "click",
        LoginBtn.prototype.clickLoginBtn
      );
    },

    clickLoginBtn: function() {
      event.preventDefault();

      const emailInput = document.querySelector(".login_input");
      const emailForm = document.querySelector("#form1");

      const inputValidation = new InputValidation();
      if (!inputValidation.checkInput(emailInput)) return;

      LoginBtn.prototype.sendForm(emailForm);
    },

    sendForm: function(emailForm) {
      emailForm.submit();
    }
  };

  const initJS = function() {
    new LoginBtn();
  };

  initJS();
});
