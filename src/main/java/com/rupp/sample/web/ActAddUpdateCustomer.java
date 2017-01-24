package com.rupp.sample.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.AddUpdateCustomer;

public class ActAddUpdateCustomer extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session	=	request.getSession();
    	//System.out.println(session.getAttribute("authen"));
    	if(session.getAttribute("authen")==null){	//	have not login yet, redirect to login
    		response.sendRedirect("/signin");
    	}
    }

    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		HttpSession session	=	request.getSession();
        	//System.out.println(session.getAttribute("authen"));
        	if(session.getAttribute("authen")==null){	//	have not login yet, redirect to login
        		response.sendRedirect("/signin");
        	}
	    	String submitType	=	request.getParameter("submit");
	    	String firstName	=	request.getParameter("firstName");
	    	String lastName	=	request.getParameter("lastName");
	    	String gender	=	request.getParameter("gender");
	    	String email	=	request.getParameter("email");
	    	String phone	=	request.getParameter("phone");
	    	String address	=	request.getParameter("address");
	    	
	    	System.out.println(request.getParameter("dob"));
	    	String strDate	=	request.getParameter("dob");
    		//Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));     	
    		
    		DateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = originalFormat.parse(strDate);
            String date = targetFormat.format(dob); 
            System.out.println(date);
    		            
			AddUpdateCustomer objcust	=	new AddUpdateCustomer();
			
			
	    	switch(submitType){
		    	case "Update":
		    		int id	=	Integer.parseInt(request.getParameter("id"));
		    		int result	=	objcust.upateData(id, firstName, lastName, gender, email, phone, address, dob);
		    		if(result>=0){	//	success
		    			System.out.println("Update success");
		    			response.sendRedirect("customerlist");
		    		}else{	//	failed
		    			System.out.println("Update failed");
		    			response.sendRedirect("customerform");
		    		}
		    		
		    		break;
		    	default:	//add
		    		int insert_result	=	objcust.writeData(firstName, lastName, gender, email, phone, address, dob);
		    		if(insert_result==1){	//	success
		    			System.out.println("Insert success");
		    			response.sendRedirect("customerlist");
		    		}else{	//	failed
		    			System.out.println("Insert failed");
		    			response.sendRedirect("customerform");
		    		}
	    		break;
	    	}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    public void destroy() {
        
    }
}
