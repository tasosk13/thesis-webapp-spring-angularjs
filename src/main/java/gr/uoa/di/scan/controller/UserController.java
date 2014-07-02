package gr.uoa.di.scan.controller;

import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	Gson gson;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody
	String createUser() {
		UserDTO newUser = new UserDTO();
		newUser.setUsername("giorgos");
		newUser.setEmail("giorgos@di.gr");
		newUser.setPassword("pass");
		newUser = userService.create(newUser);
		System.out.println("Responding on endpoint request /user/create");
		return gson.toJson(newUser, UserDTO.class);
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	String deleteUser(@PathVariable long userId) {
		
		userService.delete(userId);
		System.out.println("Responding on endpoint request /user/delete/"+userId);
		return "user deleted";
	}
	

}
