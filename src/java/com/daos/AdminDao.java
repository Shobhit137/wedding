/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;
import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.beans.Admin;
import java.sql.ResultSet;
/**
 *
 * @author shobh
 */
public class AdminDao {
    public Admin validateAdmin(String userid,String password){
        Admin admin=null;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       System.out.println("Control is in first phase here");
       if(con!=null){
        try{
            String sql = "Select * from admin where userid=? and password=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, userid);
            smt.setString(2,password);
            ResultSet rs = smt.executeQuery();
            System.out.println("Control is second phase here");
            if(rs.next()){
                admin = new Admin();
                admin.setName(rs.getString("name"));
                admin.setPhoto(rs.getString("photo"));
                //admin.setUserid(rs.getString("userid"));
                //admin.setPassword(rs.getString("password"));
                //admin.setId(rs.getInt("id"));
            }
           
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
        
        return admin;
        
    }
}
