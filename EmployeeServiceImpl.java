package com.greatLearning.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.greatLearning.employeeManagement.dao.EmployeeRepository;
import com.greatLearning.employeeManagement.dao.RoleRepository;
import com.greatLearning.employeeManagement.dao.UserRepository;
import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.entity.Role;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	 
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee.result.get();
		}
		else {
			throw new RuntimeException("Didn't find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}
	
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
	@Override
	public List<Employee> searchByFirstName(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}
	
	@Override
	public List<Employee> sortByFirstName(String order) {
		
		if(order.equals("desc"))
			return employeeRepository.findAllByOrderByFirstNameDesc();
		else
			return employeeRepository.findAllByOrderByFirstNameAsc();
	}
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

}
