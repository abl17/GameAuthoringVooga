package exceptions.engine;

import exceptions.EngineException;

/**
 * Thrown when IEngine attempts to run a game that has not been instantiated, or initialized. w.e.
 * 
 * @author Austin, Bridge
 *
 */

public class NullGameException extends EngineException {

	/**
	 * Filler Serial Version ID
	 * TODO: Interpret this, or change this
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MESSAGE = "Game has not been instantiated!";
	
	public NullGameException(String err, String argument) {
		super(err, argument);
	}
	
	public NullGameException(String argument) {
		super(ERROR_MESSAGE, argument);
	}
	
	
}
