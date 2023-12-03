<%@ page import="com.example.javawebgyak2.FilteredModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: GamerKick
  Date: 2023-12-03
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FilterPage</title>
</head>
<body>
<%
    ArrayList<FilteredModel> filtered = (ArrayList<FilteredModel>) request.getSession().getAttribute("filtered");
%>
<h2>Kulcsszavak mefelelnek:</h2>
<table>
    <tr>
        <th>Tulajdonos</th>
        <th>Név</th>
        <th>Ár</th>
        <th>Lefoglalás</th>
    </tr>
    <%
        for (FilteredModel f:filtered) {
    String url = "<a href='res-servlet?id="+f.getProduct().getName()+"'>Lefoglalás</a>";
    %>
    <tr>
        <td><%=f.getOwner().getEmail()%></td>
        <td><%=f.getProduct().getName()%></td>
        <td><%=f.getProduct().getPrice()%></td>
        <td><%=f.getProduct().getReservedby()!=null?"Foglalt":url%></td>
    </tr>
       <% } %>
</table>
</body>
</html>
