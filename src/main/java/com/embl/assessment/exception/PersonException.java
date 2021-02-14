package com.embl.assessment.exception;

/**
 * Class definition for the Person Exception
 */
public class PersonException extends Exception {
    
    /**
     * Default Serial Version ID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Exception Constructor definition
     * @param message
     * @param throwable
     */
    public PersonException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    /**
     * Exception Constructor definition
     * @param message
     */
    public PersonException(String message) {
        super(message);
    }
}
