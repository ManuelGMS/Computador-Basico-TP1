package instructions;

import cpu.Compiler;
import cpu.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;

/**
 * Interfaz para isntrucciones.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */

public interface Instruction {
	/**
	 * Se encarga de traducir el codigo imperativo a objetos Instruction
	 * @param words array de string con el código imperativo correspondiente a una linea
	 * @param lexParser clase que se encarga del análisis léxico
	 * @return Un objeto Instruction
	 * @throws LexicalAnalysisException error por instruccion erronea
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException ;
	
	/**
	 * Se encarga de traducir las instrucciones a bytecode
	 * @param compiler clase que se encarga de la compilacion
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	void compile(Compiler compiler) throws ArrayException;
}
