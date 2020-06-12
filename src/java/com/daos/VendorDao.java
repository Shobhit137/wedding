/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.beans.Vendor;
import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
public class VendorDao {
    public Vendor validateVendor(String userid,String password){
        Vendor vendor=null;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Select * from vendor1 where userid=? and password=?";
            PreparedStatement smt = con.prepareStatement(sql);
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
            smt.setString(1, userid);
            smt.setString(2,encodedPassword);
            System.out.println("Connection is here");
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                vendor = new Vendor();
                vendor.setId(rs.getInt("id"));
                vendor.setName(rs.getString("name"));
                vendor.setDob(rs.getString("dob"));
                vendor.setGender(rs.getString("gender"));
                vendor.setUserid(rs.getString("userid"));
                vendor.setPassword(rs.getString("password"));
                vendor.setPhoto(rs.getString("photo"));
                vendor.setContact(rs.getString("contact"));
                vendor.setEmail(rs.getString("email"));
                vendor.setProfession(rs.getString("profession"));
                vendor.setCity(rs.getString("city"));
                vendor.setPincode(rs.getInt("pincode"));
            }
           
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
        System.out.println("End is here");
        return vendor;
        
    }
    
    public boolean  add(Vendor vendor){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Insert into vendor1(name,gender,dob,userid,password,photo,contact,email,city,pincode,profession) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, vendor.getName());
            
            smt.setString(2, vendor.getGender());
            smt.setString(3, vendor.getDob());
           
            smt.setString(4, vendor.getUserid());
            smt.setString(5,vendor.getPassword());
            smt.setString(6, vendor.getPhoto());
            smt.setString(7, vendor.getContact());
            smt.setString(8, vendor.getEmail());
            smt.setString(9,vendor.getCity());
            
            smt.setInt(10,vendor.getPincode());
            smt.setString(11,vendor.getProfession());
//         System.out.println("Photo"+Reporter.getPhoto());
//            System.out.println("Contact"+Reporter.getContact());

            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return status;
   }
    public boolean  remove(int id){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Delete from vendor1 where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, id);
            
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return status;
   }
    public Vendor  getById(int id){
      Vendor vendor=null;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, id);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                vendor =new Vendor();
                vendor.setId(rs.getInt("id"));
                vendor.setName(rs.getString("name"));
                vendor.setEmail(rs.getString("email"));
                vendor.setDob(rs.getString("dob"));
                vendor.setGender(rs.getString("gender"));
                vendor.setCity(rs.getString("city"));
                vendor.setUserid(rs.getString("userid"));
                vendor.setPassword(rs.getString("password"));
                vendor.setPhoto(rs.getString("photo"));
                vendor.setContact(rs.getString("contact"));
                vendor.setProfession(rs.getString("profession"));
                vendor.setPincode(rs.getInt("pincode"));
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return vendor;
   }
     public Vendor  getByCategorry(String cat){
      Vendor vendor=null;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where profession=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, cat);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                vendor =new Vendor();
                vendor.setId(rs.getInt("id"));
                vendor.setName(rs.getString("name"));
                vendor.setEmail(rs.getString("email"));
                vendor.setDob(rs.getString("dob"));
                vendor.setGender(rs.getString("gender"));
                vendor.setCity(rs.getString("city"));
                vendor.setUserid(rs.getString("userid"));
                vendor.setPassword(rs.getString("password"));
                vendor.setPhoto(rs.getString("photo"));
                vendor.setContact(rs.getString("contact"));
                vendor.setProfession(rs.getString("profession"));
                vendor.setPincode(rs.getInt("pincode"));
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return vendor;
   }
    public ArrayList<Vendor>  getAllRecords(){
    
       ArrayList<Vendor> vendor =new ArrayList<Vendor>();
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
                Vendor  vendors=new Vendor();
                vendors.setId(rs.getInt("id"));
                vendors.setName(rs.getString("name"));
                vendors.setEmail(rs.getString("email"));
                vendors.setDob(rs.getString("dob"));
                vendors.setGender(rs.getString("gender"));
                vendors.setPincode(rs.getInt("pincode"));
                vendors.setUserid(rs.getString("userid"));
                vendors.setPassword(rs.getString("password"));
                vendors.setPhoto(rs.getString("photo"));
                vendors.setContact(rs.getString("contact"));
                vendors.setCity(rs.getString("city"));
                vendors.setProfession(rs.getString("profession"));
                vendor.add(vendors);
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return vendor;
   }
     public ArrayList<Vendor>  getAllRecordsByCategory(String cat){
    
       ArrayList<Vendor> vendor =new ArrayList<Vendor>();
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where profession=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1,cat);
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
                Vendor  vendors=new Vendor();
                vendors.setId(rs.getInt("id"));
                vendors.setName(rs.getString("name"));
                vendors.setEmail(rs.getString("email"));
                vendors.setDob(rs.getString("dob"));
                vendors.setGender(rs.getString("gender"));
                vendors.setPincode(rs.getInt("pincode"));
                vendors.setUserid(rs.getString("userid"));
                vendors.setPassword(rs.getString("password"));
                vendors.setPhoto(rs.getString("photo"));
                vendors.setContact(rs.getString("contact"));
                vendors.setCity(rs.getString("city"));
                vendors.setProfession(rs.getString("profession"));
                vendors.setCost(rs.getInt("cost"));
                vendor.add(vendors);
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return vendor;
   }
    public int  getRecordsCount(){
    
       int total=0;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select count(*) from vendor1";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return total;
   }
    public boolean  update(Vendor vendor){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "update vendor1 set name=?,gender=?,dob=?,email=?,photo=?,contact=?,city=?,pincode=?,profession=? where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
           
            smt.setString(1, vendor.getName());
            smt.setString(4, vendor.getEmail());
            smt.setString(2, vendor.getGender());
            smt.setString(3, vendor.getDob());
            smt.setString(7, vendor.getCity());
           smt.setInt(8, vendor.getPincode());
           smt.setString(9,vendor.getProfession());
            smt.setString(5, vendor.getPhoto());
            smt.setString(6, vendor.getContact());
            smt.setInt(10, vendor.getId());
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return status;
   }
   public boolean  isContact(String userid){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where contact=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, userid);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       return status;
    } 
    public boolean  isEmailExist(String email){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where vendor1=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, email);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       return status;
    }
    public boolean  isValid(String userid,String password){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where userid=?,password=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, userid);
            smt.setString(2, password);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       return status;
    }
    public Vendor  getByLoginData(String userid,String password){
      Vendor vendor=null;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from vendor1 where userid=? and password=? and status='approved'";
            PreparedStatement smt = con.prepareStatement(sql);
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
            smt.setString(1, userid);
            smt.setString(2,encodedPassword );
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                vendor =new Vendor();
                vendor.setId(rs.getInt("id"));
                vendor.setName(rs.getString("name"));
                vendor.setDob(rs.getString("dob"));
                vendor.setGender(rs.getString("gender"));
                vendor.setUserid(rs.getString("userid"));
                vendor.setPassword(rs.getString("password"));
                vendor.setPhoto(rs.getString("photo"));
                vendor.setContact(rs.getString("contact"));
                vendor.setEmail(rs.getString("email"));
                vendor.setCity(rs.getString("city"));
                vendor.setProfession(rs.getString("profession"));
                vendor.setPincode(rs.getInt("pincode"));
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
       return vendor;
   }
    public boolean  update2(Vendor vendor){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "update vendor1 set password=? where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            //System.out.println(reporter.getName());
            smt.setString(1, Base64.getEncoder().encodeToString(vendor.getPassword().getBytes("UTF-8")));
            smt.setInt(2,vendor.getId());
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return status;
   }
    
}
