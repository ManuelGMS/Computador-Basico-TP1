package commands;

import exceptions.ExecutionError;
import main.Engine;

public class Load implements Command {

	private String path;
	
	/**
	 * Constructora de Load.
	 */
	public Load() {}
	
	/**
	 * Constructora de Load.
	 * @param path Recive como cadena de texto la ruta al archivo.
	 */
	public Load(String path) {
		this.path = path;
	}
	
	/**
	 * Método que devuelve una cadena de texto que explica que hace el comando.
	 * @return Devuelve una cadena de texto explicando que hace el comando.
	 */
	
	@Override
	public String textHelp() {	
		return "LOAD FICH: Carga el programa fuente desde el fichero especificado." + System.getProperty("line.separator");
	}

	/**
	 * Método que parsea el comando introducido para comprobar si es correcto.
	 * @return Devuelve un nuevo comando Load si la comprobación es correcta, si no devuelve null.
	 */
	
	@Override
	public Command parse(String[] s) {
		if( s[0].equalsIgnoreCase("LOAD") && s.length == 2 ) return new Load(s[1]); else return null;
	}

	/**
	 * Método que invoca al método correspondiente de Engine que ejecuta el comando Load.
	 */
	
	@Override
	public void execute(Engine engine) throws ExecutionError {
		engine.executeLoad(this.path);
	}
	
	/**
	 * Nombre del comando.
	 * @return Devuelve el nombre del comando a modo de cadena de texto.
	 */
	
	@Override
	public String toString() {
		return "LOAD " + this.path;
	}
	
}