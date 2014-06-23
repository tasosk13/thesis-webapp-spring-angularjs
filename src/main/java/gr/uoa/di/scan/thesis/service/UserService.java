package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.entity.User;

public interface UserService extends GenericService<User, UserDTO, Long>{
	
	public UserDTO findByEmail(String email);
}
