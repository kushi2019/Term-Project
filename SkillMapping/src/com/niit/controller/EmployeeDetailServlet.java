package com.niit.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class EmployeeDetailServlet
 */
@WebServlet("/EmployeeDetailServlet")
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeRepository employeeDetail=new EmployeeRepositoryImpl();
		List<Employee> emp_detail=employeeDetail.getAllEmployees();
		request.setAttribute("empDetail",emp_detail);
	    RequestDispatcher rd;
	    rd=request.getRequestDispatcher("EmployeeDetailDisplay.jsp");
	     rd.forward(request,response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
