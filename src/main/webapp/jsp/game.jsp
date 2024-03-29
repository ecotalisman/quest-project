<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link href="/../css/style.css" rel="stylesheet">
    <title>Game</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="header-container centered-text">
    <h3>${answer}</h3>
</div>
<div class="centered-text">
    <div class="prompt">
    <p>
        Ваша подорож до Елдрівілля проходить захопливо. Як відважний дослідник ви отримали артефакт "Око Світу".
        Тепер розпочинається місія пошуку древнього артефакту:
    </p>
    <h4>Завдання 2: Лабіринт Тіней</h4>
        <h4>Опис завдання:</h4>
            <p>На південному краю Елдрівілля знаходиться Лабіринт Тіней, древній підземний комплекс, що веде до місця, де,
                як вважається, зберігається артефакт. Пройти крізь лабіринт не так просто, оскільки він сповнений пасток та загадок.
                <br>
                Лабіринт Тіней, загадкове і таємниче місце у вашій історії, може ховати в собі артефакт, здатний змінювати саму суть реальності.
                Цей артефакт – Амулет Часу, який дозволяє своєму власнику маніпулювати часом. Він не тільки надає здатність подорожувати в часі,
                але й дає можливість зупиняти або прискорювати хід часу в окремих моментах, роблячи власника надзвичайно могутнім.
                <br>
                Амулет відрізняється унікальним дизайном: він має форму годинникового механізму з давніми рунами, викарбуваними навколо циферблату, що
                світяться під місячним світлом. Саме ці руни і є ключем до активації його сили. Проте, артефакт не може бути використаний без відповідної
                мудрості та обережності, адже з його допомогою можна ненароком змінити хід історії чи власне життя.</p>
        <div class="task-details">
            <h4>Виконання завдання:</h4>
            <ol class="task-list">
                <li>Зберіть команду місцевих дослідників, які знають таємниці лабіринту.</li>
                <li>Пройдіть через лабіринт, вирішуючи загадки та уникаючи пасток.</li>
                <li>В кінці лабіринту вас чекає головна загадка, яка веде до кришталевої кімнати, де, за легендами, зберігається артефакт.</li>
            </ol>
        </div>
            <p>Кожне з цих завдань вимагає не тільки сміливості та рішучості, але й кмітливості та глибокого знання старовинних легенд та загадок.
                Вибір за вами, яке завдання взяти на себе спершу, але пам'ятайте, що часу обмаль, а інші мисливці за скарбами можуть вже йти за вами.
                Удачі у вашій Одіссеї!</p>
            <p></p>
        <div class="button-container">
            <form action="/finish" method="post">
                <input type="hidden" name="answer" value="true"/>
                <button type="submit" class="agree">Виконати всі завдання</button>
            </form>
            <form action="/finish-failure" method="post">
                <input type="hidden" name="answer" value="false"/>
                <button type="submit">Відмовитися</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
