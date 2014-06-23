package gr.uoa.di.scan.thesis.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericServiceBase<T, DTO, ID extends Serializable> implements GenericService<T, DTO, ID>{
		
	abstract JpaRepository<T, ID> getRepository();
	abstract Class<T> getTypeofEntity();
	abstract Class<DTO> getTypeofDTO();
	
	@Autowired
	protected DozerBeanMapper mapper;
	
	@Transactional
	public DTO create(DTO dto) {
		return mapper.map(getRepository().save( mapper.map(dto, getTypeofEntity()) ), getTypeofDTO());
	}

	@Transactional
	public DTO findByID(ID id) {
		return mapper.map(getRepository().findOne(id), getTypeofDTO());
	}
	
	@Transactional
	public List<DTO> findAll() {
		List<DTO> list = new ArrayList<DTO>();
		for (T entity : getRepository().findAll()){
			list.add(mapper.map(entity, getTypeofDTO()));
		}
		return list;
	}
	
	@Transactional
	public DTO delete(ID id) {
		T entity = getRepository().findOne(id);

		if (entity == null)
			return null;

		getRepository().delete(entity);
		return mapper.map(entity, getTypeofDTO());
	}
}