package es.nextdigital.atm.exceptions;

public class ATMException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String UNKNOWN = "UNKNOWN";
	public static final String INTERNAL_ERROR = "INTERNAL_ERROR";

    /**
     * Valor del result.info.
     * Descripción genérica del error. 
     * */
    private Integer errorCode;

    /**
     * Descripción detallada del error. 
     * */
    private String errorMessage;
    
    public ATMException(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }



}