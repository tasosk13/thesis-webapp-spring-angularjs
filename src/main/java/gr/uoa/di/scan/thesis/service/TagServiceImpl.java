package gr.uoa.di.scan.thesis.service;

import gr.uoa.di.scan.thesis.dto.TagDTO;
import gr.uoa.di.scan.thesis.entity.Tag;
import gr.uoa.di.scan.thesis.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("tagService")
public class TagServiceImpl extends GenericServiceBase<Tag, TagDTO, Long> implements TagService {

	@Autowired
	private TagRepository tagRepository;

	@Override
	JpaRepository<Tag, Long> getRepository() {
		return tagRepository;
	}

}
