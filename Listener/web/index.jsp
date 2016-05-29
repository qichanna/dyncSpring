<%@ page import="java.util.ArrayList" %>
<%@ page import="liqi.User" %><%--
  Created by IntelliJ IDEA.
  User: liqi
  Date: 2016/5/29
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>统计在线人数</title>
  </head>
  <body>
  总在线人数 ${userNumber} <br/>
  <%
    ArrayList<User> userList = (ArrayList<User>) request.getServletContext().getAttribute("userList");
    if(userList != null){
      for (int i = 0; i < userList.size(); i++) {
        User user = userList.get(i);
  %>
  IP:<%=user.getIpString()  %>,FirstTime:<%=user.getFirstTimeString()%>,SessionId:<%=user.getSessionIdString() %> <br/>
  <%}}  %>
  </body>
</html>
