package com.rupp.sample.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCustomer extends HttpServlet{
ArrayList<Users> arrUser	=	new ArrayList<Users>();
	
	@Override
    public void init() throws ServletException {
		System.out.println("---init method call ---");
        arrUser.add(new Users(1, "admin", "12345", new java.util.Date(System.currentTimeMillis()), ""));		
        arrUser.add(new Users(2, "customer", "12345", new java.util.Date(System.currentTimeMillis()), "ddd.jpg"));
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
     
    }

    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session	=	request.getSession();
    	String email	=	request.getParameter("txtemail");
        String password	=	request.getParameter("txtpassword");
        String urlPhoto	=	"";
        boolean is_succ	=	false;
    	for(Users user: arrUser){
    		if(user.getEmail().equals(email) && user.getPassword().equals(password)){
    			System.out.println("Login Successfully.");
    			session.setAttribute("id", user.getId());
    			session.setAttribute("email", user.getEmail());
    			session.setAttribute("createDate", user.getCreateDate());
    			
    			//System.out.println("Photo:"+urlPhoto);
    			session.setAttribute("authen", "1");
    			is_succ	=	true;    			
    		}
    	}
    	if(is_succ){    		
    		response.sendRedirect("customerlist");
    	}else{
	    	session.setAttribute("authen", 0);
	    	session.setAttribute("message", "Login Failed.");
	    	System.out.println("Login Failed.");
	    	response.sendRedirect("signIn");
    	}
    	
    	//request.setAttribute("message", "Login Failed.");
    	//request.getRequestDispatcher("formLogin.jsp").forward(request, response);
    	
    	//System.out.println(request.getParameterNames());    
    	//doGet(request, response);
    }
    @Override
    public void destroy() {
        System.out.println("=====destroy method is called====");
    }
}
