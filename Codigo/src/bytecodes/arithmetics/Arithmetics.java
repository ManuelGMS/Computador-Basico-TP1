package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;
import exceptions.DivisionByZero;
import exceptions.StackException;

/**
 * Implementacion de la clase Arithmetics
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
abstract public class Arithmetics implements ByteCode {

	protected int n1;
	protected int n2;

	@Override
	public void execute(CPU cpu) throws DivisionByZero, StackException {
		try {
			this.n1 = cpu.pop();
			this.n2 = cpu.pop();
			executeAux(cpu);

		}
		catch (DivisionByZero e) {
			throw new DivisionByZero("Es segundo operando es 0 y no se puede realizar la division");
		}
		catch (StackException e) {
			throw new StackException("Tamaño de pila insuficiente");
		}
		cpu.increaseProgramCounter();
	}
	
	/**
	 * Ejecuta una operacion aritmética lógica
	 * @param cpu
	 */
	abstract protected void executeAux(CPU cpu) throws DivisionByZero, StackException ;

	@Override
	public ByteCode parse(String[] words) {
		if(words.length!=1) return null;
		else return this.parseAux(words[0]);
	}
	
	/**
	 * Realiza el parse de una instruccion Arithmetics
	 * @param string1 string que se va a utilizar en el parse
	 * @return un objeto Bytecode si la sintaxis es correcta o null si es incorrecta
	 */
	abstract public ByteCode parseAux(String string1);
}
