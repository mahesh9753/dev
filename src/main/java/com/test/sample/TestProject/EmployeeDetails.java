package com.test.sample.TestProject;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeDetails {

	private static final List<Employee> employees = new ArrayList<Employee>();

	static {
		employees.add(new Employee(1, "Mark", 28));
		employees.add(new Employee(2, "John", 32));
		employees.add(new Employee(3, "David", 24));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return employees;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getAllEmployee(@PathParam(value = "id") int id) {
		for (Employee emp : employees)
			if (id == emp.getId())
				return emp;
		return null;
	}

}
