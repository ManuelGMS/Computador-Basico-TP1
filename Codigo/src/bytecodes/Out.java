package bytecodes;

import cpu.CPU;
import exceptions.StackException;

/**
 * Implementacion de la clase Out
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public class Out implements ByteCode {

	/**
	 * Método que ejecuta el byteCode.
	 * @param cpu Recive una CPU.
	 */
	
	@Override
	public void execute(CPU cpu) throws StackException {
		cpu.increaseProgramCounter();
		System.out.println("consola: " + cpu.pop());
	}

	/**
	 * Método para parsear el byteCode.
	 * @return Devuelve un Bytecode si este pudo parsearse, si no, devuelve null.
	 */
	
	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else
			return null;
	}

	/**
	 * Método que devuelve el nombre del byteCode.
	 * @return Devuelve una cadena de texto con el nombre del byteCode.
	 */
	
	@Override
	public String toString() {
		return "OUT";
	}
	
}
