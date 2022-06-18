<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
</head>
<body>
    <h3>添加用户</h3>
    <form action="user.action" method="post">
        name: <input type = "text" name = "name"/>
        age:  <input type="text" name="age"/>
        sex:  <input type="text" name="sex"/>
              <input type="submit" value="add"/>
    </form>
    <hr/>
    <a href="user.action?filter=true&name=zhangsan">查询</a>
    <c:if test="${not empty users}">
        <h3>展示用户</h3>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
            </tr>
        </c:forEach>
    </c:if>
</body>
</html>