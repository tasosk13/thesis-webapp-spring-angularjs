package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.dto.PostDTO;
import gr.uoa.di.scan.thesis.entity.Post;
import gr.uoa.di.scan.thesis.exception.EntityNotFoundException;
import gr.uoa.di.scan.thesis.repository.PostRepository;
import gr.uoa.di.scan.thesis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
public class PostServiceImpl extends GenericServiceBase<Post, PostDTO, Long> implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	JpaRepository<Post, Long> getRepository() {
		return postRepository;
	}

	@Override
	Class<Post> getTypeofEntity() {
		return Post.class;
	}

	@Override
	Class<PostDTO> getTypeofDTO() {
		return PostDTO.class;
	}

	@Override
	@Transactional(rollbackFor = EntityNotFoundException.class)
	public PostDTO create(PostDTO dto) throws EntityNotFoundException {
		if (userRepository.exists(dto.getCreatedBy().getId()))
			return super.create(dto);
		else
			throw new EntityNotFoundException();
	}


}