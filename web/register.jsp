<%-- 
    Document   : register
    Created on : 30 Mar, 2020, 7:33:08 PM
    Author     : shobh
--%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="keywords"
              content="unique login form,leamug login form,boostrap login form,responsive login form,free css html login form,download login form">
        <meta name="author" content="leamug">
        <title>Vendor Registration Form </title>
        <link href="css/style.css" rel="stylesheet" id="style">
        <!-- Bootstrap core Library -->
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
        <!-- Font Awesome-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            /*author:starttemplate*/
            /*reference site : starttemplate.com*/
            body {
                background-image:url('assets_login/images/pic21.jpeg');
                background-position:center;
                background-size:cover;

                -webkit-font-smoothing: antialiased;
                font: normal 14px Roboto,arial,sans-serif;
                font-family: Comic Sans!important;
            }
            .container {
                padding: 10px;
            }
            .option:hover{
                background-color: yellow;
            }

            ::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
                color: #ffffff!important;
                opacity: 1; /* Firefox */
                font-size:15px!important;
            }
            .form-login {
                background-color: rgba(0,0,0,0.65);
                padding-top: 10px;
                padding-bottom: 20px;
                padding-left: 20px;
                padding-right: 20px;
                border-radius: 15px;
                border-color:#d2d2d2;



            }
            .form-control{
                background:transparent!important;
                color:white!important;
                font-size: 14px;
            }
            h1{
                color:black!important;
            }
            h4 { 
                border:0 solid #fff; 
                border-bottom-width:1px;
                padding-bottom:10px;
                text-align: center;
            }

            .form-control {
                border-radius: 5px;
            }

            .wrapper {
                text-align: center;
            }
            .footer p{
                font-size: 18px;
            }
        </style>
    </head>
    <body>

        <!-- Page Content -->
        <div class="container">
            <div class="row">


                <div class="col-md-offset-4 col-md-4 text-center col-lg-4">
                    <h1 >Vendor Registration Form</h1>
                    <div class="form-login" style="color:white"></br>
                        <h4> Login Information</h4>
                        </br>
                        <input type="text" id="userName" name="username" class="form-control input-sm " placeholder="username" required="required"/>
                        </br>
                        <input type="text" id="userPassword" class="form-control input-sm " name="password" placeholder="password" required="required"/>
                        </br>
                        <span style="color:red"><p id="p1">password must contain one upper case,one lower case,one digit and a special character</p> </span> 
                        <input type="text" id="userPassword" class="form-control input-sm " placeholder="confirm password" required="required"/><br/>
                        <h4> contact Information</h4>
                        </br>
                        <input type="text" id="name" name="name" class="form-control input-sm" placeholder="first and last name" required="required"/><br/>
                        <input type="email" id="email" name="email" class="form-control input-sm" placeholder="Email" required="required"/> <br/>
                        <input type="text" id="contact" name="mobile" class="form-control input-sm" placeholder="mobile no" required="required"/><br/>
                        <h4> Business Information</h4>
                        </br>
                        <input type="text" id="city" name="city" class="form-control input-sm" placeholder="city/Town" required="required"/><br/>
                        <input type="text" id="pincode" name="pincode" class="form-control input-sm" placeholder="pincode" required="required"/><br/>
                        <input type="text" id="address" name="address" class="form-control input-sm" placeholder="address" /><br/>
                        <input type="text" id="business" name="business" class="form-control input-sm" placeholder="Name of your business" /><br/>
                        <input type="textarea" id="information" name="inform" class="form-control input-sm" placeholder="Describe your business"/><br/>
                        <h4> Business Information</h4>
                        </br>

                        <label for="vendor">Vendors</label>
                        <select id="vendor" name="vendor" class="form-control input-sm">
                            <option value="cateror" class="form-control input-sm" name="vendor">Caterer</option>
                            <option value="transportation" class="form-control input-sm">Transportation</option>
                            <option value="photographer" color="black" class="form-control input-sm">Photographer</option>
                            <option value="decoration" class="form-control input-sm">Decoration</option>
                            <option value="light-music" class="form-control input-sm">Light & Music</option>
                            <option value="florist" class="form-control input-sm">Florist</option>
                            <option value="hotels" class="form-control input-sm">Hotels</option>
                            <option value="cateror" class="form-control input-sm">Banquet Halls</option>
                            <option value="cateror" class="form-control input-sm">Wedding Lawns</option>
                        </select>
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Caterer
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Transportation
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Photographer<br/>
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Decoration
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Light & Music
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Florist<br/>
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Hotels
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Banquet Halls
                        <input type="radio" id="vendor" name="vendor" class="form-control input-sm"/>Wedding Lawns<br/><br/>




                        <div class="wrapper">

                            <span class="group-btn">
                                <a href="#" class="btn btn-success ">Next </a>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            </br></br></br>
            <!--footer-->

            <!--//footer-->
        </div>
    </body>
</html>