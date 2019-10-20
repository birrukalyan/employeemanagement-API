package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

public interface Employeerepo extends CrudRepository<Employee,String>{
	@Modifying
    @Transactional
    void deleteByName(String firstName);
}
