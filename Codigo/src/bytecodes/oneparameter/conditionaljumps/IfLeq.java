package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;

/**
 * Implementacion de la clase IfLeq
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class IfLeq extends ConditionalJumps {

	/**
	 * Contructora sin parametros de IfLeq
	 */
	public IfLeq() {}
	
	/**
	 * Constructora con parametro de IfLeq
	 * @param j dirección de salto
	 */
	public IfLeq(int j) {
		super(j);
	}
	
	@Override
	protected boolean compare(int n1, int n2) {
		return n1<=n2;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFLEQ"))
			return new IfLeq(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "IFLEQ";
	}
	
}
