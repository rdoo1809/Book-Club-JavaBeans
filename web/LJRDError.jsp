<%-- 
    Document   : LJRDError
    Created on : Mar 8, 2024, 2:36:57?p.m.
    Author     : ryan
--%>

<jsp:include page="LJRDBanner.jsp" />

<br>
<h1>Java Error</h1>
<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>

<h2>Details</h2>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.message}</p>
</html>

<jsp:include page="LJRDFooter.jsp" />
