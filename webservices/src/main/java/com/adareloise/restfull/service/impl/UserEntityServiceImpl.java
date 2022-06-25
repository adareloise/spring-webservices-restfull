package com.adareloise.restfull.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.adareloise.restfull.model.user.UserEntity;
import com.adareloise.restfull.repository.UserEntityDao;
import com.adareloise.restfull.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserEntityServiceImpl implements UserEntityService{

	private final UserEntityDao userEntityDao;
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = this.userEntityDao.findAll();
		return users;
	}

	@Override
	public UserEntity findOne(Integer id){
		UserEntity user = this.userEntityDao.findById(id).orElse(null);
		return user;
	}

	@Override
	public UserEntity save(UserEntity user) {
		return this.userEntityDao.save(user);
	}

	@Override
	public void delete(Integer id){
		this.userEntityDao.deleteById(id);
	}

}
