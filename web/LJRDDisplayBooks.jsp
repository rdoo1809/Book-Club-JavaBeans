<%-- 
    Document   : LJRDDisplayBooks
    Created on : Mar 6, 2024, 11:08:13?a.m.
    Author     : ryan
--%>

<jsp:include page="LJRDBanner.jsp" />
<br>
<h1>List of Books</h1>

<table class="" style="">
    <tr>
        <td><strong>Code</strong></td>
        <td><strong>Description</strong></td>
        <td><strong>Quantity</strong></td>
    </tr>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- we want to iterate through cart.items -->
    <c:forEach var="book" items="${books}" >
        <tr>
            <td>${book.code}</td>
            <td>${book.description}</td>
            <td>${book.quantity}</td>

        </tr>
    </c:forEach> 
</table>
<!--`
<form method="post" action="LJRDAddBook"></form> -->
<a href="LJRDAddBook.jsp"> <input type="submit" value="Add Book"> </a>



<br>    
<jsp:include page="LJRDFooter.jsp" />


<style>
    table tr td {
        border: 3px solid black;
    }
</style>