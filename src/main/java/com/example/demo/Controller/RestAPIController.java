package com.example.demo.Controller;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Account;
import com.example.demo.Model.Employee;
import com.example.demo.AccountService;
import com.example.demo.EmployeeServices;

@RestController
@RequestMapping("/api")

public class RestAPIController {
public static Logger logger = LoggerFactory.getLogger(RestAPIController.class);
	
	@Autowired
	EmployeeServices employeeService;
	@RequestMapping(value = "/contact/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllContact(){
		List<Employee> listEmpl= employeeService.findAll();
		if(listEmpl.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(listEmpl, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public Employee findContact(@PathVariable("id") long id) {
		Employee emp= employeeService.getOne(id);
		if(emp == null) {
			ResponseEntity.notFound().build();
		}
		return emp;
	}
	
	@RequestMapping(value = "/contact/", method = RequestMethod.POST)
	public Employee saveContact(@Valid @RequestBody Employee contact) {
		return employeeService.save(contact);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateContact(@PathVariable(value = "id") Long contactId, 
	                                       @Valid @RequestBody Employee contactForm) {
		Employee emp = employeeService.getOne(contactId);
	    if(emp == null) {
	        return ResponseEntity.notFound().build();
	    }
	    emp.setName(contactForm.getName());
	    emp.setPhone(contactForm.getPhone());
	    emp.setEmail(contactForm.getEmail());
	    emp.setAddress(contactForm.getAddress());
	    emp.setSalary(contactForm.getSalary());
	    emp.setPosition(contactForm.getPosition());
	    
	    Employee updatedContact = employeeService.save(emp);
	    return ResponseEntity.ok(updatedContact);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteContact(@PathVariable(value = "id") Long id) {
		Employee contact = employeeService.getOne(id);
	    if(contact == null) {
	        return ResponseEntity.notFound().build();
	    }

	    employeeService.delete(contact);
	    return ResponseEntity.ok().build();
	}
}
