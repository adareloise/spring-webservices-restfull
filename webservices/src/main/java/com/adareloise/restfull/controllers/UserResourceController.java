package com.adareloise.restfull.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adareloise.restfull.exception.global.UserNotFoundException;
import com.adareloise.restfull.model.user.UserResource;
import com.adareloise.restfull.service.UserResourceDaoService;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserResourceDaoService service;
	
	@GetMapping("/users")
	public List<UserResource> retrieveAllUsers(){	
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<UserResource> retrieveUser(@PathVariable Integer id){	
		UserResource user = service.findOne(id);
		
		if (user == null)
			throw new UserNotFoundException("id: " + id);
		
		EntityModel<UserResource> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserResource user) {
		UserResource info = service.save(user);
		
		//build rute 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(info.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		UserResource user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);		
	}

}
