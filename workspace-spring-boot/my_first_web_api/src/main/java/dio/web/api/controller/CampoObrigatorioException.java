package dio.web.api.controller;

import dio.web.api.handler.BusinessException;

public class CampoObrigatorioException extends BusinessException{

	public CampoObrigatorioException(String campo) {
		super(campo, "Este campo é obrigatório");
		
	}
		
}
