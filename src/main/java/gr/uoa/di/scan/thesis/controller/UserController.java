package gr.uoa.di.scan.thesis.controller;

import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.entity.User;
import gr.uoa.di.scan.thesis.service.GenericService;
import gr.uoa.di.scan.thesis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User,UserDTO, Long>{
	
	@Autowired
	UserService userService;
	
	@Override
	GenericService<User,UserDTO, Long> getService() {
		
		return userService;
	}
	
}
