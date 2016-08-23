<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="application/javascript" src="/js/jquery-2.1.4.js">
    </script>
    <script type="application/javascript" src="/js/bootstrap.min.js">
    </script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

</head>
<body>
<div class="col-lg-6 col-lg-offset-3">
    <div class="input-group">
        <input id="s" oninput="f()" type="text" class="form-control">
        <div class="input-group-btn">
            <button id="entity" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                Действие<span
                    class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">Students</a></li>
                <li><a href="#">Teachers</a></li>
                <li><a href="#">Classes</a></li>
            </ul>
        </div>
    </div>
    <div align="center"  id="res"></div>
</div>
<script type="application/javascript">
    $('.dropdown-menu a').on('click', function(){
        $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');
    })
</script>


<script type="application/javascript">
    f = function (request, response) {
        var s = $("#s");
        if (s.val().length > 0)
            $.ajax({
                url: "/search",
                data: {"q": s.val(), "entity": $("#entity").text()},
                dataType: "json",
                success: function (resp) {
                    var res = $("#res");
                    if (resp.results.length > 0) {
                        res.text("Yes results.");
                        for (var i = 0; i < resp.results.length; i++) {
                            res.append("<li>" + resp.results[i] + "</li>");
                        }
                    } else {
                        res.text("No results.");
                    }
                }
            });
    }
</script>
</body>
</html>