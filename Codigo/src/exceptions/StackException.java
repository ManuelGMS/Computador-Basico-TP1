package exceptions;

/**
 * Excepción StackException.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

@SuppressWarnings("serial")
public class StackException extends ExecutionError {
	
	/**
	 * Constructora de StackException.
	 */
	public StackException() {
		super();
	}
	
	/**
	 * Constructora de StackException.
	 * @param message Recive el mensaje de texto que habrá de mostrarse al capturar la excepción.
	 */
	public StackException(String message) {
		super(message);
	}
}
