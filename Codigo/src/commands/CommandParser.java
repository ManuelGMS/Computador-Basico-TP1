package commands;

/**
 * Clase que trata de parsear los comandos introducidos por el prompt.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class CommandParser {

	private final static Command[] COMMANDS = {
			new Help(), new Quit(),
			new Replace(), new Run(),
			new Compile(), new Load()
	};
	
	/**
	 * Parseador de los comandos del prompt. 
	 * @param line Recive como parámetro una cadena de texto que contiene lo que se introdujo en el prompt.
	 * @return Deuelve el comando correspondiente o null si no se pudo parsear el comando introducido.
	 */
	public static Command parse(String line) {

		int i = 0;
		Command command = null;
		String lineDecode[] = line.trim().split(" +");		
		
		while( i < CommandParser.COMMANDS.length && command == null ) {
			command = CommandParser.COMMANDS[i++].parse(lineDecode);
		}
		
		return command;	
	}

	/**
	 * Muestra por pantalla la ayuda del intérprete de comandos.
	 */
	public static void showHelp() {
		 for( Command command : CommandParser.COMMANDS ) 
			 System.out.print( command.textHelp() );	 
	}
	
}