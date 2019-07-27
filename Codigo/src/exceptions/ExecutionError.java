package exceptions;

/**
 * Excepción ExecutionError.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

@SuppressWarnings("serial")
public class ExecutionError extends Exception {
	
	/**
	 * Constructora de ExecutionError.
	 */
	public ExecutionError() {
		super();
	}
	
	/**
	 * Constructora de ExecutionError.
	 * @param message Recive el mensaje de texto que habrá de mostrarse al capturar la excepción.
	 */
	public ExecutionError(String message) {
		super(message);
	}
}
