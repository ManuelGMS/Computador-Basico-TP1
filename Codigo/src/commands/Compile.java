package commands;

import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import main.Engine;

/**
 * Comando Compile.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */

public class Compile implements Command {

	/**
	 * Método que devuelve una cadena de texto que explica que hace el comando.
	 * @return Devuelve una cadena de texto explicando que hace el comando.
	 */
	
	@Override
	public String textHelp() {
		return "COMPILE: Compila el programa cargado." + System.getProperty("line.separator");
	}

	/**
	 * Método que parsea el comando introducido para comprobar si es correcto.
	 * @return Devuelve un nuevo comando Compile si la comprobación es correcta, si no devuelve null.
	 */
	
	@Override
	public Command parse(String[] s) {
		if( s[0].equalsIgnoreCase("COMPILE") && s.length == 1 ) return new Compile(); else return null;
	}

	/**
	 * Método que invoca al método correspondiente de Engine que ejecuta el comando Compile.
	 */
	
	@Override
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException {
		engine.executeCompile();
	}
	
	/**
	 * Nombre del comando.
	 * @return Devuelve el nombre del comando a modo de cadena de texto.
	 */
	
	@Override
	public String toString() {
		return "COMPILE";
	}
	
}