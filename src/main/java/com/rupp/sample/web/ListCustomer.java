package com.rupp.sample.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import jdbc.AddUpdateCustomer;

public class ListCustomer extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {		
        try {
        	HttpSession session	=	request.getSession();
        	//System.out.println(session.getAttribute("authen"));
        	if(session.getAttribute("authen")==null){	//	have not login yet, redirect to login
        		response.sendRedirect("/signin");
        	}
        	
        	int page	=	0;
        	if(request.getParameter("page")!=null)	page	=	Integer.parseInt(request.getParameter("page"));
        	int pageid=1;
        	if(page>0) {
        		pageid=page;
        	}
        	//System.out.println(pageid);
        	int maxResults=2;		
        	int from=maxResults*(pageid-1);
        	
        	
        	AddUpdateCustomer objcust	=	new AddUpdateCustomer();
			
			HashMap<String, Object> map	=	objcust.readDataLimit(from, maxResults);
			ArrayList<Customer> custs	=	(ArrayList<Customer>) map.get("custs");
			int totalRow	=	(int) map.get("total");
			int totalPage	=	totalRow/maxResults;
			if(totalRow%maxResults>0)	totalPage++;
			
			for(Customer cust:custs){				
				System.out.println(cust.getFirstName()+"  "+totalRow);
			}
			
			//System.out.println(totalPage+"  "+page);
			request.setAttribute("custs", custs);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", pageid);
						
			
			request.getRequestDispatcher("customer_list.jsp").forward(request, response);
			
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
