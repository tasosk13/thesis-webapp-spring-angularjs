package gr.uoa.di.scan.thesis.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericServiceBase<T,ID extends Serializable> implements GenericService<T, ID>{
	
	JpaRepository<T, ID> repository;
	
	abstract JpaRepository<T, ID> getRepository();
	
	@Transactional
	public T create(T entity) {
		return getRepository().save(entity);
	}
	
	@Transactional
	public T findByID(ID id) {
		return getRepository().findOne(id);
	}
	
	@Transactional
	public List<T> findAll() {
		return getRepository().findAll();
	}
	
	@Transactional
	public T delete(ID id) {
		T entity = getRepository().findOne(id);

		if (entity == null)
			return null;

		getRepository().delete(entity);
		return entity;
	}
}