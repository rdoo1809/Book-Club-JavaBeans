<%-- 
    Document   : LJRDECart
    Created on : Apr. 6, 2024, 9:05:29 p.m.
    Author     : lp_jo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="LJRDBanner.jsp" />
<table>
    <tr>
        <th colspan="3">
            <center>Your Loan Cart</center>
        </th>
    </tr>
    <tr>
        <th>Code</th>
        <th>Description</th>
        <th>Quantity</th>
    </tr>
    
    <c:set var="total" value="${0}"></c:set>
    <c:forEach var="cartitem" items="${cart.getItems()}">
    <tr>
        <td>${cartitem.code}</td>
        <td>${cartitem.description}</td>
        <td class="right-align">${cartitem.quantity}</td>
        <c:set var="total" value="${total + cartitem.quantity}"></c:set>
    </tr>
    </c:forEach> 
    <tr>
        <td><br></td>
    </tr>
    <tr>
        <td></td>
        <td class="right-align">Total:</td>
        <td class="right-align">${total}</td>
    </tr>
</table>  
    <a href="LJRDClearCart">Clear the cart</a><br/>
    <a href="LJRDLoan">Return to eLoan</a>
<jsp:include page="LJRDFooter.jsp" />