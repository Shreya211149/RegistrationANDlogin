<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style>
body {background-color: powderblue;
       text-align: center; 
}
h1   {color: blue;}
</style>
</head>
<body>
<h1>Login</h1>
     <form action="loginForm" method="post" >
     Email:<input type="text" name="email1" > <br> <br>
     Password:<input type="text" name="pass1" > <br> <br>
     <input type="submit" value="Login">
     </form>
</body>
</html>