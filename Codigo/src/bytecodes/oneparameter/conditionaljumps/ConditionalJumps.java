package bytecodes.oneparameter.conditionaljumps;

import bytecodes.oneparameter.ByteCodeOneParameter;
import cpu.CPU;
import exceptions.StackException;

/**
 * Implementacion de la clase ConditionalJumps
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
abstract public class ConditionalJumps extends ByteCodeOneParameter {
	
	/**
	 * Contructora sin parametros de ConditionalJumps
	 */
	public ConditionalJumps() {}

	/**
	 * Constructora con parametro de ConditionalJumps
	 * @param j dirección de salto
	 */
	public ConditionalJumps(int j) {
		super(j);
	}

	@Override
	public void execute(CPU cpu) throws StackException {
		int n1 = cpu.pop();
		int n2 = cpu.pop();
		if (!compare(n2,n1))
			cpu.setProgramCounter(this.param);
		else
			cpu.increaseProgramCounter();
	}
	
	/**
	 * Método para establecer la línea a la que dar el salto.
	 * @param j Número de línea a la que saltar.
	 */
	public void setJump(int j) {
		this.param = j;
	}

	/**
	 * Comparacion de dos datos
	 * @param n1 primer operando
	 * @param n2 segundo operando
	 * @return true si la comparacion es verdad y false si es falsa
	 */
	abstract protected boolean compare(int n1, int n2);
}
