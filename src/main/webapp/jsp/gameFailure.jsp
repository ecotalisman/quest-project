<%@ page import="constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="/../css/style.css" rel="stylesheet">
    <title>Finish</title>
</head>
<body>
<div class="header-container centered-text">
    <h3>${answer}</h3>
</div>
<div class="centered-text">
    <div class="prompt">
        <c:set var="gameStartFailure" value="<%= Constants.STEP_START_NOT_ACCEPTED %>" />
        <c:set var="gameChallengeFailure" value="<%= Constants.STEP_1_NOT_ACCEPTED %>" />
        <c:set var="gameFinishFailure" value="<%= Constants.STEP_2_NOT_ACCEPTED %>" />

        <c:if test="${answer == gameStartFailure}">
            <h4>Ваша 'Одіссея' закінчена.</h4>
        </c:if>

        <c:if test="${answer == gameChallengeFailure}">
            <h4>Вашої хоробрості та мудрості не вистачило для пошуку артефакту "Око Світу"...</h4>
        </c:if>

        <c:if test="${answer == gameFinishFailure}">
            <h4>Сили покинули вас після тяжких випробувань, нехай щастить!</h4>
        </c:if>
    </div>
    <div class="button-container">
        <form action="/restart" method="get">
            <button type="submit" class="agree">Почати гру спочатку</button>
        </form>
    </div>
</div>
</body>
</html>
