package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;
import exceptions.StackException;

/**
 * Implementacion de la clase Push
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Push extends ByteCodeOneParameter {
	
	/**
	 * Contructora sin parametros de Push
	 */
	public Push() {}
	
	/**
	 * Constructora con parametro de Push
	 * @param p parametro del bytecode
	 */
	public Push(int p) {
		super(p);
	}

	@Override
	public void execute(CPU cpu) throws StackException {
		cpu.increaseProgramCounter();
		cpu.push(this.param);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("PUSH"))
			return new Push(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "PUSH";
	}

}
