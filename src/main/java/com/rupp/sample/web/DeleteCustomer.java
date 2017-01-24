package com.rupp.sample.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.AddUpdateCustomer;

public class DeleteCustomer extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session	=	request.getSession();
        	//System.out.println(session.getAttribute("authen"));
        	if(session.getAttribute("authen")==null){	//	have not login yet, redirect to login
        		response.sendRedirect("/signin");
        	}
			int id	=	0;
			AddUpdateCustomer objcust	=	new AddUpdateCustomer();
			if(request.getParameter("id")!=null){
				id	=	Integer.parseInt(request.getParameter("id"));
				int result	=	objcust.deleteRecord(id);
				if(result==1){	//	success
	    			System.out.println("Delete success");
	    			response.sendRedirect("customerlist");
	    		}else{	//	failed
	    			System.out.println("Delete failed");
	    			response.sendRedirect("customerlist");
	    		}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    @Override
    public void destroy() {
        
    }
}
