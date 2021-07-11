package com.educandoweb.course.service.exceptions;

/*
 *  classe de exceções dos serviços, sub do RuntTime q não obriga tratar
 */

public class ResourceNotFoundException extends RuntimeException{

 	private static final long serialVersionUID = 1L;
 	
/*
 * construtor recebendo o object id e lançar a msg, concatenado com o id 	
 */
 	public ResourceNotFoundException(Object id) {
 		super("Resource not found Id: " + id);
 	}

 	
}
