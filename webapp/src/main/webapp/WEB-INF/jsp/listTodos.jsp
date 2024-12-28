<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>List Todos Page</title>
    </head>
    <body>
        <div>
            Welcome to ${name}
        </div>
        <div>Your todos are:</div>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>description</th>
                    <th>Target Date</th>
                    <th>is Done?</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.startDate}</td>
                        <td>${todo.done ? 'Yes' : 'No'}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
