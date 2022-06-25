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
import com.adareloise.restfull.model.user.UserEntity;
import com.adareloise.restfull.service.UserEntityService;

@RestController
public class UserEntityController {
	
	@Autowired
	private UserEntityService service;
	
	@GetMapping("/users")
	public List<UserEntity> retrieveAll(){	
		return this.service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<UserEntity> retrieve(@PathVariable Integer id){	
		UserEntity user = service.findOne(id);
		
		if (user == null)
			throw new UserNotFoundException("id: " + id);
		
		EntityModel<UserEntity> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers = 
				linkTo(methodOn(this.getClass()).retrieveAll());
		
		model.add(linkToUsers.withRel("all-users"));
		
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> create(@Valid @RequestBody UserEntity entity) {
		UserEntity info = service.save(entity);
		
		//build rute 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(info.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		service.delete(id);
	}

}
