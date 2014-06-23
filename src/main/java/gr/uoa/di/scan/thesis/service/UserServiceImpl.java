package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.entity.User;
import gr.uoa.di.scan.thesis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl extends GenericServiceBase<User, UserDTO, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	JpaRepository<User, Long> getRepository() {
		return userRepository;
	}
	
	@Override
	Class<User> getTypeofEntity() {
		return User.class;
	}

	@Override
	Class<UserDTO> getTypeofDTO() {
		return UserDTO.class;
	}
	
	@Transactional
	public UserDTO update(UserDTO userDto) {
		if( userRepository.exists(userDto.getId()))
			return mapper.map(getRepository().save(mapper.map(userDto, User.class)),UserDTO.class);
		return null;
	}

}
