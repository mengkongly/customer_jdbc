package com.rupp.sample.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import jdbc.AddUpdateCustomer;

public class CustomerForm extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {                
        try {
        	HttpSession session	=	request.getSession();
        	//System.out.println(session.getAttribute("authen"));
        	if(session.getAttribute("authen")==null){	//	have not login yet, redirect to login
        		response.sendRedirect("/signin");
        	}
        	if(request.getParameter("id")!=null){
        		int id	=	Integer.parseInt(request.getParameter("id"));
        		AddUpdateCustomer getCust	=	new AddUpdateCustomer();
        		Customer cust	=	getCust.readDataById(id);
    			request.setAttribute("cust", cust);      		
        	}						
			request.getRequestDispatcher("customer_form.jsp").forward(request, response);
			
		} catch (Exception e) {
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
