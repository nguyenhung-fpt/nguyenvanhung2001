<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/06/2022
  Time: 5:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Phones</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${phone != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${phone == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${phone == null}">
                                Add New phone
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${phone != null}">
                        <input type="hidden" name="id" value=""/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Name</label> <input type="text" value=""
                                                   class="form-control" name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>brand</label> <input type="text" value=""
                                                    class="form-control" name="brand">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>price</label> <input type="text" value=""
                                                    class="form-control" name="price">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>description</label> <input type="text" value=""
                                                          class="form-control" name="description">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                    <a href="list">
                        <button type="button" class="btn btn-primary">Back To List</button>
                    </a>
                </form>
        </div>
    </div>
</div>
</body>
</html>