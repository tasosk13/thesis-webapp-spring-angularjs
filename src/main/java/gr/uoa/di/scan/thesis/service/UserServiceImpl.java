package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.entity.User;
import gr.uoa.di.scan.thesis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends GenericServiceBase<User, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	JpaRepository<User, Long> getRepository() {
		return userRepository;
	}

}
