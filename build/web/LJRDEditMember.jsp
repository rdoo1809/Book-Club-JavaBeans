<%-- 
    Document   : LJRDEditMember
    Created on : Apr 14, 2024, 3:59:25?p.m.
    Author     : ryan
--%>



<%@page import="club.business.Member"%>
<%
    Member member = (Member) request.getAttribute("member");
%>

<jsp:include page="LJRDBanner.jsp" />

<section>
<form method="post" action="LJRDMemberAdmin?action=saveMember">
        <h1>Edit an Existing Member</h1>
        
        <label for="fullname">Full Name:</label>
        <input  name="fullname" type="text" value="${member.fullName}"><br/>
        
        <label for="email">Email:</label>
        <input readonly  name="email" type="text" value="${member.emailAddress}"><br/>
       

        <label for="phone">Phone:</label>
        <input  name="phone" type="text" value="${member.phoneNumber}"><br/>
        

        
        <label for="itprogram">IT Program:</label>
                <input  name="itprogram" type="text" value="${member.programName}"><br/>

        
        <label for="yearlevel">Year Level:</label>
                <input  name="yearlevel" type="text" value="${member.yearLevel}"><br/>

                      <input type="submit" value="Update">

<!--<a href="LJRDMemberAdmin?action=postEdit&email=${member.emailAddress}"><input type="button" value="Update"></a>-->
      <input type="reset" value="Reset">
    </form>
</section>

<jsp:include page="LJRDFooter.jsp" />