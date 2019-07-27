package instructions.assignments;

import bytecodes.ByteCode;
import cpu.Compiler;
import exceptions.ArrayException;
/**
 * Representa a las clases Variable y Number
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public interface Term {
	
	/**
	 * Traduce un string a un termino
	 * @param term string del termino
	 * @return objeto Term que corresponde al string
	 */
	Term parse(String term);
	
	/**
	 * Traduce un termino a bytecode
	 * @param compiler objeto Compiler
	 * @return bytecode correspondiente al termino
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	ByteCode compile(Compiler compiler) throws ArrayException;
}
