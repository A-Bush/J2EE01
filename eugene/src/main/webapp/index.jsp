<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Employee CRUD</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <br>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Employee CRUD</h3>
                </div>
                    <br>
                    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/employees" method="post">
                        <input type="hidden" name="id" value="${updatedEmployee.id}">

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="firstname">Firstname:</label>
                            <div class="col-sm-5">
                                <input type="text" name="firstname" value="${updatedEmployee.firstname}" maxlength="20" class="form-control" id="firstname" placeholder="Enter firstname" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="lastname">Lasttname:</label>
                            <div class="col-sm-5">
                                <input type="text" name="lastname" value="${updatedEmployee.lastname}" maxlength="20" class="form-control" id="lastname" placeholder="Enter lastname" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="birthday">Birthday:</label>
                            <div class="col-sm-5">
                                <input type="date" name="birthday" value="${updatedEmployee.birthday}" class="form-control" id="birthday" placeholder="Enter birthday" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="salary">Salary:</label>
                            <div class="col-sm-5">
                                <input type="number" name="salary" value="${updatedEmployee.salary}" class="form-control" id="salary" placeholder="Enter salary" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="department">Department:</label>
                            <div class="col-sm-5">
                                <select name="department" class="form-control" id="department">
                                    <option>Programming</option>
                                    <option>QA</option>
                                    <option>GameDev</option>
                                    <option>DB</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="email">Email:</label>
                            <div class="col-sm-5">
                                <input type="email" name="email" value="${updatedEmployee.email}" maxlength="20" class="form-control" id="email" placeholder="Enter email">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-10">
                                <c:choose>
                                    <c:when test="${param.action == null}">
                                        <button type="submit" class="btn btn-success">Add employee</button>
                                    </c:when>
                                    <c:when test="${param.action == 'update'}">
                                        <button type="submit" class="btn btn-info">Update employee</button>
                                        <button type="submit" class="btn btn-danger" onclick="window.history.back()">Cancel</button>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                    </form>

                    <table class="table table-bordered table-hover">
                        <tr class="info">
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Birthday</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Email</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>

                        <c:forEach items="${employeeList}" var="employee">
                            <jsp:useBean id="employee" scope="page" type="model.Employee"/>
                            <tr>
                                <td>${employee.firstname}</td>
                                <td>${employee.lastname}</td>
                                <td>${employee.birthday}</td>
                                <td>${employee.salary}</td>
                                <td>${employee.department}</td>
                                <td>${employee.email}</td>
                                <td style="width: 100px"><a href="employees?action=update&id=${employee.id}" style="width: 100%" class="btn btn-info btn-xs" role="button">Update</a></td>
                                <td style="width: 100px"><a href="employees?action=delete&id=${employee.id}" style="width: 100%" class="btn btn-danger btn-xs" role="button">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>