package gr.uoa.di.scan.thesis.service;

import java.util.List;

import gr.uoa.di.scan.thesis.entity.User;
import gr.uoa.di.scan.thesis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}

	public User findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
