<%-- 
    Document   : login
    Created on : 29 Mar, 2020, 1:14:44 PM
    Author     : shobh
--%>

<%@page import="com.beans.customer"%>
<%@page import="com.daos.CustomerDao"%>
<%@page import="com.beans.Vendor"%>
<%@page import="com.daos.VendorDao"%>

<%@page import="com.beans.Admin"%>
<%@page import="com.daos.AdminDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Modern Business - Start Bootstrap Template</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/css/modern-business.css" rel="stylesheet">
        <style>

            html,body{
                background-image: url('assets1/Images/544750.jpg');
                background-size: cover;
                background-repeat: no-repeat;
                height: 10%;
              
                font-family: 'Numans', sans-serif;
            }

            .container{
                height: 100%;
                align-content: center;
            }

            .card{
                height: 370px;
                margin-top: auto;
                margin-bottom: auto;
                width: 400px;
                background-color: rgba(0,0,0,0.5) !important;
            }

            .social_icon span{
                font-size: 60px;
                margin-left: 10px;
                color: #FFC312;
            }

            .social_icon span:hover{
                color: white;
                cursor: pointer;
            }

            .card-header h3{
                color: white;
            }

            .social_icon{
                position: absolute;
                right: 20px;
                top: -45px;
            }

            .input-group-prepend span{
                width: 50px;
                background-color: #FFC312;
                color: black;
                border:0 !important;
            }

            input:focus{
                outline: 0 0 0 0  !important;
                box-shadow: 0 0 0 0 !important;

            }

            .remember{
                color: white;
            }

            .remember input
            {
                width: 20px;
                height: 20px;
                margin-left: 15px;
                margin-right: 5px;
            }

            .login_btn{
                color: black;
                background-color: #FFC312;
                width: 100px;
            }

            .login_btn:hover{
                color: black;
                background-color: white;
            }

            .links{
                color: white;
            }

            .links a{
                margin-left: 4px;
            }
        </style>

    </head>
    <body>
         <%
            String userid="";
            String password= "";
            Cookie cookies[] = request.getCookies();
            for(Cookie c : cookies){
                if (c.getName().equals("userid"))
                    userid=c.getValue();
                if(c.getName().equals("password"))
                    password=c.getValue();
            }
            %>
        <jsp:include page="navbar.jsp"></jsp:include>
        <center>
            <div class="container">

                <div class="row">

                <%-- <jsp:include page="sidebar.jsp"></jsp:include> --%>
                <!-- /.col-lg-3 -->

                <div class="col-lg-12">
                    <%--<jsp:include page="slider.jsp"></jsp:include>--%>

                    <div class="row">
                        <div class="d-flex justify-content-center h-100" style="margin-top: 15%">
                            <center>
                            <div class="card">
                                <div class="card-header">
                                    <h3>Sign In</h3>
                                    <br/>
                                    <span id="s1">
                                <% if (request.getParameter("msg")!=null)
                                    out.println("<font color='red' size='4'>"+request.getParameter("msg")+"</font>" );
                                %>
                                </span>
                                    <div class="d-flex justify-content-end social_icon">
                                        <span><i class="fab fa-facebook-square"></i></span>
                                        <span><i class="fab fa-google-plus-square"></i></span>
                                        <span><i class="fab fa-twitter-square"></i></span>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <center>
                                        <form  method="post">
                                            <div class="input-group form-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                                </div>
                                                <input type="text" class="form-control" placeholder="username" name="userid" required="required"  onfocus="s1.innerHTML = '';" autocomplete="off" value="<%=userid%>">

                                            </div>
                                            <div class="input-group form-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                                </div>
                                                <input type="password" class="form-control" placeholder="password" name="password" required="required" value="<%=password%>"><br/>

                                            </div>
                                            <div style="color:white; text-align: justify">
                                                <input type="radio" name="role" value="adminLogin" />Login as Admin &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                                                <br/><input type="radio" name="role" value="customerLogin" />Login as Customer
                                                <br/><input type="radio" name="role" value="vendorLogin" />Login as Vendor
                                            </div>

                                            <!--					<div class="row align-items-center remember"><br/>
                                                                                        <input type="checkbox" name="remember" value="yes">Remember Me
                                                                                    </div>-->
                                            <div class="form-group">
                                                <input type="submit" value="Login" name="submit" class="btn float-right login_btn">
                                            </div>
                                        </form>
                                    </center>
                                </div>
                                <div class="card-footer">
                                    <div class="d-flex justify-content-center links">
                                        Don't have an account?<a href="reg1.jsp">Sign Up</a>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a href="#">Forgot your password?</a>
                                    </div>
                                </div>
                            </div>
                                </center>
                        </div>
                    </div>


                </div>
                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->


        <!-- Bootstrap core JavaScript -->
        <br/>
       
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        
        
    </center>
                                               
                                                
        <br/><br/><br/><br/><br/><br/><br/><br/>                                        
                                                <jsp:include page="footer.jsp"></jsp:include>
</body>

<% 
    if(request.getParameter("submit")!=null) {
        userid = request.getParameter("userid");
        password = request.getParameter("password");
        String role = request.getParameter("role");
        
        if (role==null){
              response.sendRedirect("login.jsp?msg=Please Select any Role");
              return;
        }
        
       
      if (role.equals("adminLogin")) {
            AdminDao ad = new AdminDao();
            Admin admin = ad.validateAdmin(userid, password);
            if(admin!=null) {
                session.setAttribute("admin", admin);
                response.sendRedirect("Admin/dashboard.jsp");
            }
            else {
                 response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
            }
        }
      if (role.equals("vendorLogin")) {
            VendorDao vd = new VendorDao();
            Vendor vendor = vd.validateVendor(userid, password);
            System.out.println("NAme is"+vendor.getName());
            if(vendor!=null) {
                System.out.println("Connection is heree");
                session.setAttribute("vendor", vendor);
                response.sendRedirect("Vendor/dashboard.jsp");
                System.out.println("It has redirected");
            }
            else {
                 response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
            }
        }
      if (role.equals("customerLogin")) {
            CustomerDao cd = new CustomerDao();
            customer customer = cd.validateCustomer(userid, password);
            System.out.println("Name is"+customer.getName());
            if(customer!=null) {
                session.setAttribute("customer", customer);
                response.sendRedirect("Customer1/dashboard.jsp");
            }
            else {
                 response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
            }
        }
    }
    
    %>
</html>
