package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.dto.CommentDTO;
import gr.uoa.di.scan.thesis.entity.Comment;
import gr.uoa.di.scan.thesis.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl extends GenericServiceBase<Comment, CommentDTO, Long> implements CommentService{

	@Autowired
	private CommentRepository commentRepository;

	public CommentServiceImpl() {
		super();
	}

	@Override
	JpaRepository<Comment, Long> getRepository() {
		return commentRepository;
	}

	@Override
	Class<Comment> getTypeofEntity() {
		return Comment.class;
	}

	@Override
	Class<CommentDTO> getTypeofDTO() {
		return CommentDTO.class;
	}

}
