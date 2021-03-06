package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.customer;
import com.daos.CustomerDao;
import com.beans.Vendor;
import com.daos.VendorDao;
import com.beans.Admin;
import com.daos.AdminDao;

public final class login1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Modern Business - Start Bootstrap Template</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"assets/css/modern-business.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            html,body{\n");
      out.write("                background-image: url('assets1/Images/544750.jpg');\n");
      out.write("                background-size: cover;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                height: 10%;\n");
      out.write("              \n");
      out.write("                font-family: 'Numans', sans-serif;\n");
      out.write("            }\n");
      out.write("            .container{\n");
      out.write("                height: 100%;\n");
      out.write("                align-content: center;\n");
      out.write("            }\n");
      out.write("            .card{\n");
      out.write("                height: 370px;\n");
      out.write("                margin-top: auto;\n");
      out.write("                margin-bottom: auto;\n");
      out.write("                width: 400px;\n");
      out.write("                background-color: rgba(0,0,0,0.5) !important;\n");
      out.write("            }\n");
      out.write("            .social_icon span{\n");
      out.write("                font-size: 60px;\n");
      out.write("                margin-left: 10px;\n");
      out.write("                color: #FFC312;\n");
      out.write("            }\n");
      out.write("            .social_icon span:hover{\n");
      out.write("                color: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .card-header h3{\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .social_icon{\n");
      out.write("                position: absolute;\n");
      out.write("                right: 20px;\n");
      out.write("                top: -45px;\n");
      out.write("            }\n");
      out.write("            .input-group-prepend span{\n");
      out.write("                width: 50px;\n");
      out.write("                background-color: #FFC312;\n");
      out.write("                color: black;\n");
      out.write("                border:0 !important;\n");
      out.write("            }\n");
      out.write("            input:focus{\n");
      out.write("                outline: 0 0 0 0  !important;\n");
      out.write("                box-shadow: 0 0 0 0 !important;\n");
      out.write("            }\n");
      out.write("            .remember{\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .remember input\n");
      out.write("            {\n");
      out.write("                width: 20px;\n");
      out.write("                height: 20px;\n");
      out.write("                margin-left: 15px;\n");
      out.write("                margin-right: 5px;\n");
      out.write("            }\n");
      out.write("            .login_btn{\n");
      out.write("                color: black;\n");
      out.write("                background-color: #FFC312;\n");
      out.write("                width: 100px;\n");
      out.write("            }\n");
      out.write("            .login_btn:hover{\n");
      out.write("                color: black;\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("            .links{\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .links a{\n");
      out.write("                margin-left: 4px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");

            String userid="";
            String password= "";
            Cookie cookies[] = request.getCookies();
            for(Cookie c : cookies){
                if (c.getName().equals("userid"))
                    userid=c.getValue();
                if(c.getName().equals("password"))
                    password=c.getValue();
            }
            
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("        <center>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <!-- /.col-lg-3 -->\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"d-flex justify-content-center h-100\" style=\"margin-top: 15%\">\n");
      out.write("                            <center>\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <h3>Sign In</h3>\n");
      out.write("                                    <br/>\n");
      out.write("                                    <span id=\"s1\">\n");
      out.write("                                ");
 if (request.getParameter("msg")!=null)
                                    out.println("<font color='red' size='4'>"+request.getParameter("msg")+"</font>" );
                                
      out.write("\n");
      out.write("                                </span>\n");
      out.write("                                    <div class=\"d-flex justify-content-end social_icon\">\n");
      out.write("                                        <span><i class=\"fab fa-facebook-square\"></i></span>\n");
      out.write("                                        <span><i class=\"fab fa-google-plus-square\"></i></span>\n");
      out.write("                                        <span><i class=\"fab fa-twitter-square\"></i></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <center>\n");
      out.write("                                        <form  method=\"post\">\n");
      out.write("                                            <div class=\"input-group form-group\">\n");
      out.write("                                                <div class=\"input-group-prepend\">\n");
      out.write("                                                    <span class=\"input-group-text\"><i class=\"fas fa-user\"></i></span>\n");
      out.write("                                                </div>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" placeholder=\"username\" name=\"userid\" required=\"required\"  onfocus=\"s1.innerHTML = '';\" autocomplete=\"off\" value=\"");
      out.print(userid);
      out.write("\">\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-group form-group\">\n");
      out.write("                                                <div class=\"input-group-prepend\">\n");
      out.write("                                                    <span class=\"input-group-text\"><i class=\"fas fa-key\"></i></span>\n");
      out.write("                                                </div>\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" placeholder=\"password\" name=\"password\" required=\"required\" value=\"");
      out.print(password);
      out.write("\"><br/>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div style=\"color:white; text-align: justify\">\n");
      out.write("                                                <input type=\"radio\" name=\"role\" value=\"adminLogin\" />Login as Admin &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;\n");
      out.write("                                                <br/><input type=\"radio\" name=\"role\" value=\"customerLogin\" />Login as Customer\n");
      out.write("                                                <br/><input type=\"radio\" name=\"role\" value=\"vendorLogin\" />Login as Vendor\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <!--\t\t\t\t\t<div class=\"row align-items-center remember\"><br/>\n");
      out.write("                                                                                        <input type=\"checkbox\" name=\"remember\" value=\"yes\">Remember Me\n");
      out.write("                                                                                    </div>-->\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <input type=\"submit\" value=\"Login\" name=\"submit\" class=\"btn float-right login_btn\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
      out.write("                                    </center>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-footer\">\n");
      out.write("                                    <div class=\"d-flex justify-content-center links\">\n");
      out.write("                                        Don't have an account?<a href=\"reg1.jsp\">Sign Up</a>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"d-flex justify-content-center\">\n");
      out.write("                                        <a href=\"#\">Forgot your password?</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                                </center>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.col-lg-9 -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("        <br/>\n");
      out.write("       \n");
      out.write("        <script src=\"assets/vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </center>\n");
      out.write("                                               \n");
      out.write("                                                \n");
      out.write("        <br/><br/><br/><br/><br/><br/><br/><br/>                                        \n");
      out.write("                                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
 
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
    
    
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
