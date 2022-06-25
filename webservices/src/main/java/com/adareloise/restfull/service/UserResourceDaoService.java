package com.adareloise.restfull.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adareloise.restfull.model.user.UserResource;

@Component
public class UserResourceDaoService {
	private static List<UserResource> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		users.add(new UserResource(1, "adare", new Date()));
		users.add(new UserResource(2, "loise", new Date()));
		users.add(new UserResource(3, "david", new Date()));
	}
	
	public List<UserResource> findAll(){
		return users;
	}
	
	public UserResource save(UserResource user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public UserResource findOne(int id) {
		for (UserResource user:users) {
			if(user.getId()== id) {
				return user;
			}
		}
		return null;
	}
	
	public UserResource deleteById(int id) {
		Iterator<UserResource> iterator = users.iterator();
		while (iterator.hasNext()) {
			UserResource user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
