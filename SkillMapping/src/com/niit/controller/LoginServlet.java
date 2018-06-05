package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.repository.EmployeeRepository;
import com.niit.repository.EmployeeRepositoryImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		System.out.println("LoginServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 int  employeeId= Integer.parseInt(request.getParameter("employeeId"));
	 String password=request.getParameter("password");
	EmployeeRepository logi_n=new EmployeeRepositoryImpl();
	boolean flag=logi_n.validate(employeeId, password);
	RequestDispatcher rd;
	 if(flag)
	 { 
		 
		rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		 //sucess;
	 }
	 else
	 {
		 out.println("invalid credentials");
		rd=request.getRequestDispatcher("login.jsp");
		 rd.forward(request, response);
		 //login; 
	 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
