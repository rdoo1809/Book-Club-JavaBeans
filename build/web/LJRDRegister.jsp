<jsp:include page="LJRDBanner.jsp" />

<section>
<!--    <form method="post" action="LJRDDisplayMember.jsp">-->
<form method="post" action="LJRDMemberAdmin?action=saveMember">
        <h1>New Member Registration Form</h1>
        
        <label for="fullname">Full Name:</label>
        <input name="fullname" type="text"><br/>
        
        <label for="email">Email:</label>
        <input name="email" type="text"><br/>
        
<!--        <label for="email">Email:</label>
        <input name="email" type="email"><br/>-->
        
        <label for="phone">Phone:</label>
        <input name="phone" type="text"><br/>
        
<!--        <label for="phone">Phone:</label>
        <input name="phone" type="text"><br/>-->
        
        <label for="itprogram">IT Program:</label>
        <select name="itprogram">
            <option value="cas">CAS</option>
            <option value="sqate">SQATE</option>
            <option value="cpa">CPA</option>
            <option value="cp">CP</option>
            <option value="itid">ITID</option>
            <option value="cad">CAD</option>
            <option value="itss">ITSS</option>
        </select><br/>
        
        <label for="yearlevel">Year Level:</label>
        <select name="yearlevel">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select><br/>
        
        <input type="submit" value="Register Now!">
        <input type="reset" value="Reset">
    </form>
</section>

<jsp:include page="LJRDFooter.jsp" />