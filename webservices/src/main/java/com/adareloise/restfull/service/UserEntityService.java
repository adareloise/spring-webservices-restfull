package com.adareloise.restfull.service;

import java.util.List;

import com.adareloise.restfull.model.user.UserEntity;

public interface UserEntityService {

	public List<UserEntity> findAll();
	public UserEntity findOne(Integer id);
	public UserEntity save(UserEntity user);
	public void delete(Integer id);
	
}
