package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;
import exceptions.DivisionByZero;
import exceptions.StackException;

/**
 * Implementacion de la clase Div
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Div extends Arithmetics {

	@Override
	public ByteCode parseAux(String s) {
		if (s.equalsIgnoreCase("DIV"))
			return new Div();
		else
			return null;
	}

	@Override
	protected void executeAux(CPU cpu) throws DivisionByZero, StackException {
		if (this.n2 == 0)
			throw new DivisionByZero("No se puede dividir por cero");
		else
			cpu.push(this.n2 / this.n1);
	}

	@Override
	public String toString() {
		return "DIV";
	}
	
}
