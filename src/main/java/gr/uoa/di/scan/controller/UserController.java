package gr.uoa.di.scan.controller;

import gr.uoa.di.scan.thesis.dto.PostDTO;
import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.exception.EntityNotFoundException;
import gr.uoa.di.scan.thesis.service.PostService;
import gr.uoa.di.scan.thesis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	Gson gson;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody
    String processRegistration(@ModelAttribute("userForm") UserDTO user) {
         
		userService.create(user);
         
        return "user created";
    }

	@RequestMapping(value = "/{userId}/updateUser", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody
    String updateUser(@ModelAttribute("userForm") UserDTO user) {
         
		userService.update(user);
		System.out.println("Responding on endpoint request /user/register");
		return "user updated";
    }


	@RequestMapping(value = "/{userId}/delete", method = RequestMethod.GET)
	public @ResponseBody
	String deleteUser(@PathVariable long userId) {
		
		userService.delete(userId);
		System.out.println("Responding on endpoint request /user/delete/"+userId);
		return "user deleted";
	}
	
	@RequestMapping(value = "/{userId}/createPost", method = RequestMethod.GET)
	public @ResponseBody
	String createPost(@PathVariable long userId) {
		
		UserDTO user = new UserDTO();
		user = userService.findByID(userId);
		PostDTO post = new PostDTO();
		post.setCreatedBy(user);
		postService.create(post);
		
		return "post created";
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleEntityNotFoundException(EntityNotFoundException e) {
		
		return e.getMessage();
	}
	

}
