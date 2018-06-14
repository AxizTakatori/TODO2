package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.entity.User;

@Repository
public class PgUserDao implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM users",
				new BeanPropertyRowMapper<User>(User.class));
	}
}
