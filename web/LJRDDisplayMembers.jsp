<%-- 
    Document   : LJRDDisplayMembers
    Created on : Apr 14, 2024, 11:20:18?a.m.
    Author     : ryan
--%>

<jsp:include page="LJRDBanner.jsp" />
<br>
        <h1>List of Members</h1>
        <br>
        

        <table class="" style="">
    <tr>
        <td><strong>Email</strong></td>
        <td><strong>Full Name</strong></td>
        <td><strong>Program</strong></td>
        <td><strong>Year</strong></td>
    </tr>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- we want to iterate through cart.items -->
    <c:forEach var="user" items="${users}" >
        <tr>
            <td>${user.emailAddress}</td>
            <td>${user.fullName}</td>
            <td>${user.programName}</td>
            <td>${user.yearLevel}</td>
            <td>
        <a href="LJRDMemberAdmin?action=editMember&email=${user.emailAddress}">Edit</a>
        <a href="LJRDMemberAdmin?action=removeMember&email=${user.emailAddress}">Remove</a>
        </tr>
    </c:forEach> 
</table>
    <br>
        <a href="LJRDMemberAdmin?action=addMember"> <input type="submit" value="Add Member"> </a>

        
        
<br>    
<jsp:include page="LJRDFooter.jsp" />
