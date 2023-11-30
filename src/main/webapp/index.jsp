<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="/../css/style.css" rel="stylesheet">
    <title>Step-1</title>
</head>
<body>
<div class="header-container">
    <h2>Вітаємо в "Таємничій Одіссеї"!</h2>
</div>
<div>
    <p>У давні часи, в забутих глибинах лісу, було поселення, зване Елдрівілль. Легенди оповідають, що тут ховається
        древній артефакт, здатний втілювати найсміливіші мрії. Проте шлях до нього охороняють незліченні загадки та
        випробування.

        Ви – відважний дослідник, котрий вирішив розкрити таємницю Елдрівілля. Ваше завдання – розгадати древні загадки
        та випробування, розсіяні серед стін стародавніх руїн та забутих лісових стежок.

        Але будьте обережні! Кожен ваш вибір впливає на події, що розгортаються. Від вашої кмітливості, мудрості та
        відваги залежить, чи зможете ви розкрити таємниці Елдрівілля і знайти артефакт чи загубитеся у лабіринтах давніх
        таємниць.

        Почніть свою одіссею... зараз!</p>

    <div class="prompt">
        <h5 class="question">Готові розпочати 'Одіссею'?</h5>
        <div class="button-container">
            <form action="/first" method="post">
                <input type="hidden" name="answer" value="true"/>
                <button type="submit" class="agree">Погодитися</button>
            </form>
            <form action="/losefirst" method="post">
                <input type="hidden" name="answer" value="false"/>
                <button type="submit">Відмовитися</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
