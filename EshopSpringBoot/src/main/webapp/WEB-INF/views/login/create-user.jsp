<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <style>
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<div class="login-box">
    <form modelAttribute="user" action="/create-user" method="post" class="registration">
        <h1>Register form</h1>
        <div class="user-box">
            <label for="login">
                <span>Login</span>
                <input type="text" name="login" required="" id="login">
                <span class="error">${loginError}</span>
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
                <span class="error">${passwordError}</span>
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
                <span class="error">${verifyPasswordError}</span>
                <ul class="input-requirements">
                    <li>Must repeat the password</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="name">
                <span>Name</span>
                <input type="text" name="name" required="" id="name">
                <span class="error">${nameError}</span>
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
                <span class="error">${surnameError}</span>
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
                <span class="error">${emailError}</span>
                <ul class="input-requirements">
                    <li>Must comply with the standard of email addresses</li>
                </ul>
            </label>
        </div>
        <div class="user-box">
            <label for="birthday">
                <span>birthday</span>
                <input type="date" name="birthday" required="" id="birthday">
                <span class="error">${birthdayError}</span>
                <ul class="input-requirements">
                    <li>The user must be over 18 years old</li>
                </ul>
            </label>
        </div>
        <div style="margin-top: 15px">
            <input type="submit" value="Register" class='validateBtn'/>
        </div>
        <a href="/login" class="buttonType">Back</a>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/validate.js"></script>
</body>
</html>