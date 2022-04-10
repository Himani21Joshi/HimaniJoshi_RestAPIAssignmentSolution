package com.greatLearning.employeeManagement.service;

import java.util.List;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.entity.User;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
	public List<Employee> searchByFirstName(String firstName);
	public List<Employee> sortByFirstName(String order);
	public User saveUser(User user);
	public Role saveRole(Role role);
}
