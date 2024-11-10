<%-- 
    Document   : LJRDRemove
    Created on : Apr 14, 2024, 3:26:46?p.m.
    Author     : ryan
--%>

<%@page import="club.business.Member"%>
<%
    Member member = (Member) request.getAttribute("member");
%>

<jsp:include page="LJRDBanner.jsp" />

<section>
<form method="" action="">
        <h1>Do you want to delete this member</h1>
        
        <label for="fullname">Full Name:</label>
        <input readonly name="fullname" type="text" value="${member.fullName}"><br/>
        
        <label for="email">Email:</label>
        <input readonly name="email" type="text" value="${member.emailAddress}"><br/>
        

        <label for="phone">Phone:</label>
        <input readonly name="phone" type="text" value="${member.phoneNumber}"><br/>
        

        
        <label for="itprogram">IT Program:</label>
                <input readonly name="itprogram" type="text" value="${member.programName}"><br/>

        
        <label for="yearlevel">Year Level:</label>
                <input readonly name="yearlevel" type="text" value="${member.yearLevel}"><br/>

        
       <a href="LJRDMemberAdmin?action=deleteMember&email=${member.emailAddress}"><input type="button" value="YES"></a>
       <a href="LJRDMemberAdmin?action=displayMembers"><input type="button" value="NO"></a>
    </form>
</section>

<jsp:include page="LJRDFooter.jsp" />