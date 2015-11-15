<!doctype html>
<html lang="en">
<head>

    <title>Add Ad</title>
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

<form enctype="multipart/form-data" accept-charset="UTF-8" action="/add_ad" method="post"
      style="width: 50%; margin-left: 25%">
    <div class="form-group">
        <label for="name">Название авто</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="form-group">
        <label for="probeg">Пробег (в км)</label>
        <input type="number" class="form-control" id="probeg" name="probeg">
    </div>
    <div class="form-group">
        <label for="year">Год выпуска</label>
        <input type="number" class="form-control" id="year" name="year">
    </div>
    <div class="form-group">
        <label for="price">Цена (в руб.)</label>
        <input type="number" class="form-control" id="price" name="price">
    </div>
    <div class="form-group">
        <label for="city">Город</label>
        <input type="text" class="form-control" id="city" name="city">
    </div>
    <div class="form-group">
        <label for="img1">Фото №1</label>
        <input type="File" name="img1" id="img1">
    </div>
    <div class="form-group">
        <label for="img2">Фото №2</label>
        <input type="File" name="img2" id="img2">
    </div>
    <div class="form-group">
        <label for="img3">Фото №3</label>
        <input type="File" name="img3" id="img3">
    </div>
    <div class="form-group">
        <label for="img4">Фото №4</label>
        <input type="File" name="img4" id="img4">
    </div>
    <div class="form-group">
        <label for="img5">Фото №5</label>
        <input type="File" name="img5" id="img5">
    </div>
    <div class="form-group">
        <label for="text">Описание авто</label>
        <textarea name="text" class="form-control" rows="5" id="text"></textarea>
    </div>
    <p class="fieldset">
        <input class="full-width" onclick="return add_page()" type="submit" value="Добавить">
    </p>
</form>
<script type="text/javascript">
    function add_page() {
        var name = $('#name');
        var probeg = $('#probeg');
        var price = $('#price');
        var year = $('#year');
        var city = $('#city');
        var img1 = $('#img1');
        var img2 = $('#img2');
        var img3 = $('#img3');
        var img4 = $('#img4');
        var img5 = $('#img5');
        var text = $('#text');
        if (name.val().length > 5 && img1.val().length != 0 && img2.val().length != 0 && img3.val().length != 0 && img4.val().length != 0 && img5.val().length != 0
                && text.val().length > 50 && city.val().length > 3 && year.val() > 1900 && year.val() < 2016 && price.val().length > 0 && probeg.val().length>0) {
            return true;
        }
        alert("Что-то не заполнено");
        return false;
    }
</script>
</body>
</html>