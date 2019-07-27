package commands;

import exceptions.ArrayException;
import exceptions.BadFormatByteCode;
import exceptions.ExecutionError;
import exceptions.LexicalAnalysisException;
import main.Engine;

/**
 * Representa los distintos comandos que puede utilizar un usuario.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public interface Command {
	/**
	 * Método que devuelve el nombre del comando.
	 * @return Devuelve el nombre del comando correspondiente a modo de cadena de texto.
	 */
	public String textHelp();
	
	/**
	 * Método para parsear el comando correspondiente.
	 * @param s Se recive el comando entero mediante un vector de cadenas  de texto.
	 * @return Devuelve el comando correspondiente si pudo parsearse, null en caso contrario.
	 */
	public Command parse(String[] s);
	
	/**
	 * Método que llama al método de Engine correspondiente para ejecutar el comando correspondiente.
	 * @param engine Recive un Engine.
	 * @throws ExecutionError Se lanzará una excepción de ejecución si no puede realizarse la operación.
	 * @throws LexicalAnalysisException Se lanzará un error si no se superó el análisis léxico.
	 * @throws ArrayException Se lanza una excepción si la posición del vector no existe.
	 * @throws BadFormatByteCode Se lanzará una excepción si el usuario no introduce correctamente un byteCode.
	 */
	public void execute(Engine engine) throws ExecutionError, LexicalAnalysisException, ArrayException, BadFormatByteCode;
}
