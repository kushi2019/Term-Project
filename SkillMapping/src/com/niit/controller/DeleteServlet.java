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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		EmployeeRepository empDelete=new EmployeeRepositoryImpl();
		int  employId=Integer.parseInt(request.getParameter("deleteEmp"));
		EmployeeRepository empI=new EmployeeRepositoryImpl();
		int del=empI.deleteEmployee(employId);
		RequestDispatcher rd;
		if(del!=0)
		{   out.println("deleted");
			rd=request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			out.println("Employee Id does not Exists");
			rd=request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
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
