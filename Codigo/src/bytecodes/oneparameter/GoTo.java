package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

/**
 * Implementacion de la clase GoTo
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class GoTo extends ByteCodeOneParameter {
	
	/**
	 * Contructora sin parametros de GoTo
	 */
	public GoTo() {}
	
	/**
	 * Constructora con parametro de GoTo
	 * @param j dirección de salto
	 */
	public GoTo(int j) {
		super(j);
	}

	@Override
	public void execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.setProgramCounter(this.param);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("GOTO"))
			return new GoTo(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "GOTO";
	}

}
