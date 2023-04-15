<%--
  Created by IntelliJ IDEA.
  User: CHCOVER
  Date: 2023/4/12
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%
    //    String path = request.getContextPath();
    String path = "ueditor";
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + path + "/";
    System.out.println(basePath + " " + path);
%>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/saveUeditor" method="post">
    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain">
            这里写你的初始化内容
    </script>
    <input type="submit">
</form>

<!-- 配置文件 -->
<script type="text/javascript" src="<%=basePath%>ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=basePath%>ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container');
</script>
</body>
</html>
