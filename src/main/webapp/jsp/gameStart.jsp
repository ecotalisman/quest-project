<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link href="/../css/style.css" rel="stylesheet">
    <title>Game Start</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="header-container centered-text">
    <h3>${answer}</h3>
</div>
<div class="centered-text">
    <div class="prompt">
    <p>
        Ваша віртуальна подорож до Елдрівілля обіцяє бути захоплюючою та непередбачуваною.
        Ось завдання, які ви, як відважний дослідник, можете виконати у своїй місії пошуку древнього артефакту:
    </p>
    <h4>Завдання 1: Таємниця Забороненого Колодязя</h4>
        <h4>Опис завдання:</h4>
            <p>У центрі Елдрівілля знаходиться заборонений колодязь, відомий як "Око Світу". Він містить загадкові рунічні
            символи, які вказують на місцезнаходження ключа до артефакту. Однак, щоб розшифрувати ці символи, вам
            потрібно виконати серію завдань, щоб знайти спеціальні окуляри, які дозволять вам "бачити" справжній
            зміст цих рун.</p>
        <div class="task-details">
            <h4>Виконання завдання:</h4>
            <ol class="task-list">
                <li>Знайдіть мудреця села, щоб отримати карту до загубленого храму.</li>
                <li>В храмі вам потрібно розгадати головоломку із древніх символів, щоб отримати частину окулярів.</li>
                <li>Другу частину окулярів зберігає старий лісовий чаклун, який вимагатиме від вас виконати завдання за зібрання рідкісних трав для його зілля.</li>
            </ol>
        </div>
        <div class="button-container">
            <form action="/game" method="post">
                <label for="name">Введіть ваше ім'я:</label>
                <input type="text" id="name" name="name" required>
                <input type="hidden" name="answer" value="true"/>
                <button type="submit" class="agree">Виконати всі завдання</button>
            </form>
            <form action="/game-failure" method="post">
                <input type="hidden" name="answer" value="false"/>
                <button type="submit">Відмовитися</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
