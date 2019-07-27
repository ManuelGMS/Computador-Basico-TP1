package bytecodes;

import cpu.CPU;
import exceptions.DivisionByZero;
import exceptions.StackException;

/**
 * Clase abstracta de las distintas instrucciones bytecode
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public interface ByteCode {

	/**
	 * Ejecuta la instruccion bytecode
	 * @param cpu La CPU en la que se ejecuta el bytecode
	 * @throws DivisionByZero error de ejecución al dividir por cero
	 * @throws StackException error de ejecución al superar el tamaño permitido para la pila
	 */
	public void execute(CPU cpu) throws DivisionByZero, StackException ;
	
	/**
	 * Realiza el parse de la instruccion bytecode
	 * @param words Array de palabras que se van a utilizar en el parse
	 * @return Un objeto ByteCode si la sintaxis es correcta o null si no lo es
	 */
	public ByteCode parse(String[] words);

}
