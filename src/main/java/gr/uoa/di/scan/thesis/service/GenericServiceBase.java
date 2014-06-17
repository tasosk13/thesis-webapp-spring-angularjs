package gr.uoa.di.scan.thesis.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericServiceBase<T,ID extends Serializable> implements GenericService<T, ID>{
	
	JpaRepository<T, ID> repository;
	
	abstract JpaRepository<T, ID> getRepository();
	
	@Transactional
	public T create(T t) {
		return getRepository().save(t);
	}
	public T findByID(ID id) {
		return null;
	}
	public List<T> findAll() {
		return null;
	}
	public T update(T t) {
		return null;
	}
	public T delete(ID id) {
		return null;
	}
}