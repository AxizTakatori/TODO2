package jp.co.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<User> list = userService.findAll();
		model.addAttribute("userlist", list);

		return "list";
	}

}