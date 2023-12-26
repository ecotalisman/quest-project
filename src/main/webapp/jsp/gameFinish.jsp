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
        <p>Ваша неймовірна подорож дійшла кінця - ви здобули артефакт "Амулет Часу". Ви з честю впорались із двома захопливими
            завданнями, занурившись у світ магії та таємниць Елдрівілля. Ваша відвага та кмітливість відкрили нові горизонти у цій
            чарівній мандрівці, де кожен крок був наповнений загадковістю і дивами. Ця подорож не тільки випробувала
            ваші здібності, а й відкрила перед вами світ незбагненних таємниць, що завжди залишатимуться у вашому серці
            як чарівні спогади.</p>
    </div>
    <div class="button-container">
        <form action="/" method="get">
            <button type="submit" class="agree">Розпочати гру знову</button>
        </form>
    </div>
</div>
</body>
</html>
