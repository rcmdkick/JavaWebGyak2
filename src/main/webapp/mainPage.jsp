<%@ page import="com.example.javawebgyak2.Advertiser" %>
<%@ page import="com.example.javawebgyak2.Product" %>
<%@ page import="com.example.javawebgyak2.Repository" %>
<%@ page import="com.example.javawebgyak2.FilteredModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: GamerKick
  Date: 2023-12-03
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<h1>MainPage</h1>
<%
    Advertiser user = (Advertiser) request.getSession().getAttribute("user");

%>
Cim: <%=user.getEmail()%> <br>
Hirdetett termékek:
<table>
    <tr>
        <th>Név</th><th>Ár</th><th>Lefoglalta</th>
    </tr>
    <% for (Product p:user.getSelling()) {%>
    <tr>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getReservedby()==null?"-":p.getReservedby()%></td>
    </tr>
<%}%>
</table>
<h3>Új termék felvétele:</h3>
<form action="prod-servlet" method="post">
    Név: <input type="text" name="name"> <br>
    Ár: <input type="number" name="price"><br>
    Kulcsszó:
    <select name="keyword" id="keyword">
    <%for (String k:Product.getAllkeywords()) {%>
        <option value="<%=k%>"><%=k%></option>
       <% } %>
    </select><br>
    <input type="submit" value="Felvesz">
</form>

<h3>Keresés</h3>
<form action="filter-servlet" method="get">
    <select name="kereses" id="kereses" multiple>
        <%for (String k:Product.getAllkeywords()) {%>
        <option value="<%=k%>"><%=k%></option>
        <% } %>
    </select>
    <input type="submit" value="Keres">
</form>
</body>
</html>
