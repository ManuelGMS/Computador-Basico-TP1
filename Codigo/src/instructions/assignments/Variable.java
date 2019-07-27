package instructions.assignments;

import bytecodes.ByteCode;
import bytecodes.oneparameter.Load;
import cpu.Compiler;
import exceptions.ArrayException;

/**
 * Clase que representa una variable
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Variable implements Term {

	private String varName;
	
	/**
	 * Constructora sin argumentos
	 */
	public Variable(){}
	
	/**
	 * Constructora con argumentos
	 * @param varName nombre de la variable
	 */
	public Variable(String varName) {
		this.varName = varName;
	}

	/**
	 * Método para parsear el término.
	 * @param term Recive como texto el nombre de una variable.
	 * @return Devuelve un término si pudo parsearse, null en caso contrario.
	 */
	
	@Override
	public Term parse(String term) {
		if (term.length()!=1)
			return null;
		else {
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z')
				return new Variable(term);
			else
				return null;
		}
		
	}

	/**
	 * Método para realizar la compilación.
	 * @return Devuelve un byteCode.
	 */
	
	@Override
	public ByteCode compile(Compiler compiler) throws ArrayException {
		return new Load(compiler.getIndex(this.varName));
	}
	
	/**
	 * Método que devuelve el nombre de la variable.
	 * @return Deuvuelve el nombre de la variable a modo de cadena de texto.
	 */
	
	@Override
	public String toString() {
		return this.varName;
	}

}
