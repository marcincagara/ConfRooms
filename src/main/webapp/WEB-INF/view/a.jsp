
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <u>   <span style ="color: red">
      <%! boolean isItJanusz(String name){
          if(name.equals("Janusz")) {
            return true;
          }else
              return false;
      }
      %>


  <%

          if (request.getParameter("name") == null) {
              System.out.println(("Nie podano parametru"));
          } else {
              String result = request.getParameter("name").toUpperCase();
              System.out.println((result));
          }

  %>

  </span></u>
  </body>
</html>
