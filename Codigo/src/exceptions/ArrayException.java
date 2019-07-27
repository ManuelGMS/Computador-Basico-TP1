package exceptions;

/**
 * Excepción ArrayException.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

@SuppressWarnings("serial")
public class ArrayException extends Exception {
	
	/**
	 * Constructora de ArrayException.
	 */
	public ArrayException() {
		super();
	}
	
	/**
	 * Constructora de ArrayException.
	 * @param message Recive el mensaje de texto que habrá de mostrarse al capturar la excepción.
	 */
	public ArrayException(String message) {
		super(message);
	}
}
