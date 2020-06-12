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
          <style type="text/css">
            h3.h3{text-align:center;margin:1em;text-transform:capitalize;font-size:1.7em;}

            /********************* shopping Demo-1 **********************/
            .product-grid{font-family:Raleway,sans-serif;text-align:center;padding:0 0 72px;border:1px solid rgba(0,0,0,.1);overflow:hidden;position:relative;z-index:1}
            .product-grid .product-image{position:relative;transition:all .3s ease 0s}
            .product-grid .product-image a{display:block}
            .product-grid .product-image img{width:100%;height:auto}
            .product-grid .pic-1{opacity:1;transition:all .3s ease-out 0s}
            .product-grid:hover .pic-1{opacity:1}
            .product-grid .pic-2{opacity:0;position:absolute;top:0;left:0;transition:all .3s ease-out 0s}
            .product-grid:hover .pic-2{opacity:1}
            .product-grid .social{width:150px;padding:0;margin:0;list-style:none;opacity:0;transform:translateY(-50%) translateX(-50%);position:absolute;top:60%;left:50%;z-index:1;transition:all .3s ease 0s}
            .product-grid:hover .social{opacity:1;top:50%}
            .product-grid .social li{display:inline-block}
            .product-grid .social li a{color:#fff;background-color:#333;font-size:16px;line-height:40px;text-align:center;height:40px;width:40px;margin:0 2px;display:block;position:relative;transition:all .3s ease-in-out}
            .product-grid .social li a:hover{color:#fff;background-color:#ef5777}
            .product-grid .social li a:after,.product-grid .social li a:before{content:attr(data-tip);color:#fff;background-color:#000;font-size:12px;letter-spacing:1px;line-height:20px;padding:1px 5px;white-space:nowrap;opacity:0;transform:translateX(-50%);position:absolute;left:50%;top:-30px}
            .product-grid .social li a:after{content:'';height:15px;width:15px;border-radius:0;transform:translateX(-50%) rotate(45deg);top:-20px;z-index:-1}
            .product-grid .social li a:hover:after,.product-grid .social li a:hover:before{opacity:1}
            .product-grid .product-discount-label,.product-grid .product-new-label{color:#fff;background-color:#ef5777;font-size:12px;text-transform:uppercase;padding:2px 7px;display:block;position:absolute;top:10px;left:0}
            .product-grid .product-discount-label{background-color:#333;left:auto;right:0}
            .product-grid .rating{color:#FFD200;font-size:12px;padding:12px 0 0;margin:0;list-style:none;position:relative;z-index:-1}
            .product-grid .rating li.disable{color:rgba(0,0,0,.2)}
            .product-grid .product-content{background-color:#fff;text-align:center;padding:12px 0;margin:0 auto;position:absolute;left:0;right:0;bottom:-27px;z-index:1;transition:all .3s}
            .product-grid:hover .product-content{bottom:0}
            .product-grid .title{font-size:13px;font-weight:400;letter-spacing:.5px;text-transform:capitalize;margin:0 0 10px;transition:all .3s ease 0s}
            .product-grid .title a{color:#828282}
            .product-grid .title a:hover,.product-grid:hover .title a{color:#ef5777}
            .product-grid .price{color:#333;font-size:17px;font-family:Montserrat,sans-serif;font-weight:700;letter-spacing:.6px;margin-bottom:8px;text-align:center;transition:all .3s}
            .product-grid .price span{color:#999;font-size:13px;font-weight:400;text-decoration:line-through;margin-left:3px;display:inline-block}
            .product-grid .add-to-cart{color:#000;font-size:13px;font-weight:600}
            @media only screen and (max-width:990px){.product-grid{margin-bottom:30px}
            }

        </style>
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
                                   <div class="row">
            <div class="col">

                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Cateror</a>


                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">DJ</a>


                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Cameraman</a>



                </div>

            </div>



            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">


                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">

                        <h3>Cateror</h3>
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <div class="product-grid">
                                    <div class="product-image">
                                        <a href="#">
                                            <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-1.jpg">
                                            <img class="pic-2" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-2.jpg">
                                        </a>

                                        <span class="product-new-label">Sale</span>
                                        <span class="product-discount-label">20%</span>
                                    </div>
                                    <div class="product-content">
                                        <h3 class="title"><a href="#">Women's Blouse</a></h3>
                                        <div class="price">$16.00
                                            <span>$20.00</span>
                                        </div>
                                        <a class="add-to-cart" href="">Select this Vendor</a>
                                        <a class="add-to-cart" href="">See More Details</a>
                                    </div>

                                </div>


                            </div>



                            <div class="col-md-3 col-sm-6">
                                <div class="product-grid">
                                    <div class="product-image">
                                        <a href="#">
                                            <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-1.jpg">
                                            <img class="pic-2" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-2.jpg">
                                        </a>

                                        <span class="product-new-label">Sale</span>
                                        <span class="product-discount-label">20%</span>
                                    </div>
                                    <div class="product-content">
                                        <h3 class="title"><a href="#">Women's Blouse</a></h3>
                                        <div class="price">$16.00
                                            <span>$20.00</span>
                                        </div>
                                        <a class="add-to-cart" href="">Select this Vendor</a>
                                        <a class="add-to-cart" href="">See More Details</a>
                                    </div>

                                </div>


                            </div>


                        </div>

                    </div>




                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">

                        <h3>DJ</h3>
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <div class="product-grid">
                                    <div class="product-image">
                                        <a href="#">
                                            <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-1.jpg">
                                            <img class="pic-2" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-2.jpg">
                                        </a>

                                        <span class="product-new-label">Sale</span>
                                        <span class="product-discount-label">20%</span>
                                    </div>
                                    <div class="product-content">
                                        <h3 class="title"><a href="#">Women's Blouse</a></h3>
                                        <div class="price">$16.00
                                            <span>$20.00</span>
                                        </div>
                                        <a class="add-to-cart" href="">Select this Vendor</a>
                                        <a class="add-to-cart" href="">See More Details</a>

                                    </div>

                                </div>


                            </div>
                        </div>


                    </div>





                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">



                        <h3>Cameraman</h3>
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <div class="product-grid">
                                    <div class="product-image">
                                        <a href="#">
                                            <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-1.jpg">
                                            <img class="pic-2" src="http://bestjquery.com/tutorial/product-grid/demo9/images/img-2.jpg">
                                        </a>

                                        <span class="product-new-label">Sale</span>
                                        <span class="product-discount-label">20%</span>
                                    </div>
                                    <div class="product-content">
                                        <h3 class="title"><a href="#">Women's Blouse</a></h3>
                                        <div class="price">$16.00
                                            <span>$20.00</span>
                                        </div>
                                        <a class="add-to-cart" href="">Select this Vendor</a>
                                        <a class="add-to-cart" href="">See More Details</a>
                                    </div>

                                </div>


                            </div>
                        </div>


                    </div>



                </div>
            </div>


        </div>
                                
                             
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