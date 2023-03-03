<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value="/css/register.css"/>">
</head>
<body>
<div class="login-box">
    <form action="<c:url value="/create-user"/>" method="post" class="registration">
        <h1>Register form</h1>
        <div class="user-box">
            <label for="login">
                <span>Login</span>
                <input type="text" name="login" required="" id="login">
                <ul class="input-requirements">
                    <li>At least 4 characters long</li>
                    <li>Must only contain letters and numbers (no special characters)</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="password">
                <span>Password</span>
                <input type="password" name="password" required="" id="password">
                <ul class="input-requirements">
                    <li>At least 4 characters long (and less than 30 characters)</li>
                    <li>Contains at least 1 number</li>
                    <li>Contains at least 1 lowercase letter</li>
                    <li>Contains at least 1 uppercase letter</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="password_repeat">
                <span>Confirm password</span>
                <input type="password" name="verifyPassword" required="" id="password_repeat">
                <ul class="input-requirements">
                    <li>Must repeat the password</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="name">
                <span>Name</span>
                <input type="text" name="name" required="" id="name">
                <ul class="input-requirements">
                    <li>At least 3 characters long</li>
                    <li>Must only contain letters (no special characters)</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="surname">
                <span>Surname</span>
                <input type="text" name="surname" required="" id="surname">
                <ul class="input-requirements">
                    <li>At least 3 characters long</li>
                    <li>Must only contain letters (no special characters)</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="email">
                <span>Email</span>
                <input type="text" name="email" id="email" required="" id="email">
                <ul class="input-requirements">
                    <li>Must comply with the standard of email addresses</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="birthday">
                <span>birthday</span>
                <input type="date" name="birthday" required="" id="birthday">
                <ul class="input-requirements">
                    <li>The user must be over 18 years old</li>
                </ul>
            </label>
        </div>
        <div style="margin-top: 15px">
            <input type="submit" value="Register" class='validateBtn'/>
        </div>
        <a href="<c:url value="/login"/>" class="buttonType">Back</a>
    </form>
</div>
<script>
  function CustomValidation() {
    this.invalidities = [];
    this.validityChecks = [];
  }

  CustomValidation.prototype = {
    addInvalidity: function (message) {
      this.invalidities.push(message);
    },
    getInvalidities: function () {
      return this.invalidities.join('. \n');
    },
    checkValidity: function (input) {
      for (var i = 0; i < this.validityChecks.length; i++) {
        var isInvalid = this.validityChecks[i].isInvalid(input);
        if (isInvalid) {
          this.addInvalidity(this.validityChecks[i].invalidityMessage);
        }
        var requirementElement = this.validityChecks[i].element;
        if (requirementElement) {
          if (isInvalid) {
            requirementElement.classList.add('invalid');
            requirementElement.classList.remove('valid');
          } else {
            requirementElement.classList.remove('invalid');
            requirementElement.classList.add('valid');
          }
        }
      }
    }
  };
  var loginValidityChecks = [
    {
      isInvalid: function (input) {
        return input.value.length < 4;
      },
      invalidityMessage: 'This input needs to be at least 4 characters',
      element: document.querySelector(
          'label[for="login"] .input-requirements li:nth-child(1)')
    },
    {
      isInvalid: function (input) {
        var illegalCharacters = input.value.match(/[^a-zA-Z0-9]/g);
        return illegalCharacters ? true : false;
      },
      invalidityMessage: 'Only letters and numbers are allowed',
      element: document.querySelector(
          'label[for="login"] .input-requirements li:nth-child(2)')
    }
  ];
  var passwordValidityChecks = [
    {
      isInvalid: function (input) {
        return input.value.length < 4 | input.value.length > 30;
      },
      invalidityMessage: 'This input needs to be between 4 and 30 characters',
      element: document.querySelector(
          'label[for="password"] .input-requirements li:nth-child(1)')
    },
    {
      isInvalid: function (input) {
        return !input.value.match(/[0-9]/g);
      },
      invalidityMessage: 'At least 1 number is required',
      element: document.querySelector(
          'label[for="password"] .input-requirements li:nth-child(2)')
    },
    {
      isInvalid: function (input) {
        return !input.value.match(/[a-z]/g);
      },
      invalidityMessage: 'At least 1 lowercase letter is required',
      element: document.querySelector(
          'label[for="password"] .input-requirements li:nth-child(3)')
    },
    {
      isInvalid: function (input) {
        return !input.value.match(/[A-Z]/g);
      },
      invalidityMessage: 'At least 1 uppercase letter is required',
      element: document.querySelector(
          'label[for="password"] .input-requirements li:nth-child(4)')
    }
  ];
  var passwordRepeatValidityChecks = [
    {
      isInvalid: function () {
        return passwordRepeatInput.value != passwordInput.value;
      },
      invalidityMessage: 'This password needs to match the first one'
    }
  ];
  var nameValidityChecks = [
    {
      isInvalid: function (input) {
        return input.value.length < 3;
      },
      invalidityMessage: 'This input needs to be at least 4 characters',
      element: document.querySelector(
          'label[for="name"] .input-requirements li:nth-child(1)')
    },
    {
      isInvalid: function (input) {
        var illegalCharacters = input.value.match(/[^a-zA-Z]/g);
        return illegalCharacters ? true : false;
      },
      invalidityMessage: 'Only letters are allowed',
      element: document.querySelector(
          'label[for="name"] .input-requirements li:nth-child(2)')
    }
  ];
  var surnameValidityChecks = [
    {
      isInvalid: function (input) {
        return input.value.length < 3;
      },
      invalidityMessage: 'This input needs to be at least 4 characters',
      element: document.querySelector(
          'label[for="surname"] .input-requirements li:nth-child(1)')
    },
    {
      isInvalid: function (input) {
        var illegalCharacters = input.value.match(/[^a-zA-Z]/g);
        return illegalCharacters ? true : false;
      },
      invalidityMessage: 'Only letters are allowed',
      element: document.querySelector(
          'label[for="surname"] .input-requirements li:nth-child(2)')
    }
  ];
  var emailValidityChecks = [
    {
      isInvalid: function (input) {
        var illegalCharacters = input.value.match(
            /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/g);
        return illegalCharacters ? false : true;
      },
      invalidityMessage: 'Must comply with the standard of email addresses',
      element: document.querySelector(
          'label[for="email"] .input-requirements li:nth-child(1)')
    }
  ];
  var birthdayValidityChecks = [
    {
      isInvalid: function (input) {
        var date = new Date(input.value);
        return new Date().getFullYear() - date.getFullYear() < 18;
      },
      invalidityMessage: 'The user must be over 18 years old',
      element: document.querySelector(
          'label[for="birthday"] .input-requirements li:nth-child(1)')
    }
  ];

  function checkInput(input) {

    input.CustomValidation.invalidities = [];
    input.CustomValidation.checkValidity(input);

    if (input.CustomValidation.invalidities.length == 0 && input.value != '') {
      input.setCustomValidity('');
    } else {
      var message = input.CustomValidation.getInvalidities();
      input.setCustomValidity(message);
    }
  }

  var loginInput = document.getElementById('login');
  var passwordInput = document.getElementById('password');
  var passwordRepeatInput = document.getElementById('password_repeat');
  var nameInput = document.getElementById('name');
  var surnameInput = document.getElementById('surname');
  var emailInput = document.getElementById('email');
  var birthdayInput = document.getElementById('birthday');
  loginInput.CustomValidation = new CustomValidation();
  loginInput.CustomValidation.validityChecks = loginValidityChecks;
  passwordInput.CustomValidation = new CustomValidation();
  passwordInput.CustomValidation.validityChecks = passwordValidityChecks;
  passwordRepeatInput.CustomValidation = new CustomValidation();
  passwordRepeatInput.CustomValidation.validityChecks = passwordRepeatValidityChecks;
  nameInput.CustomValidation = new CustomValidation();
  nameInput.CustomValidation.validityChecks = nameValidityChecks;
  surnameInput.CustomValidation = new CustomValidation();
  surnameInput.CustomValidation.validityChecks = surnameValidityChecks;
  emailInput.CustomValidation = new CustomValidation();
  emailInput.CustomValidation.validityChecks = emailValidityChecks;
  birthdayInput.CustomValidation = new CustomValidation();
  birthdayInput.CustomValidation.validityChecks = birthdayValidityChecks;
  var inputs = document.querySelectorAll('input:not([type="submit"])');
  var submit = document.querySelector('input[type="submit"');
  for (var i = 0; i < inputs.length; i++) {
    inputs[i].addEventListener('keyup', function () {
      checkInput(this);
    });
  }
  submit.addEventListener('click', function () {
    for (var i = 0; i < inputs.length; i++) {
      checkInput(inputs[i]);
    }
  });
</script>
</body>
</html>