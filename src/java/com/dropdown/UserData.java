/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dropdown;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserData extends HttpServlet {

   
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String op = request.getParameter("op");
      
         if(op!=null && op.equalsIgnoreCase("search"))
        {
            
            Connection con=null;
            PreparedStatement smt=null;
            String city=request.getParameter("s1");
            
            try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding","root","123456");
            
            String sql="select * from city where id in(select city_id from source where state_id=?)";
            smt=con.prepareStatement(sql);
            smt.setString(1, city);
            ResultSet rs=smt.executeQuery();
            
            
            String output="<tr class=\"text-light bg-dark\"><td value='-1'>Course</td></tr>";
            while(rs.next())
            {
                output+="<tr><td value=='"+rs.getString(1)+"'>"+rs.getString(2)+"</td></tr>";
            }
            out.println(output);
            con.close();
            smt.close();
        }catch(Exception e)
        {
            System.out.println("Error"+e.getMessage());
        }
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
   
}
