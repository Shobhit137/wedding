/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.booking;
import com.beans.customer;
import com.daos.BookingDao;

public class BookingController extends HttpServlet {

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String op=request.getParameter("op");
        if(op!=null && op.equalsIgnoreCase("add"))
        {
            String event=request.getParameter("event_name");
            System.out.println(event);
            String date=request.getParameter("event_date");
            System.out.println(date);
            
            HttpSession session = request.getSession();
            customer cust=(customer)session.getAttribute("customer");
            System.out.println("Customer name is"+cust.getName());
            System.out.println("Customer id is"+cust.getId());
           
           
          // booking booking=(booking)session.getAttribute("booking");
//           System.out.println("Name of event is"+booking.getEvent_name());
            //booking book = (booking)session.getAttribute("book");
           // System.out.println("Event_name is"+book.getEvent_name());
           
//            if(bk.add(book))
//                response.sendRedirect("Customer1/dashboard.jsp");
        }
    }

    
}
