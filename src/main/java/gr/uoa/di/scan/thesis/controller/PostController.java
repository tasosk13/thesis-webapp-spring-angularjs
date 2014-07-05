package gr.uoa.di.scan.thesis.controller;

import gr.uoa.di.scan.thesis.dto.PostDTO;
import gr.uoa.di.scan.thesis.entity.Post;
import gr.uoa.di.scan.thesis.service.GenericService;
import gr.uoa.di.scan.thesis.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController extends GenericController<Post,PostDTO, Long>{
	
	@Autowired
	PostService postService;
	
	@Override
	GenericService<Post,PostDTO, Long> getService() {
		
		return postService;
	}
	
}
