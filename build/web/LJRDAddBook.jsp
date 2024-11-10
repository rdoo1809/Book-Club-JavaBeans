<%-- 
    Document   : LJRDAddBook
    Created on : Mar 8, 2024, 12:32:04?p.m.
    Author     : ryan
--%>

<jsp:include page="LJRDBanner.jsp" />

<br>
<h1>Add a Book</h1>
<br>
<p><i>${errorMessage}</i></p>
<form method="post" action="LJRDAddBook">
    <div>
        <label for="code" style="margin-right: 70px;"><strong>Code:</strong></label>
        <input name="code" type="text"/>
        </div>
    <br>
    <div>
        <label for="description"><strong>Description:</strong></label>
        <input name="description" type="text"/>
    </div>
    <br>
    <div>
        <label for="quantity" style="margin-right: 40px;"><strong>Quantity:</strong></label>
        <input name="quantity" type="text"/>
    </div>
    <br>
    <input style="margin-left: 110px;" type="submit" value="Save"/>
    <input type="submit" value="Cancel" formaction="LJRDDisplayBooks"/>
</form>

<jsp:include page="LJRDFooter.jsp" />


<style>
    form {
        display: block;
    }

    form div {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }

    label {
        margin-right: 20px
    }
</style>
