<%-- 
    Document   : LJRDELoan
    Created on : Apr. 3, 2024, 12:47:59 p.m.
    Author     : lp_jo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="LJRDBanner.jsp" />
<table>
    <tr>
        <th>Code</th>
        <th>Description</th>
        <th>QOH</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${loanitems}" var="loanitem">
        <tr>
            <td>${loanitem.code}</td>
            <td>${loanitem.description}</td>
            <td class="right-align">${loanitem.quantity}</td>
            <td class="right-align">
                <c:choose>
                    <c:when test="${loanitem.quantity > 0}">
                        <a href="LJRDCart?action=reserve&code=${loanitem.code}">Reserve</a>
                    </c:when>
                    <c:otherwise>
                        N/A
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach> 
</table>   
<jsp:include page="LJRDFooter.jsp" />
