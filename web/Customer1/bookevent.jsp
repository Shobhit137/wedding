<%-- 
    Document   : bookevent
    Created on : 25 Apr, 2020, 8:27:59 PM
    Author     : shobh, 
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.booking"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Booking</title>
      
        <jsp:include page="base.jsp"></jsp:include>

            <script type="text/javascript">
                
           
            function check(x,y)
            {
               // alert("Hello");
                //alert(x);
                y.innerHtml="";
                ajax=new XMLHttpRequest();
                ajax.open("GET","Country1?op=check&n="+x,true);
                ajax.send();
                    
                ajax.onreadystatechange=function(){
                    if(this.readyState==4 && this.status==200)
                    {
                        y.innerHTML=this.responseText;
//                        alert(this.responseText);
                    }
                };
                 
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
                       <jsp:useBean class="com.beans.booking" id="booking" scope="session"></jsp:useBean>

                        <div class="container">
                            <div class="row">
                                <div class="col col-md-10">
                                
                                
                    <form method="post"  action="../BookingController?op=add" class="form-control">
                        <table class="table bg-light">
                            <tr><th colspan="2"><h2> <center>Enter  Details!!!</center></h2></th></tr>
                            
                            <tr>
                                <td><h5>Enter Booking Title</h5></td>
                                <td><input type="text" name="event_name" class="form-control" value=""/></td>
                            </tr>
                           
                            <tr>
                                <td><h5>Event Date</h5></td>
                                <td><input type="date" name="event_date" value="" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td><h5>Select State</h5></td>
                                <td> <select id="state_id" class="form-control" name="state_id" onchange="check(state_id.value,city);"> 
                            <option value="-1">Select State</option>

                        <%
                                PreparedStatement smt;
                                Connection con=null;
                                try{
                                    Class.forName("com.mysql.jdbc.Driver");
                                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding","root","123456");
                                    String sql="select *from states";
                                    smt=con.prepareStatement(sql);
                                    ResultSet rs=smt.executeQuery();
                                    while(rs.next())
                                    {
                                        //out.println(rs);
                                        %>
                                        <option value="<%= rs.getInt("id") %>"><%= rs.getString("name") %></option>
                                        <%}
                                     con.close();
                                      smt.close();
                                }catch(Exception e)
                                {
                                    System.out.println("Error"+e.getMessage());
                                }
                                %>
                    </select></td>
                            </tr>
                           
                             <tr>
                                <td><h5>Select City</h5></td>
                                <td> <select id="city" name="city" class="form-control" > 
                            <option value="-1">Select City</option>

                        
                    </select></td>
                            </tr>
                          
                            <tr>
                                <td><h5>Enter Advance Amount</h5></td>
                                <td><input type="number" name="number" value="" class="form-control"/></td> 
                            </tr>
                            
                            <tr>
                                <td><input type="hidden" name="customer_id" value=""</td>
                                <td><input type="hidden" name="status" value="false" class="form-control"/></td> 
                            </tr>
                           
                        </table>
                                    
                    <center> <a href="tanku.jsp" style="font-size: 20px;" class="btn btn-primary">Save And Next</a></center>
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