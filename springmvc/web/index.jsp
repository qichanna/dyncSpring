<%--
  Created by IntelliJ IDEA.
  User: liqi
  Date: 2016/5/30
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>trst</title>
  </head>
  <body>
  <form action="<%=request.getContextPath() %>/liqi/viewAll" method="post">
    用户名:<input type="text" name="name">
    密码:<input type="password" name="pwd">
    <input type="submit" value="提交">
  </form>
  </body>
</html>
