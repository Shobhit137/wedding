/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.beans.Vendor;
import com.beans.customer;
import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author shobh
 */
public class CustomerDao {
     public customer validateCustomer(String userid,String password){
       customer customer1=null;
        ConnectionPool cp = ConnectionPool.getInstance();
         cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Select * from customer where user_id=? and password=?";
            PreparedStatement smt = con.prepareStatement(sql);
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
            smt.setString(1, userid);
            smt.setString(2,encodedPassword);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                customer1 = new customer();
               
                customer1.setId(rs.getInt("id"));
                customer1.setName(rs.getString("name"));
                customer1.setDob(rs.getString("dob"));
                customer1.setGender(rs.getString("gender"));
                customer1.setUser_id(rs.getString("user_id"));
                customer1.setPassword(rs.getString("password"));
                customer1.setPhoto(rs.getString("photo"));
                customer1.setContact(rs.getString("contact"));
                customer1.setEmail(rs.getString("email"));
                
                customer1.setCity(rs.getString("city"));
            }
           
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
        System.out.println("Name is"+customer1.getName());
        return customer1;
        
    }
    
    public boolean  add(customer customer1){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Insert into customer(name,gender,dob,user_id,password,photo,contact,email,city) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, customer1.getName());
            
            smt.setString(2, customer1.getGender());
            smt.setString(3, customer1.getDob());
           
            smt.setString(4, customer1.getUser_id());
            smt.setString(5,customer1.getPassword());
            smt.setString(6, customer1.getPhoto());
            smt.setString(7, customer1.getContact());
            smt.setString(8, customer1.getEmail());
            smt.setString(9,customer1.getCity());
            
//            smt.setInt(10,vendor.getPincode());
//            smt.setString(11,vendor.getProfession());
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
            String sql = "Delete from customer where id=?";
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
    public customer  getById(int id){
      customer customer1=null;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from customer where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, id);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                customer1 =new customer();
                customer1.setId(rs.getInt("id"));
                customer1.setName(rs.getString("name"));
                customer1.setEmail(rs.getString("email"));
                customer1.setDob(rs.getString("dob"));
                customer1.setGender(rs.getString("gender"));
                customer1.setCity(rs.getString("city"));
                customer1.setUser_id(rs.getString("user_id"));
                customer1.setPassword(rs.getString("password"));
                customer1.setPhoto(rs.getString("photo"));
                customer1.setContact(rs.getString("contact"));
              
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return customer1;
   }
//     public customer  getByCategorry(String cat){
//      Vendor vendor=null;
//       ConnectionPool cp = ConnectionPool.getInstance();
//       cp.initialize();
//       Connection con = cp.getConnection();
//       if(con!=null){
//        try{
//            String sql = "select * from vendor1 where profession=?";
//            PreparedStatement smt = con.prepareStatement(sql);
//            smt.setString(1, cat);
//            ResultSet rs= smt.executeQuery();
//            if(rs.next()){
//                vendor =new Vendor();
//                vendor.setId(rs.getInt("id"));
//                vendor.setName(rs.getString("name"));
//                vendor.setEmail(rs.getString("email"));
//                vendor.setDob(rs.getString("dob"));
//                vendor.setGender(rs.getString("gender"));
//                vendor.setCity(rs.getString("city"));
//                vendor.setUserid(rs.getString("userid"));
//                vendor.setPassword(rs.getString("password"));
//                vendor.setPhoto(rs.getString("photo"));
//                vendor.setContact(rs.getString("contact"));
//                vendor.setProfession(rs.getString("profession"));
//                vendor.setPincode(rs.getInt("pincode"));
//            }
//            smt.close();
//            cp.putConnection(con);
//        }   catch(Exception e){
//            System.out.println("Error :"+e.getMessage());
//        }
//       }
//       
//    return vendor;
//   }
    public ArrayList<customer>  getAllRecords(){
    
       ArrayList<customer> customer1 =new ArrayList<customer>();
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from customer";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
                customer  customer2=new customer();
                 customer2.setId(rs.getInt("id"));
                 customer2.setName(rs.getString("name"));
                 customer2.setEmail(rs.getString("email"));
                 customer2.setDob(rs.getString("dob"));
                 customer2.setGender(rs.getString("gender"));
                
                 customer2.setUser_id(rs.getString("user_id"));
                 customer2.setPassword(rs.getString("password"));
                 customer2.setPhoto(rs.getString("photo"));
                 customer2.setContact(rs.getString("contact"));
                 customer2.setCity(rs.getString("city"));
               
                customer1.add(customer2);
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return customer1;
   }
     public ArrayList<customer>  getAllRecordsByCategory(String cat){
    
       ArrayList<customer> customer1 =new ArrayList<customer>();
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from customer where =?";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
                customer  vendors=new customer();
                vendors.setId(rs.getInt("id"));
                vendors.setName(rs.getString("name"));
                vendors.setEmail(rs.getString("email"));
                vendors.setDob(rs.getString("dob"));
                vendors.setGender(rs.getString("gender"));
              
                vendors.setUser_id(rs.getString("userid"));
                vendors.setPassword(rs.getString("password"));
                vendors.setPhoto(rs.getString("photo"));
                vendors.setContact(rs.getString("contact"));
                vendors.setCity(rs.getString("city"));
              
                customer1.add(vendors);
            }
            smt.close();
            cp.putConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return customer1;
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
    public boolean  update(customer cust){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "update customer set name=?,gender=?,dob=?,email=?,photo=?,contact=?,city=? where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            //System.out.println(reporter.getName());
            smt.setString(1, cust.getName());
            smt.setString(4, cust.getEmail());
            smt.setString(2, cust.getGender());
            smt.setString(3, cust.getDob());
            smt.setString(7, cust.getCity());
      
            smt.setString(5, cust.getPhoto());
            smt.setString(6, cust.getContact());
            smt.setInt(8, cust.getId());
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
