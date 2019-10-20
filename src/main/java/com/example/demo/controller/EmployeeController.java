package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Employeerepo;
import com.example.demo.model.Alien;
import com.example.demo.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	Employeerepo repo;	
	
	@RequestMapping(path="/employees",produces = {"application/json"})
	@ResponseBody
	//@GetMapping(produces = "application/json")
	public List<Employee> getEmployees() {
		
		return (List<Employee>) repo.findAll();	
		
		
	}
	
	@RequestMapping("/employee/{name}")
	//@ResponseBody
	public Optional<Employee> getEmployee(@PathVariable() String name) {
		
		return repo.findById(name);	
	}

	@PostMapping("/employee")
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println("inside addEmployee");
		System.out.println("emp name "+emp.getName());
		repo.save(emp);
		return emp;
	}
	
	@PutMapping("/employee")
	@ResponseBody
	public Employee saveorupdateEmployee(@RequestBody Employee emp) {
		System.out.println("inside saveorupdateEmployee");
		System.out.println("emp name "+emp.getName());
		repo.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employee/{name}")
	public void deleteEmployee(@PathVariable() String name) {
		System.out.println("im in delete");
		repo.deleteByName(name);
			
		
	}
	
	
	
}
