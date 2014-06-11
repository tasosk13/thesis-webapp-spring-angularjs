package gr.uoa.di.scan.thesis.service;

import java.util.List;

import gr.uoa.di.scan.thesis.entity.User;

public interface UserService {

	public User create(User user);
	public User findByID(Long id);
	public List<User> findAll();
	public User update(User user);
	public User delete(Long id);
	
}
