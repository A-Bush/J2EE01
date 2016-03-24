<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<jsp:useBean id="user" class="examples.entity.UserDTO" scope="request"/>

<body>
Hello
<jsp:getProperty name="user" property="name"/>
User Name : ${user.name}
User Last Name : ${user.lastName}
<form>
    First name:<br>
    <input type="text" name="firstname">
    <br>
    Last name:<br>
    <input type="text" name="lastname">
    <c:if test="${request.getProperty('firstname') == 'Roman'}">
        Test is accepted
    </c:if>
</form>
</body>
</html>
