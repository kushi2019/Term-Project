package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.model.Employee;
import com.niit.repository.EmployeeRepository;
import com.niit.repository.EmployeeRepositoryImpl;

/**
 * Servlet implementation class RegistrationServlet
 */

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		response.setContentType("text/html");
		int empid=Integer.parseInt(request.getParameter("employeeId")	);
		String fName=request.getParameter("firstName");
		
		String address=request.getParameter("address");
		String lastname=request.getParameter("lastName");
		String password=request.getParameter("password");
		String active="0";
		
		Employee employee=new Employee();
		employee.setEmployeeId(empid);
		employee.setAddress(address);
		employee.setFirstName(fName);
		employee.setLastName(lastname);
		employee.setPassword(password);
		employee.setActiv_e(active);
		EmployeeRepository repository= new EmployeeRepositoryImpl();
		RequestDispatcher rd;
		if(repository.addEmployee(employee))
		{
			rd=request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("there is some error please fill frorm again");
			rd=request.getRequestDispatcher("/RegistrationForm.html");
			rd.include(request, response);
		}
		/*login form*/
		
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
