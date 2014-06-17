package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.entity.User;

public interface UserService extends GenericService<User, Long>{
	
	public User update(User user);
}
