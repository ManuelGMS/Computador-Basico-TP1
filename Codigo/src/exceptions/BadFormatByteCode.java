package exceptions;

/**
 * Excepción BadFormatByteCode.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

@SuppressWarnings("serial")
public class BadFormatByteCode extends Exception {

	/**
	 * Constructora de BadFormatByteCode.
	 */
	public BadFormatByteCode() {
		super();
	}
	
	/**
	 * Constructora de BadFormatByteCode.
	 * @param message Recive el mensaje de texto que habrá de mostrarse al capturar la excepción.
	 */
	public BadFormatByteCode(String message) {
		super(message);
	}
}
