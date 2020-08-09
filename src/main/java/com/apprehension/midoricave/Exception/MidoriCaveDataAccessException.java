package com.apprehension.midoricave.Exception;

import org.springframework.dao.DataAccessException;


/**
 * Exception to throw when Bottle Data Access fails
 * @author Midoriii
 *
 */

public class MidoriCaveDataAccessException extends DataAccessException {


	private static final long serialVersionUID = 24L;

	public MidoriCaveDataAccessException(String msg) {
		super(msg);
	}
	
	public MidoriCaveDataAccessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
