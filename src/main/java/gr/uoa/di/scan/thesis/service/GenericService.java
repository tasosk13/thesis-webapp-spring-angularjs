package gr.uoa.di.scan.thesis.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService< T, ID extends Serializable > {
	public T create(T t);
	public T findByID(ID id);
	public List<T> findAll();
	public T delete(ID id);
}
