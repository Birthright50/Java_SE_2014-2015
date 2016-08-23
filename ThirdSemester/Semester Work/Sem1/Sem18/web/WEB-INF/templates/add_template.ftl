<!doctype html>
<html lang="en">
<head>

    <title>Add Template</title>
    <script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
    <script src="/js/modernizr.js"></script>
    <script src="/js/main.js"></script>
    <meta charset="UTF-8" content="multipart/form-data; UTF-8">
</head>
<body>
<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
            >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a href="/news">Новости</a></li>
            <li class=""><a href="/buy">Купля-продажа</a></li>
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

<form  enctype="multipart/form-data" accept-charset="UTF-8"  action="/add_template" method="post"
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
        <input class="full-width" onclick="return add_page()" type="submit" value="Добавить">
    </p>
</form>
<script type="text/javascript">
    function add_page() {
        var radio = $('#radio');
        var name = $('#name');
        var page = $('#page');
        var img = $('#img');
        if (name.val().length > 2 && img.val().length != 0 && page.val().length > 100) {
            return true;
        }
        alert("Не заполнено имя / не выбран превью-файл / HTML-код меньше 100 символов");
        return false;
    }
</script>
</body>
</html>