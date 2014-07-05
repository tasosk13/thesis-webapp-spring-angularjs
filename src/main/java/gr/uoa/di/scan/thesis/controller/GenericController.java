package gr.uoa.di.scan.thesis.controller;

import gr.uoa.di.scan.thesis.entity.Identifiable;
import gr.uoa.di.scan.thesis.exception.EntityNotFoundException;
import gr.uoa.di.scan.thesis.service.GenericService;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public abstract class GenericController<T, DTO extends Identifiable<ID>, ID extends Serializable > {
	
	//@Autowired
	//private GenericServiceBase<T, DTO, ID> service;
	
	abstract GenericService<T,DTO, ID> getService();
		
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public DTO create( DTO dto) {

		return getService().create(dto);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody DTO get(@PathVariable ID id) {
		
		return getService().findByID(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody DTO update(@RequestBody DTO dto) {
		
		return getService().update(dto);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus( value = HttpStatus.OK)
	public void delete(@PathVariable ID id) {
		
		getService().delete(id);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleEntityNotFoundException(EntityNotFoundException e) {
		
		return e.getMessage();
	}

}
