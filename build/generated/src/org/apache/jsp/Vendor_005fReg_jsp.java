package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Vendor_005fReg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Reporter Registration</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function readURL(input,preview)\n");
      out.write("            {\n");
      out.write("              if(input.files && input.files[0])\n");
      out.write("              {\n");
      out.write("                   var reader=new FileReader();\n");
      out.write("                   reader.onload=function(e)\n");
      out.write("                   {\n");
      out.write("                       preview.src=e.target.result;\n");
      out.write("                   };\n");
      out.write("                   reader.readAsDataURL(input.files[0]);\n");
      out.write("              }\n");
      out.write("            }\n");
      out.write("            function varifyUserid(x,y){\n");
      out.write("               ajax = new XMLHttpRequest();\n");
      out.write("                ajax.open(\"GET\",\"VendorController?op=varifyUserid&userid=\"+x,true);\n");
      out.write("                ajax.send();\n");
      out.write("                \n");
      out.write("                ajax.onreadystatechange=function(){\n");
      out.write("                    if (this.readyState===4 && this.status===200){\n");
      out.write("                        y.innerHTML=this.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            function varifyEmailid(x,y){\n");
      out.write("               ajax = new XMLHttpRequest();\n");
      out.write("                ajax.open(\"GET\",\"VendorController?op=varifyEmailid&email=\"+x,true);\n");
      out.write("                ajax.send();\n");
      out.write("                \n");
      out.write("                ajax.onreadystatechange=function(){\n");
      out.write("                    if (this.readyState===4 && this.status===200){\n");
      out.write("                        y.innerHTML=this.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <center>\n");
      out.write("       ");
      com.beans.Vendor vendor = null;
      synchronized (session) {
        vendor = (com.beans.Vendor) _jspx_page_context.getAttribute("vendor", PageContext.SESSION_SCOPE);
        if (vendor == null){
          vendor = new com.beans.Vendor();
          _jspx_page_context.setAttribute("vendor", vendor, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-3\" style=\"position: fixed; right:0px;\">\n");
      out.write("                ");
 if(request.getParameter("submit")!=null){
                    
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("vendor"), request);
      out.write("\n");
      out.write("                    <form action=\"VendorController?op=add\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                        <img src=\"\" style=\"width:200px;height: 200px;\" id=\"preview\" class=\"form-control\"/><br/>\n");
      out.write("                        <input type=\"file\" name=\"image\" onchange=\"readURL(this,preview);\" class=\"form-control btn btn-primary\"/>\n");
      out.write("                        <br/>\n");
      out.write("                        <input type=\"submit\" value=\"Save to Database\" class=\"btn btn-primary\" name=\"submit\"/>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                }
      out.write("\n");
      out.write("                </div>\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            <div class=\"col col-md-9\">\n");
      out.write("               <form method=\"post\" class=\"form\">\n");
      out.write("                    <table class=\"table bg-light\">\n");
      out.write("                        <tr><th colspan=\"2\"><h2> <center>Enter Vendor Details!!!</center></h2></th></tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5> Name</h5></td>\n");
      out.write("                            <td><input type=\"text\" name=\"name\"class=\"form-control\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5> DOB</h5></td>\n");
      out.write("                            <td><input type=\"date\" name=\"dob\"  class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.dob}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                         <tr>\n");
      out.write("                            <td><h5>Gender</h5></td>\n");
      out.write("                            <td><input type=\"radio\" name=\"gender\" value=\"Male\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.gender eq \"Male\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Male\n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"Female\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.gender eq \"Female\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Female</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5>Enter Vendor Contact's</h5></td>\n");
      out.write("                            <td><input type=\"number\" name=\"contact\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.contact}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5>Enter Vendor Userid</h5></td>\n");
      out.write("                            <td><input type=\"text\" name=\"userid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" onblur=\"varifyUserid(this.value,s1);\"/><br/>\n");
      out.write("                                <span id=\"s1\"></span>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5>Enter Vendor Address</h5></td>\n");
      out.write("                            <td><input type=\"text\" name=\"city\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                         <tr>\n");
      out.write("                            <td><h5>Enter Vendor Pincode</h5></td>\n");
      out.write("                            <td><input type=\"number\" name=\"pincode\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.pincode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5>Enter Vendor Email</h5></td>\n");
      out.write("                            <td><input type=\"email\" name=\"email\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" onblur=\"varifyEmailid(this.value,s2);\"/><br/>\n");
      out.write("                                <span id=\"s2\"></span>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                          <tr>\n");
      out.write("                            <td><h5>Enter Vendor Profession</h5></td>\n");
      out.write("                            <td><input type=\"radio\" name=\"profession\" value=\"Cateror\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.profession eq \"Cateror\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Cateror\n");
      out.write("                                <input type=\"radio\" name=\"profession\" value=\"Florist\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.profession eq \"Florist\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Florist\n");
      out.write("                            <input type=\"radio\" name=\"profession\" value=\"Light&Sound\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.profession eq \"Cateror\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Light & Sound\n");
      out.write("                            <input type=\"radio\" name=\"profession\" value=\"Photographer\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.profession eq \"Cateror\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Photographer\n");
      out.write("                            <input type=\"radio\" name=\"profession\" value=\"Transporter\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.profession eq \"Transporter\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Transporter\n");
      out.write("                            <input type=\"radio\" name=\"profession\" value=\"Musician\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.profession eq \"Musician\" ? \"checked\" :\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/>Musician\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h5>Enter Vendor Password</h5></td>\n");
      out.write("                            <td><input type=\"password\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vendor.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <input type=\"hidden\" name=\"status\" value=\"pending\"/>\n");
      out.write("                    </table>\n");
      out.write("                        <input type=\"submit\" value=\"save and next\" name=\"submit\" id=\"submit\" class=\"form-control btn btn-primary\"/>\n");
      out.write("                </form>\n");
      out.write("                    \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("                </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
