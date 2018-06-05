package com.niit.controller;

import java.io.IOException;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empFirst=request.getParameter("empFirst");
		String empLast=request.getParameter("empLast");
		String empAddress=request.getParameter("empAddress");
		String empPass=request.getParameter("empPass");
		Employee emp =new Employee();
		emp.setEmployeeId(empId);
		emp.setAddress(empAddress);
				emp.setFirstName(empFirst);
				emp.setLastName(empLast);
				emp.setPassword(empPass);
EmployeeRepository empR=new EmployeeRepositoryImpl();
int upda=empR.UpdateEmploye_e(emp);
RequestDispatcher rd;
if(upda==1)
{
  rd=request.getRequestDispatcher("home.jsp");
  rd.forward(request, response);
}
else
{
	rd=request.getRequestDispatcher("Error.jsp");
	rd.forward(request,response);
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
