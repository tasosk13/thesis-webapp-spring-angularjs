package gr.uoa.di.scan.controller;

import java.util.Map;

import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
		
		UserDTO userForm = new UserDTO();    
        model.put("userForm", userForm);
		
		System.out.println("Responding on endpoint request /user/register"); 
        return "/WEB-INF/jsp/Registration.jsp";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") UserDTO user, Map<String, Object> model) {
         
		userService.create(user);
         
        return "/WEB-INF/jsp/RegistrationSuccess.jsp";
    }


	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	String deleteUser(@PathVariable long userId) {
		
		userService.delete(userId);
		System.out.println("Responding on endpoint request /user/delete/"+userId);
		return "user deleted";
	}
	

}
