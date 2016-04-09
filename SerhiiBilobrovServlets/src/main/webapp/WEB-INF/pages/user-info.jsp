<%@ page import="ua.artcode.week9.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>

  <% User transfered = (User) request.getAttribute("user");%>

  <div class="container">
    <ul>
      <li>
        <div class="column">
          id : <%= transfered.getId()%>
        </div>
      </li>

      <li>
        <div class="column">
          name : <%= transfered.getName()%>
        </div>
      </li>

      <li>
        <div class="column">
          salary : <%= transfered.getSalary()%>
        </div>
      </li>


    </ul>
  </div>
</body>
</html>
