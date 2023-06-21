package es.nextdigital.atm.exceptions;

import lombok.Setter;

public class ATMException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String UNKNOWN = "UNKNOWN";
	public static final String INTERNAL_ERROR = "INTERNAL_ERROR";
	
	/**
    * Descripción genérica del error. 
    * */
    private String info;

    /**
     * Valor del result.info.
     * Descripción genérica del error. 
     * */
    private Integer errorCode;

    /**
     * Descripción detallada del error. 
     * */
    private String errorMessage;
    
    /**
     * Código HTTP de la respuesta. 
     * */
    private int httpCode;

    private ATMException(int httpCode, String info, Integer errorCode, String errorMessage) {
        this.httpCode = httpCode;
        this.info = info;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }



}