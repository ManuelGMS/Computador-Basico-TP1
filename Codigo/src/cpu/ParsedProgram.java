package cpu;

import exceptions.ArrayException;
import instructions.Instruction;

/**
 * Porgrama parseado.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class ParsedProgram {

	private Instruction[] pProgram;
	private int numInstr;
	private static int MAX_INSTR = 100;
	
	/**
	 * Constructora de ParsedProgram.
	 */
	public ParsedProgram() {
		this.numInstr = 0;
		this.pProgram = new Instruction[ParsedProgram.MAX_INSTR];
	}
	
	/**
	 * Método para obtener el número de isntrucciones del parsedProgram.
	 * @return Devuelve el número de isntrucciones del parsedProgram.
	 */
	public int getNumInstr() {
		return this.numInstr;
	}
	
	/**
	 * Método para obtener una determinada instrucción del parsedProgram.
	 * @param pos Posición de la isntrucción en el programa.
	 * @return Devuelve la instrucción de la posición correspondiente.
	 * @throws ArrayException Se lanza una posición si la posición del vector del parsedProgram no existe.
	 */
	public Instruction getInstruction(int pos) throws ArrayException {
		if (0 <= pos && pos < this.numInstr)
			return this.pProgram[pos];
		else
			throw new ArrayException("Has intentado acceder a una posisicion que no existe de ParsedProgram");
	}

	/**
	 * Método para añadir una nueva instrucción al parsedProgram.
	 * @param instruction Recive una isntrucción para añadirla al parsedPorgram.
	 * @throws ArrayException Se lanza una excepción si la posición del vector parsedProgram no existe.
	 */
	public void add(Instruction instruction) throws ArrayException {
		if(this.numInstr >= ParsedProgram.MAX_INSTR)
			throw new ArrayException("Has intentado añadir una instruccion a ParsedProgram lleno");
		else {
			this.pProgram[this.numInstr++] = instruction;
		}
	}

	/**
	 * Método que resetea el número de isntrucciones del parsedProgram.
	 */
	public void reset() {
		this.numInstr = 0;
	}

	/**
	 * Método que devuelve el parsedProgram almacenado en una cadena de texto.
	 * @return Devuelve el parsedPorgram en una cadena de texto.
	 */
	public String toString() {	
		if (this.numInstr == 0)
			return "";
		else {
			String s = "Programa parseado almacenado:" + System.getProperty("line.separator");
			for (int i = 0; i < this.numInstr; i++)
				s += this.pProgram[i] + System.getProperty("line.separator");
	
			return s;
		}
	}
	
}
