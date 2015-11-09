<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Template</title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
</head>
<body>
<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a href="/news">Новости</a></li>
            <li class=""><a href="/news">Купля-продажа</a></li>
            <li class=""><a href="/articles">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/videos">Видео</a></li>

            <li class=""><a href="/custom_calculator">Калькулятор</a></li>

        </ul>
    </nav>
</div>

<nav class="main-nav" style="margin-right: 20%">
    <ul>

        <li><a class="cd-login" href="/profile">Профиль</a></li>
        <li><a class="cd-logout" href="/logout">Выход</a></li>
    </ul>
</nav>
<br/><br/><br/><br/><br/>

<form enctype="multipart/form-data" action="/add_template" method="post"
      style="width: 50%; margin-left: 25%">
    <div class="form-group">
        <label for="name">Название</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="radio">
        <label><input type="radio" value="1" id="radio" checked name="optradio">Новость</label>
    </div>
    <div class="radio">
        <label><input type="radio" value="2" id="radio" name="optradio">Статья</label>
    </div>
    <div class="radio">
        <label><input type="radio" value="3" id="radio" name="optradio">Видео</label>
    </div>
    <div class="form-group">
        <label for="img">Превью</label>
        <input type="File" name="image" id="img">
    </div>
    <div class="form-group">
        <label for="page">Содержимое</label>
        <textarea placeholder="Enter HTML-code here" name="page" class="form-control" rows="5" id="page"></textarea>
    </div>
    <p class="fieldset">
        <input class="full-width" onclick="return submit()" type="submit" value="Login">
    </p>

</form>
<script type="text/javascript">
    submit = function () {
        var radio = $('#radio');
        alert("fdsfsdf");
        var name = $('#name');
        var page = $('#page');
        return false;
        if (name.val() != '' && page.val().length > 100) {
            alert("232323");
            return true;
        }
        else {
            alert("Что-то не заполнено");
            return false;
        }
    }
</script>
</body>
</html>