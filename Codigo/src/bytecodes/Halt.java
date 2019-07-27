package bytecodes;

import cpu.CPU;

/**
 * Implementacion de la clase Halt
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public class Halt implements ByteCode {

	/**
	 * Método que ejecuta el byteCode.
	 * @param cpu Recive una CPU.
	 */
	
	@Override
	public void execute(CPU cpu) {
		cpu.setHalt();
	}

	/**
	 * Método para parsear el byteCode.
	 * @param s Recive el byteCode completo como un vector de cadenas de texto.
	 * @return Devuelve un Bytecode si pudo parsearse, null en caso contrario.
	 */
	
	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else
			return null;
	}

	/**
	 * Método que devuelve el nombre del byteCode.
	 * @return Devuelve en forma de cadena de texto el nombre del byteCode.
	 */
	@Override
	public String toString() {
		return "HALT";
	}

}
