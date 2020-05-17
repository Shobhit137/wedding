<%-- 
    Document   : editDetails
    Created on : 22 Apr, 2020, 8:10:28 PM
    Author     : shobh
--%>

<%-- 
    Document   : dashboard
    Created on : 07-Mar-2020, 08:44:47
    Author     : Dell
--%>

<%@page import="com.beans.customer"%>
<%@page import="com.daos.CustomerDao"%>

<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.customer"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Reporter Home</title>
        <jsp:useBean class="com.beans.customer" id="customer" scope="session"></jsp:useBean>
        <jsp:include page="base.jsp"></jsp:include>
            <!-- Custom styles for this template -->

            <script>
                function readURL(input)
                {
                    if (input.files && input.files[0])
                    {
                        var reader = new FileReader();
                        reader.onload = function (e)
                        {
                            img1.src = e.target.result;
                        };
                        reader.readAsDataURL(input.files[0]);
                    }
                }
            </script>


        </head>

        <body>
        <%
            if (session.getAttribute("customer") == null) {
                response.sendRedirect("../login.jsp");
                return;
            }
        %>  




   <jsp:include page="navbar.jsp"></jsp:include>
        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <jsp:include page="sidebar.jsp"></jsp:include>
                    </nav>

                    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                        <%-- <jsp:include page="reportbar.jsp"></jsp:include>--%>


                        <div class="container">
                            <div class="row">
                                <div class="col col-md-10">
                                    <div style="position: fixed; bottom: 0px; left: 400px;">
                                        <%
                           if (request.getParameter("submit") != null) { %>     
                                        <jsp:setProperty name="customer" property="*"></jsp:setProperty>
                                            <form method="post" action="../CustomerController?op=update" enctype="multipart/form-data" >
                                                <center><table  class="bg-dart text-white font-weight-bold text-center" width="60%" border="5">
                                                        <tr><td rowspan="4">
                                                                <img src="../${customer.photo}" id="img1" class="img img-thumbnail" style="width:200px; height: 200px"/> <br/>
                                                            Change Profile Image<input type="file" name="photo" id="photo" onchange="readURL(this);" />
                                                            <br/></td>
                                                    </tr>


                                                </table>
                                                <input type="submit" value=" Update in Record"/></center>
                                        </form>
                                        <% }
                                        %>
                                    </div>

                                    <form method="post" class="form" id="1">
                                        <center>      
                                            <h2 class="bg-light">Edit Here </h2>
                                            <table class="table bg-light">

                                                <tr>
                                                    <td>Name</td>
                                                    <td><input type="text" name="name" required="required" autocomplete="off" value="${customer.name}" class="form-control"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Contact</td>
                                                    <td><input type="text" name="contact" required="required"  value="${customer.contact}" class="form-control"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Email</td>
                                                    <td><input type="text" name="email" required="required" autocomplete="off" value="${customer.email}" class="form-control"/></td>
                                                </tr>
                                                <!--            <tr>
                                                                   <td>User_id</td>
                                                                   <td><input type="text" name="userid" required="required" autocomplete="off" value="${customer.user_id}" class="form-control"/></td>
                                                            </tr>-->

                                                <tr>
                                                    <td> Date of Birth</td>
                                                    <td><input type="date" name="date" required="required" autocomplete="off" value="${customer.dob}" class="form-control"/></td>
                                                </tr>
                                                <tr>
                                                    <td> Gender</td>
                                                    <td> <input type="radio" name="gender"  value="Male"  ${customer.gender eq "Male"?  " checked":""}/> Male &nbsp;&nbsp;&nbsp;
                                                        <input type="radio" name="gender"  value="Female" ${customer.gender eq "Female"?  " checked":""} />Female<br/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Address</td>
                                                    <td><input type="text" name="address" required="off" class="form-control" autocomplete="off" value="${customer.city}"</td>
                                                </tr>

                                            </table>
                                            <input type="submit" name="submit" value="Save" class="form-control btn btn-primary" id="submit"/>

                                        </center>
                                    </form>        
                                </div>


                            </div>
                        </div>


                    </div>

                </main>
            </div>
        </div>
        <!-- Bootstrap core JavaScript
            ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!-- Icons -->
        <script>
            feather.replace()
        </script>
    </body>
</html>
