/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;
import com.beans.booking;
import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDao {
    public boolean add(booking book)
    {
        boolean status=false;
        ConnectionPool cp=ConnectionPool.getInstance();
        cp.initialize();
        Connection con=cp.getConnection();
        if(con!=null)
        {
            try{
               // con.setAutoCommit(false);
                String sql="Insert into booking(event_date,event_name,booking_date,status,customer_id,advance_amount,net_amount,city) values(?,?,?,?,?,?,?,?)";
                PreparedStatement smt=con.prepareStatement(sql);
               
                smt.setString(1,book.getEvent_date());
                smt.setString(2,book.getEvent_name());
                smt.setString(3,book.getBooking_date());
                smt.setString(4,book.getStatus());
                smt.setString(5,book.getCustomer_id());
                smt.setString(6,book.getAdvance_cost());
                smt.setString(7,book.getNet_amount());
                smt.setString(8,book.getCity());
                if(smt.executeUpdate()>0)
                    status=true;
                smt.close();
                cp.putConnection(con);
            }catch(Exception e)
            {
                System.out.println("Error Unwnated Exception :"+e.getMessage());
            }
        }
        return status;
    }
}
