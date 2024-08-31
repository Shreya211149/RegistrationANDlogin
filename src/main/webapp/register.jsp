<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
body {background-color: powderblue;
       text-align: center; 
}
h1   {color: blue;}
</style>
</head>
<body>
     <h1>Register</h1>
     <form action="regForm" method="post" >
     name: <input type="text" name="name1" > <br> <br>
     email: <input type="text" name="email1" > <br> <br>
     password: <input type="text" name="pass1" > <br> <br>
     gender: <input type="radio" id="male" name="gen1" value="Male" >
               <label for="male">Male</label>
             <input type="radio" id="female" name="gen1" value="Female" >
             <label for="female">Female</label>
             <input type="radio" id="other" name="gen1" value="Other" >
             <label for="other">Other</label><br><br>
     city:<select name="city1">
           <option>Select City</option>
           <option>Delhi</option>
           <option>Mumbai</option>
           <option>Kolkata</option>
           <option>Pune</option>
           <option>Bangalore</option>
           
         </select><br><br><br>
      <input type="submit" value="Register">
     
     </form>

</body>
</html>