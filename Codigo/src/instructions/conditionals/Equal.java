package instructions.conditionals;

import bytecodes.oneparameter.conditionaljumps.ConditionalJumps;
import bytecodes.oneparameter.conditionaljumps.IfEq;
import instructions.assignments.Term;

/**
 * Clase que representa la condicion de igualdad
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Equal extends Condition {
	
	/**
	 * Constructora sin argumentos
	 */
	public Equal() {
		super();
	}
	
	/**
	 * Constructora con argumentos
	 * @param t1 primer termino
	 * @param t2 segundo termino
	 */
	public Equal(Term t1, Term t2) {
		super(t1, t2);
	}

	/**
	 * Parseador de la condición.
	 * @param t1 Recive una variable o un literal.
	 * @param op Operador relacional.
	 * @param t2 Recive una variable o un literal.
	 * @return Devuelve una condición si esta pudo parsearse, null en caso contrario.
	 */
	
	@Override
	protected Condition parse(Term t1, String op, Term t2) {
		if (op.equalsIgnoreCase("="))
			return new Equal(t1, t2);
		else
			return null;
	}

	/**
	 * Método de compilación auxiliar.
	 * @return Devuelve un objeto de tipo salto condicional.
	 */
	
	@Override
	protected ConditionalJumps compileAux() {
		return new IfEq();
	}

	/**
	 * Método que devuelve el nombre del byteCode.
	 * @return Devuelve el nombre del byteCode en forma de  cadena de texto.
	 */
	
	@Override
	public String toString() {
		return "EQUAL";
	}
	
}
