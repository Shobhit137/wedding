<%-- 
    Document   : login
    Created on : 29 Mar, 2020, 1:14:44 PM
    Author     : shobh
--%>



<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
       
        <jsp:include page="base.jsp"></jsp:include>
        <script type="text/javascript">
            function checkAccept(x,y){
                if(x.checked){
                    y.disabled=false;
               }
               else
               {
                   y.disabled=true;
               }
            }
            
            function comparePwds(x,y){
                if(x===y)
                    return true;
                else {
                    alert("Password and Confirm Password not matched !!");
                    return false;
                }
            }
            
            function varifyUserid(x,y){
               ajax = new XMLHttpRequest();
                ajax.open("GET","UserController?op=varifyUserid&userid="+x,true);
                ajax.send();
                
                ajax.onreadystatechange=function(){
                    if (this.readyState==4 && this.status==200){
                        y.innerHTML=this.responseText;
                    }
                };
            }
            
             function varifyContact(x,y){
               ajax = new XMLHttpRequest();
                ajax.open("GET","UserController?op=varifyContact&contact="+x,true);
                ajax.send();
                
                ajax.onreadystatechange=function(){
                    if (this.readyState==4 && this.status==200){
                        y.innerHTML=this.responseText;
                    }
                };
            }
     
   </script>
            <style>
                img{
  max-width:180px;
}
input[type=file]{
padding:10px;
background:#2d2d2d;}
            </style>
    </head>
   
    <body>
        <div class="container">
            <div class="row">
                <div class="col col-md-10">
                    <form action="" method="post" class="form" onsubmit="return comparePwds(password.value,rpassword.value);">  
    <center>
        <h2 class="bg-light">Registration page </h2>
        <table class="table bg-light"> 
            <tr>
                <td>Enter your Name </td>
                <td><input type="text" name="name" value="" required="required" autocomplete="off" class="form-control"/> </td>
            </tr> <tr>
                <td>Enter your Father's Name </td>
                <td><input type="text" name="fname" value="" required="required" class="form-control"/> </td>
            </tr>
             <tr>
                <td>Enter your DOB </td>
                <td><input type="date" name="dob" value="" class="form-control" /> </td>
            </tr>
            <tr>
                <td>Enter UserId </td>
                <td><input type="email" required="required" value="" name="userid" class="form-control" onblur="varifyUserid(this.value,s1);"/><br/>
                    <span id="s1"> </span>
                </td>
            </tr>
            <tr>
                <td>Enter Contact </td>
                <td><input type="text" required="required" value="" name="contact" class="form-control" onblur="varifyContact(this.value,s2);"/><br/>
                    <span id="s2"> </span>
                </td>
            </tr>
            
           <tr>
                <td>Enter Password </td>
                <td><input type="password" name="password" value="" id="password" class="form-control" /><br/>
                    <span><b>Password should be minimum 8 char and contains one Upper, one Lowe, one Special and one digit</b></span></td>
            </tr>
            <tr>
                <td>Retype Password </td>
                <td><input type="password" name="rpassword" id="rpassword" value="" class="form-control"/></td>
            </tr>
            
             <tr>
                <td>Select Your Gender </td>
                <td> <input type="radio" name="gender" value="Male"   /> Male<br/>
                    <input type="radio" name="gender" value="Female"  />Female<br/>
                </td>
            </tr> 
            
           
            <tr>
                <th colspan="2">
                    <input type="checkbox" id="accept" value="accept" onchange="checkAccept(this,submit);">Accept Terms and Conditions
                </th>
            </tr>
            <tr>
                 
                <th>
                    <input type="reset" value="Clear" class="form-control btn btn-dark" />
                </th>
                <th>   <input type="submit" name="submit" value="Save and Next" class="form-control btn btn-primary" disabled="disabled" id="submit"/> 
                </th>
            </tr>
            
         </table>
    </center>
        </form>
                </div>
            </div>
        </div>
       
    </body>
</html>

