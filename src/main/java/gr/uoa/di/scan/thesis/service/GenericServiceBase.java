package gr.uoa.di.scan.thesis.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.dozer.DozerBeanMapper;

public abstract class GenericServiceBase<T, DTO, ID extends Serializable> implements GenericService<T, DTO, ID>{
		
	abstract JpaRepository<T, ID> getRepository();
	
	@Autowired
	protected DozerBeanMapper mapper;
	
	private final Class<T> genericTypeOfT;
	private final Class<DTO> genericTypeOfDTO;
	
	@SuppressWarnings("unchecked")
	public GenericServiceBase() {
		this.genericTypeOfT = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericServiceBase.class);
		this.genericTypeOfDTO = (Class<DTO>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericServiceBase.class);
	}
	
	
	
	@Transactional
	public DTO create(DTO dto) {
		return mapper.map(getRepository().save( mapper.map(dto, genericTypeOfT) ), genericTypeOfDTO);
	}

	@Transactional
	public DTO findByID(ID id) {
		return mapper.map(getRepository().findOne(id), genericTypeOfDTO);
	}
	
	@Transactional
	public List<DTO> findAll() {
		List<DTO> list = new ArrayList<DTO>();
		for (T entity : getRepository().findAll()){
			list.add(mapper.map(entity, genericTypeOfDTO));
		}
		return list;
	}
	
	@Transactional
	public DTO delete(ID id) {
		T entity = getRepository().findOne(id);

		if (entity == null)
			return null;

		getRepository().delete(entity);
		return mapper.map(entity, genericTypeOfDTO);
	}
}