package com.example.cloudass1;
import java.io.*;
import java.util.*;
import java.lang.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Entity;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class app1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	 // Set response content type
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
  
	
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();


        Entity student = new Entity("Student");
        String Name=request.getParameter("Name");
	String Rollno=request.getParameter("Rollno");
	String DOB=request.getParameter("DOB");
       // out.println("Name:"+Name);
        student.setProperty("Name",Name);
        student.setProperty("Rollno",Rollno);
        
        student.setProperty("DOB",DOB);



        datastore.put(student);

	
	}



    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
                DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
              Query q = new Query("Student");
              PreparedQuery pq = datastore.prepare(q);

              
            out.println("<!DOCTYPE html>");
            out.println("<head>Student Details</head>");
            
           
            out.println("<body>");
            out.println("<table border=1>");
            
            out.println("<th>Name</th>");
            out.println("<th>Rollnumber</th>");
            out.println("<th>Date of Birth</th>");
            
            for (Entity result : pq.asIterable()) {
                  String Name = (String) result.getProperty("Name");
                  String Rollno = (String) result.getProperty("Rollno");
                  String DOB = (String) result.getProperty("DOB");
                  out.println("<tr>");
                 out.print("<td>"+Name+"</td>");
                 out.print("<td>"+Rollno+"</td>");
                 out.print("<td>"+DOB+"</td>");
                 out.println("</tr>");
           }
               
            out.println("</table>");
            out.println("<div style='margin-left:160px'><a href='cloudass1.jsp'>Back</a></div>");
            out.println("</body>");
            out.println("</html>");   
 

	  
         }
	} 
