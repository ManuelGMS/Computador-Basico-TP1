package bytecodes.oneparameter;

import bytecodes.ByteCode;

/**
 * Implementacion de la clase ByteCodeOneParameter
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public abstract class ByteCodeOneParameter implements ByteCode {
	protected int param;

	/**
	 * Contructora sin parametros de ByteCodeOneParameter
	 */
	public ByteCodeOneParameter(){};

	/**
	 * Constructora con parametro de ByteCodeOneParameter
	 * @param p parametro
	 */
	public ByteCodeOneParameter(int p){ this.param = p; }

	@Override
	public ByteCode parse(String[] words) {
		if (words.length != 2)
			return null;
		else
			return this.parseAux(words[0], words[1]);
	}

	/**
	 * Realiza el parse auxiliar para la funcion {@link bytecodes.Bytecode#parse(String[]) parse}
	 * @param string1
	 * @param string2
	 * @return un objeto ByteCode si la sintaxis es correcta o null si no lo es
	 */
	abstract protected ByteCode parseAux(String string1, String string2);

	public String toString() {
		return this.toStringAux() + " " + this.param;
	}
	
	/**
	 * Funcion auxiliar de {@link #toString() toString}
	 * @return string de el nombre de la instruccion bytecode
	 */
	abstract protected String toStringAux();
}