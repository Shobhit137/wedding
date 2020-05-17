<%-- 
    Document   : bookevent
    Created on : 25 Apr, 2020, 8:27:59 PM
    Author     : shobh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.beans.customer"%>
<%@page import="com.daos.CustomerDao"%>
<%@page import="com.beans.booking"%>


<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.customer"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Booking</title>
        <jsp:useBean class="com.beans.customer" id="customer" scope="session"></jsp:useBean>
        <jsp:include page="base.jsp"></jsp:include>
            <!-- Custom styles for this template -->

            <script>
                $(document).ready(function(){
                $("#s1").change(function(){
                    $("#td1").load("UserData?op=search&s1="+$(this).val());
                });
            });
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
                                 

                    <form method="post" class="form" action="process" name="test">
                        <table class="table bg-light">
                            <tr><th colspan="2"><h2> <center>Enter  Details!!!</center></h2></th></tr>
                            
                            
                            <tr>
                                <td><h5>Select Event</h5></td>
                                <td><input type="radio" name="event" value="Wedding" ${booking.event_name eq "Wedding" ? "checked" :""}/>Wedding
                                    <input type="radio" name="event" value="Reception" ${booking.event_name eq "Reception" ? "checked" :""}/>Reception
                            </tr>
                            <tr>
                                <td><h5>Event Date</h5></td>
                                <td><input type="date" name="date" value="${booking.event_date}" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td><h5>Enter City</h5></td>
                                <td>  <input type="text" name="" value="${booking.city}" class="form-control"/><br/></td>
                                
                            </tr>
                          
                            <tr>
                                <td><h5>Enter Advance Amount</h5></td>
                                <td><input type="number" name="number" value="${booking.advance_cost}" class="form-control"/></td> 
                            </tr>
                            <tr>
                                <td><h5>Net Amount</h5></td>
                                <td><input type="number" name="number" value="12333" class="form-control"/></td> 
                            </tr>
                            <tr>
                                
                                <td><input type="hidden" name="status" value="false" class="form-control"/></td> 
                            </tr>
                           
                        </table>
                                    
                        <input type="submit" value="save and next" name="submit" id="submit" class="form-control btn btn-primary"/>
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