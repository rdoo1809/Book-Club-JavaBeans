<jsp:include page="LJRDBanner.jsp" />

<section>
    <form method="post" action="LJRDRegister.jsp">
        <h1>Thanks for joining the club!</h1>

        <p>Here is the full information you entered:</p>

        <p>
            <b>Full Name:</b> ${param.fullname}<br/>
            <b>Email:</b> ${param.email}<br/>
            <b>Phone</b> ${param.phone}<br/>
            <b>IT Program:</b> ${param.itprogram}<br/>
            <b>Year level:</b> ${param.yearlevel}<br/>
        </p>

        <p>To register another member, click on the Back button in your browser or the Return button shown below.</p>
        <input type="submit" value="Return">
    </form>
</section>

<jsp:include page="LJRDFooter.jsp" />