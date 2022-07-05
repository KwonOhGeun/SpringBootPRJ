<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script>
        alert("<%=msg%>")
        location.href = "<%=url%>"
    </script>
        <meta charset="utf-8">
    <title></title>
</head>
<body>

</body>
</html>