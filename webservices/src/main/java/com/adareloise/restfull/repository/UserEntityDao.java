package com.adareloise.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adareloise.restfull.model.user.UserEntity;

public interface UserEntityDao extends JpaRepository<UserEntity, Integer>{

}
