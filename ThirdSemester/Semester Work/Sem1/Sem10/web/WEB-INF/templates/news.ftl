<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <meta charset="UTF-8">
    <title>Новости</title>
</head>
<body>

<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: -10px;">
            <li class=""><a style="color: red" href="/news">Новости</a></li>
            <li class=""><a href="/news">Купля-продажа</a></li>
            <li class=""><a href="/article">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/video">Видео</a></li>
            <li class=""><a href="/year_auto">Авто года</a></li>
            <li class=""><a href="/calc">Калькулятор</a></li>

        </ul>
    </nav>
</div>
<br/>
<table style="margin-left: 68%">

    <tr>
        <td>
            <button type="button" class="btn btn-default navbar-btn">Войти</button>
        </td>
        <td>
            <button type="button" class="btn btn-default navbar-btn">Регистрация</button>
        </td>
    </tr>
</table>

<div class="row  block-sales nosubmenu">
    <div class="col-lg-12 col-xs-12 text-center">
        <div class="outline-header fix__b-outlune" style="padding-bottom:10px; padding-top:10px">
            <h1>Новости</h1>

            <div>
            </div>
        </div>
    </div>
</div>
<table class="col-lg-12 col-xs-12 text-center parent" style="   margin-left:18%;  width: 65%">
<#if list??>
    <#list list as news>
        <#if news?counter%3==1>

    <tr><td>
            <div>
                <a style="text-decoration: none;"
                   href="${news.getUrl()}">
                    <div>
                        <div>
                            <img width="292" height="207" class="img-rounded"
                                 src="${news.getUrl_image()}"
                                 alt="${news.getName()}"></div>
                    </div>
                    <ol class="breadcrumb g-size-red">

                        <h2 class="post-title grid-title" style="text-decoration: none;">
                        ${news.getName()}</h2>

                        <div class="comments grid-i">
                            <i class="fa fa-eye"><span>${news.getViews()}</span></i>
                            <i class="fa fa-comment-o"><span>${news.getComments()]}</span></i>
                            <i style="float:right; margin-top: 4px;" class="fa fa-calendar"><span
                                    style="font-size: 9px; font-family: Arial, Helvetica, sans-serif;">${news.getDate()}</span></i>
                        </div>
                    </ol>
                </a>
            </div>
        </td>
        </#if>>
    <#if news?counter%3==0><td>
            <div>
                <a style="text-decoration: none;"
                   href="${news.getUrl()}">
                    <div>
                        <div>
                            <img width="292" height="207" class="img-rounded"
                                 src="${news.getUrl_image()}"
                                 alt="${news.getName()}"></div>
                    </div>
                    <ol class="breadcrumb g-size-red">

                        <h2 class="post-title grid-title" style="text-decoration: none;">
                        ${news['name']}</h2>

                        <div class="comments grid-i">
                            <i class="fa fa-eye"><span>${news.getViews()}</span></i>
                            <i class="fa fa-comment-o"><span>${news.getComments()}</span></i>
                            <i style="float:right; margin-top: 4px;" class="fa fa-calendar"><span
                                    style="font-size: 9px; font-family: Arial, Helvetica, sans-serif;">${news.getDate(  )}</span></i>
                        </div>
                    </ol>
                </a>
            </div>
        </td></tr></#if>
</#list>
</#if>

</table>
<ul class="pagination parent">
<#list 1..${pages} as i>
    <li class=""><a href="news/page/${i}">${i}<span class="sr-only">(current)</span></a></li>
</#list>


</ul>
<ul class="pager">
    <li><a href="#">Предыдущая</a></li>
    <li><a href="#">Следующая</a></li>
</ul>
</body>
</html>