package instructions;

import bytecodes.Halt;
import cpu.Compiler;
import cpu.LexicalParser;
import exceptions.ArrayException;

/**
 * Instrucción Return.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Return implements Instruction {

	/**
	 * Método que realiza el análisis léxico de la instrucción Return.
	 * @param words Recive la isntrucción completa como un vector de cadenas de texto.
	 * @param lexParser Recive un analizador léxico.
	 * @return Devuelve una nueva isntrucción Return si se supera el análisis léxico, null en caso contrario.
	 */
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if( words.length == 1 && words[0].equalsIgnoreCase("return") ) { 
			lexParser.increaseProgramCounter();
			return new Return();
		} else
			return null;
	}

	/**
	 * Método que compila la instrucción Return.
	 * @param compiler Recive un compilador.
	 * @throws ArrayException Se lanza un error si la posición del array no existe.
	 */
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

}