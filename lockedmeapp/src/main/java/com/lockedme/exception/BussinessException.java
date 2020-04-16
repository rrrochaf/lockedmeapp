package com.lockedme.exception;

import java.io.IOException;

/**
 * 
 * @author Ricardo R. Rocha Filho
 * 
 */
public class BussinessException extends IOException {

	public BussinessException() {
		super();

	}

	public BussinessException(final String message) {
		super(message);

	}

}
