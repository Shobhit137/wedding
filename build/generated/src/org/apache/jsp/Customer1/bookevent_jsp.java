package org.apache.jsp.Customer1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import com.beans.booking;

public final class bookevent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Booking</title>\n");
      out.write("      \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                \n");
      out.write("           \n");
      out.write("            function check(x,y)\n");
      out.write("            {\n");
      out.write("               // alert(\"Hello\");\n");
      out.write("                //alert(x);\n");
      out.write("                y.innerHtml=\"\";\n");
      out.write("                ajax=new XMLHttpRequest();\n");
      out.write("                ajax.open(\"GET\",\"Country1?op=check&n=\"+x,true);\n");
      out.write("                ajax.send();\n");
      out.write("                    \n");
      out.write("                ajax.onreadystatechange=function(){\n");
      out.write("                    if(this.readyState==4 && this.status==200)\n");
      out.write("                    {\n");
      out.write("                        y.innerHTML=this.responseText;\n");
      out.write("//                        alert(this.responseText);\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                 \n");
      out.write("            }\n");
      out.write("            </script> \n");
      out.write("          </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("        ");

            if (session.getAttribute("customer") == null) {
                response.sendRedirect("../login.jsp");
                return;
            }
        
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <nav class=\"col-md-2 d-none d-md-block bg-light sidebar\">\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <main role=\"main\" class=\"col-md-9 ml-sm-auto col-lg-10 pt-3 px-4\">\n");
      out.write("                       \n");
      out.write("                        <div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom\">\n");
      out.write("                        ");
      out.write("\n");
      out.write("                       ");
      com.beans.booking booking = null;
      synchronized (session) {
        booking = (com.beans.booking) _jspx_page_context.getAttribute("booking", PageContext.SESSION_SCOPE);
        if (booking == null){
          booking = new com.beans.booking();
          _jspx_page_context.setAttribute("booking", booking, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col col-md-10\">\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                    <form method=\"post\"  action=\"../BookingController?op=add\" class=\"form-control\">\n");
      out.write("                        <table class=\"table bg-light\">\n");
      out.write("                            <tr><th colspan=\"2\"><h2> <center>Enter  Details!!!</center></h2></th></tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <td><h5>Enter Booking Title</h5></td>\n");
      out.write("                                <td><input type=\"text\" name=\"event_name\" class=\"form-control\" value=\"\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                           \n");
      out.write("                            <tr>\n");
      out.write("                                <td><h5>Event Date</h5></td>\n");
      out.write("                                <td><input type=\"date\" name=\"event_date\" value=\"\" class=\"form-control\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><h5>Select State</h5></td>\n");
      out.write("                                <td> <select id=\"state_id\" class=\"form-control\" name=\"state_id\" onchange=\"check(state_id.value,city);\"> \n");
      out.write("                            <option value=\"-1\">Select State</option>\n");
      out.write("\n");
      out.write("                        ");

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
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print( rs.getInt("id") );
      out.write('"');
      out.write('>');
      out.print( rs.getString("name") );
      out.write("</option>\n");
      out.write("                                        ");
}
                                     con.close();
                                      smt.close();
                                }catch(Exception e)
                                {
                                    System.out.println("Error"+e.getMessage());
                                }
                                
      out.write("\n");
      out.write("                    </select></td>\n");
      out.write("                            </tr>\n");
      out.write("                           \n");
      out.write("                             <tr>\n");
      out.write("                                <td><h5>Select City</h5></td>\n");
      out.write("                                <td> <select id=\"city\" name=\"city\" class=\"form-control\" > \n");
      out.write("                            <option value=\"-1\">Select City</option>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                    </select></td>\n");
      out.write("                            </tr>\n");
      out.write("                          \n");
      out.write("                            <tr>\n");
      out.write("                                <td><h5>Enter Advance Amount</h5></td>\n");
      out.write("                                <td><input type=\"number\" name=\"number\" value=\"\" class=\"form-control\"/></td> \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"hidden\" name=\"customer_id\" value=\"\"</td>\n");
      out.write("                                <td><input type=\"hidden\" name=\"status\" value=\"false\" class=\"form-control\"/></td> \n");
      out.write("                            </tr>\n");
      out.write("                           \n");
      out.write("                        </table>\n");
      out.write("                                    \n");
      out.write("                    <center> <a href=\"tanku.jsp\" style=\"font-size: 20px;\" class=\"btn btn-primary\">Save And Next</a></center>\n");
      out.write("                    </form>       \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </main>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("            ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("\n");
      out.write("        <!-- Icons -->\n");
      out.write("        <script>\n");
      out.write("            feather.replace()\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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
