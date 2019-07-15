<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2019/6/8
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                // $.ajax({
                //     url: 'demo',
                //     data: {"name": "张三"},
                //     dataType: 'html',
                //     error: function () {
                //         alert("请求出错")
                //     },
                //     success: function (data) {
                //         alert("请求成功" + data)
                //     },
                //     type: 'POST'
                // });
                // $.get("demo", {"name": "123"}, function (data) {
                //     alert(data)
                // })

                $.post("demo",{"name":"张三"},function (data) {
                    var result="";
                    for (var i = 0; i <data.length ; i++) {
                        result+="<tr>";
                        result+="<td>"+data[i].id+"</td>"
                        result+="<td>"+data[i].name+"</td>"
                        result+="<td>"+data[i].pwd+"</td>"
                        result+="</tr>";
                    }
                    $("#tbody").html(result);
                })
                    // [{"name":"张三","pwd":"123"},{"name":"张三","pwd":"123"}]
                return false;
            })
        });
    </script>
</head>
<body>
<a >请求</a></body>
<table border="1 #7fffd4" style="align-items: center">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>PWD</td>
    </tr>
    <tbody id="tbody"></tbody>
</table>
</html>
