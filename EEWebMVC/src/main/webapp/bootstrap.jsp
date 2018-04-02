<%--
  Created by IntelliJ IDEA.
  User: xiaob
  Date: 2018/3/31
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--页面标题-->
    <title>我不是真正的慕课网</title>
    <!--页面Logo-->
    <link rel="shortcut icon" href="<%=basePath%>images/voicecyber.ico"/>
    <!--引入bootstrap样式-->
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <h1>Hello World!Welcome, this is SpringMVC Bootstrap WebApp</h1>
</div>

<div align="center">

    <h1>上传附件</h1>
    <form method="post" action="/courses/doUpload" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>
</div>

<div align="center">
    <h1>上传多个附件</h1>
    <form method="post" action="/courses/doUpload2" enctype="multipart/form-data">
        <input type="file" name="file1"/>
        <br/>
        <input type="file" name="file2"/>
        <input type="submit"/>
    </form>

</div>

<!--引入jquery脚本-->
<script src="<%=basePath%>bootstrap/js/jquery.js" type="text/javascript"></script>
<!--引入bootstrap脚本-->
<script src="<%=basePath%>bootstrap/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>
