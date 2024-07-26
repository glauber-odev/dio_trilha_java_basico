package dio.spring.security.controller;

import dio.spring.security.handler.BusinessException;

public class CampoObrigatorioException extends BusinessException{

	public CampoObrigatorioException(String campo) {
		super(campo, "Este campo é obrigatório");
		
	}
		
}
