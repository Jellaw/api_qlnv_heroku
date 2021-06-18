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
public class AccountAPIController {
	public static Logger logger = LoggerFactory.getLogger(AccountAPIController.class);
	
	@Autowired
	AccountService accountService;
	@RequestMapping(value = "/acc/", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> listAllAccContact(){
		List<Account> listEmpl= accountService.findAll();
		if(listEmpl.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Account>>(listEmpl, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/acc/{id}", method = RequestMethod.GET)
	public Account findAccContact(@PathVariable("id") long id) {
		Account emp= accountService.getOne(id);
		if(emp == null) {
			ResponseEntity.notFound().build();
		}
		return emp;
	}
	
	@RequestMapping(value = "/acc/", method = RequestMethod.POST)
	public Account saveAccContact(@Valid @RequestBody Account contact) {
		return accountService.save(contact);
	}
	
	@RequestMapping(value = "/acc/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Account> updateAccContact(@PathVariable(value = "id") Long contactId, 
	                                       @Valid @RequestBody Account contactForm) {
		Account emp = accountService.getOne(contactId);
	    if(emp == null) {
	        return ResponseEntity.notFound().build();
	    }
	    emp.setPassword(contactForm.getPassword());

	    Account updatedContact = accountService.save(emp);
	    return ResponseEntity.ok(updatedContact);
	}
	
	@RequestMapping(value = "/acc/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Account> deleteAccContact(@PathVariable(value = "id") Long id) {
		Account contact = accountService.getOne(id);
	    if(contact == null) {
	        return ResponseEntity.notFound().build();
	    }

	    accountService.delete(contact);
	    return ResponseEntity.ok().build();
	}
	
	
}
