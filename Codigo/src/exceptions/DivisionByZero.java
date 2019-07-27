package exceptions;

/**
 * Excepción DivisionByZero.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

@SuppressWarnings("serial")
public class DivisionByZero extends ExecutionError {
	
	/**
	 * Constructora de DivisionByZero.
	 */
	public DivisionByZero() {
		super();
	}
	
	/**
	 * Constructora de DivisionByZero.
	 * @param message Recive el mensaje de texto que habrá de mostrarse al capturar la excepción.
	 */
	public DivisionByZero(String message) {
		super(message);
	}
}
