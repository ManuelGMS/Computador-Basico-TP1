package commands;

import exceptions.ArrayException;
import exceptions.BadFormatByteCode;
import exceptions.ExecutionError;
import main.Engine;

/**
 * Comando que permite sustituir una instrucción de nuestro programa por otra nueva.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public class Replace implements Command {

	private int argument;
	
	/**
	 * Constructora por defecto de Replace.
	 */
	public Replace() {}
	
	/**
	 * Constructora de Replace con parámetro.
	 * @param argument argumento que se utiliza en este comando.
	 */
	public Replace(int argument) {
		this.argument = argument;
	}
	
	/**
	 * Texto de ayuda del comando.
	 * @return Deuvelve el texto de la ayuda correspondiente al comando.
	 */
	@Override
	public String textHelp() {
		return "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario." + System.getProperty("line.separator");
	}

	/**
	 * Parseador del comando.
	 * @param s Recive un array de strings que contiene lo introducido en el prompt.
	 * @return Devuelve un nuevo comando de este tipo si es posible parsearse, si no devuelve null.
	 */
	@Override
	public Command parse(String[] s) {
		if( s[0].equalsIgnoreCase("REPLACEBC") && s.length == 2 ) {
			try {
				int line = Integer.parseInt(s[1]);
				return new Replace(line); 
			}
			catch (NumberFormatException e) {
				return null;
			}
		}
		else 
			return null;
	}

	/**
	 * Ejecutor del comando.
	 * @param engine Recive el motor del programa.
	 * @throws ExecutionError errores al ejecutar un programa de bytecodes
	 * @throws BadFormatByteCode sintaxis incorrecta en bytecodes
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	@Override
	public void execute(Engine engine) throws ExecutionError, BadFormatByteCode, ArrayException {
		engine.executeReplace(this.argument);
	}
	
	/**
	 * Nombre del comando.
	 * @return Devuelve el nombre del comando y su argumento en forma de cadena de texto.
	 */
	@Override
	public String toString() {
		return "REPLACEBC" + " " + this.argument;
	}
}
