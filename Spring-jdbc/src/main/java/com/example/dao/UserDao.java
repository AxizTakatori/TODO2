package com.example.dao;

import java.util.List;

import com.example.entity.User;

public interface UserDao {
	public List<User> findAll();
}
