/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.customer;
import com.daos.CustomerDao;
import com.utility.FileUploader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author shobh
 */
public class CustomerController extends HttpServlet {

    
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       response.setContentType("text/html");
       String op=request.getParameter("op");
         if (op != null && op.equals("varifyUserid")) {
            
            String userid = request.getParameter("userid");
            if (userid == null || userid.equals("")) {
                out.print("<b> Plese fillout the userid</b>");
                return;
            }
            
            Connection con = null;
            PreparedStatement smt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding", "root", "123456");
                String sql = "select * from customer where user_id=?";
                smt = con.prepareStatement(sql);
                smt.setString(1, userid);
                //execute the command : executeUpdate()-for insert,update and delete or executeQuery()-for select
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    out.println("<font color='red' size='4' face='corbel'>Sorry! this userid is not available</font>");
                } else {
                    out.println("<font color='blue' size='4' face='corbel'> Congrats! this userid is available!</font>");
                }
                smt.close();
                con.close();

            } catch (Exception e) {
                System.out.println("Error : + " + e.getMessage());

            }
        }
         if (op != null && op.equals("varifyEmailid")) {
            
            String email = request.getParameter("email");
            if (email == null || email.equals("")) {
                out.print("<b> Plese fillout the email</b>");
                return;
            }
            
            Connection con = null;
            PreparedStatement smt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding", "root", "123456");
                String sql = "select * from customer where email=?";
                smt = con.prepareStatement(sql);
                smt.setString(1, email);
                //execute the command : executeUpdate()-for insert,update and delete or executeQuery()-for select
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    out.println("<font color='red' size='4' face='corbel'>Sorry! this userid is not available</font>");
                } else {
                    out.println("<font color='blue' size='4' face='corbel'> Congrats! this userid is available!</font>");
                }
                smt.close();
                con.close();

            } catch (Exception e) {
                System.out.println("Error : + " + e.getMessage());

            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      PrintWriter out=response.getWriter();
      response.setContentType("text/html");
      String op=request.getParameter("op");
      if(op!=null && op.equalsIgnoreCase("add"))
      {
          
          boolean isMultipart=ServletFileUpload.isMultipartContent(request);
          String encodedPassword="";
          String imagePath="";
          HttpSession session=request.getSession();
      
          customer customer1=(customer)session.getAttribute("customer");
          out.println(customer1.getCity());
          if(isMultipart)
              imagePath=FileUploader.getUploadedPath(getServletContext(), "media/customer", request);
          customer1.setPhoto(imagePath);
          encodedPassword=Base64.getEncoder().encodeToString(customer1.getPassword().getBytes("UTF-8"));
          customer1.setPassword(encodedPassword);
          out.println(encodedPassword);
          System.out.println("Password is"+encodedPassword);
          CustomerDao cd=new CustomerDao();
         
          if(cd.add(customer1))
          {
              session.removeAttribute("customer");
              //out.println("Customer Added");
             response.sendRedirect("../login.jsp");
          }
      }
      if(op!=null && op.equalsIgnoreCase("update"))
      {
          
          boolean isMultipart=ServletFileUpload.isMultipartContent(request);
          String encodedPassword="";
          String imagePath="";
          HttpSession session=request.getSession();
          customer customer1=(customer)session.getAttribute("customer");
          if(isMultipart)
              imagePath=FileUploader.getUploadedPath(getServletContext(), "media/customer", request);
          
          if(imagePath=="")
          {
              encodedPassword = Base64.getEncoder().encodeToString(customer1.getPassword().getBytes("UTF-8"));
                 customer1.setPassword(encodedPassword);
                 CustomerDao rd=new CustomerDao();
                 if(rd.update(customer1))
                     response.sendRedirect("customer/viewDetails.jsp");
          }
          else
          {
              customer1.setPhoto(imagePath);
              encodedPassword = Base64.getEncoder().encodeToString(customer1.getPassword().getBytes("UTF-8"));
            customer1.setPassword(encodedPassword);
            CustomerDao rd = new CustomerDao();
            if (rd.update(customer1)) {
                
                response.sendRedirect("Customer/dashboard.jsp");
               // out.println("Reporter Added !!");
            }
          }
//          reporter.setPhoto(imagePath);
//          encodedPassword=Base64.getEncoder().encodeToString(reporter.getPassword().getBytes("UTF-8"));
//          reporter.setPassword(encodedPassword);
//          ReporterDao rd=new ReporterDao();
//         
//          if(rd.add(reporter))
//          {
//              session.removeAttribute("reporter");
//              out.println("Reporter Added");
//             response.sendRedirect("Admin/viewAllReporters.jsp");
//          }
      }
    }

   
   
}
