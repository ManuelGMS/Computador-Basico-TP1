package exceptions;

/**
 * Excepción LexicalAnalysisException.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception {
	
	/**
	 * Constructora de LexicalAnalysisException.
	 */
	public LexicalAnalysisException() {
		super();
	}
	
	/**
	 * Constructora de LexicalAnalysisException.
	 * @param message Recive el mensaje de texto que habrá de mostrarse al capturar la excepción.
	 */
	public LexicalAnalysisException(String message) {
		super(message);
	}
}

