package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.entity.Post;
import gr.uoa.di.scan.thesis.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl extends GenericServiceBase<Post, Long> implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	JpaRepository<Post, Long> getRepository() {
		return postRepository;
	}
}