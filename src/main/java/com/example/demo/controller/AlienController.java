package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;


@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	@ResponseBody
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/aliens",produces= {"application/json"})
	public List<Alien> getAliens(){
		return (List<Alien>) repo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid){
		return repo.findById(aid);
		
	}
	
	@DeleteMapping("/alien/{aid}")
	public Optional<Alien> deleteAlien(@PathVariable("aid") int aid){
		Optional<Alien> a=repo.findById(aid);
		//repo.delete(a);
		return repo.findById(aid);
		
	}
}
