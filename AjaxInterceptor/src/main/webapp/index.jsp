<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type="text/javascript" src="js/libs/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/interceptor.js"></script>
        <script>
            function ajaxContent()
            {
                var xmlhttp;
                xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function()
                {
                    alert('Actual ready');
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        var resp = xmlhttp.responseText;
                        alert(resp);
                    }
                }
                xmlhttp.open("GET", "success.jsp", true);
                xmlhttp.send();
            }

            function jqueryAjaxContent() {
                $.ajax(
                        {
                            url: "success.jsp",
                            success: function(result) {
                                alert('J ' + result);
                            }
                        });
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <button name="Regular" value="Regular" onclick="ajaxContent()">Regular</button>
        <button name="JQuery" value="JQuery" onclick="jqueryAjaxContent()">JQuery</button>
    </body>
</html>
