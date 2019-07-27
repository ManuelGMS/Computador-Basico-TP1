package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;
import exceptions.StackException;

/**
 * Implementacion de la clase Add
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Add extends Arithmetics {
	
	@Override
	public ByteCode parseAux(String s) {
		if (s.equalsIgnoreCase("ADD")) {
			return new Add();
		}
		else return null;
	}
	
	@Override
	protected void executeAux(CPU cpu) throws StackException {
		cpu.push(this.n2+this.n1);
	}

	@Override
	public String toString() {
		return "ADD";
	}
	
}
