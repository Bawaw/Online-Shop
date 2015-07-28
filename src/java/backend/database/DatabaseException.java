/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.database;

/**
 *
 * @author Bawaw
 */
public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DatabaseException() {
		super();
	}

	public DatabaseException(String message, Throwable exception) {
		super(message, exception);
	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(Throwable exception) {
		super(exception);
	}

}
