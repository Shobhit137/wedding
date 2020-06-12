/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

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

public class Country1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String op=request.getParameter("op");
       
       if(op!=null &&op.equals("check"))
       {
          
           int state_id=Integer.parseInt(request.getParameter("n"));
           System.out.println(state_id);
           Connection con=null;
           PreparedStatement smt=null;
           
           try{
               Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding","root","123456");
               String sql="select * from city where states_id=?";
               smt=con.prepareStatement(sql);
               smt.setInt(1, state_id);
               ResultSet rs=smt.executeQuery();
               
               out.print("<option value=-1>Select City</option>");
               while(rs.next())
               {
                  
                   out.print("<option value="+rs.getInt("id")+">"+rs.getString("name")+"</option>");
               }
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
