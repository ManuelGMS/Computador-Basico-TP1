package instructions.assignments;

import bytecodes.ByteCode;
import bytecodes.oneparameter.Push;
import cpu.Compiler;

/**
 * La clase Number hace lo propio y parsea un entero
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Number implements Term {

	private int literal;
	
	/**
	 * Constructora sin argumentos
	 */
	public Number(){}
	
	/**
	 * Constructora con argumentos
	 * @param literal numero que se va a parsear
	 */
	public Number(int literal) {
		this.literal = literal;
	}
	
	/**
	 * Método para parsear el término.
	 * @param term Recive como texto el valor de un literal.
	 * @return Devuelve un término si pudo parsearse, null en caso contrario.
	 */
	
	@Override
	public Term parse(String term) {
		try {
			return new Number(Integer.parseInt(term));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Método para realizar la compilación.
	 * @return Devuelve un byteCode.
	 */
	
	@Override
	public ByteCode compile(Compiler compiler) {
		return new Push(this.literal);
	}

	/**
	 * Método que devuelve el valor del literal.
	 * @return Deuvuelve el valor del literal a modo de cadena de texto.
	 */
	
	@Override
	public String toString() {
		return Integer.toString(this.literal);
	}
	
}