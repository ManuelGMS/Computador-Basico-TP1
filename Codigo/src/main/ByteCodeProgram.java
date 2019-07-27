package main;

import bytecodes.ByteCode;
import exceptions.ArrayException;

/**
 * Implementacion de la clase ByteCodeProgram
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class ByteCodeProgram {

	private int numInstr;
	private ByteCode[] program;
	private static int MAX_INSTR = 100;
	
	/**
	 * Constructor generico para ByteCodeProgram
	 */
	public ByteCodeProgram() {
		this.numInstr = 0;
		this.program = new ByteCode[ByteCodeProgram.MAX_INSTR];
	}
	
	/**
	 * Devuelve el numero de instrucciones que tiene el programa
	 * @return número de instrucciones
	 */
	public int getNumInstr() {
		return this.numInstr;
	}
	
	/**
	 * Devuelve la instruccion de una posicion determinada
	 * @param pos posicion de la instrucción
	 * @return si la instruccion existe devuelve esta y si no null 
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	public ByteCode getInstruction(int pos) throws ArrayException {
		if (0 <= pos && pos < this.numInstr)
			return program[pos];
		else
			throw new ArrayException("Has intentado acceder a una posisicion que no existe de ByteCodeProgram");
	}

	/**
	 * Añade una instrucción al programa
	 * @param instruction instancia de la clase ByteCode
	 * @return devuelve true si la ejecucion es correcta o de lo contrario false
	 * @throws ArrayException Se devuelve una excepción si introducimos una línea de programa inexistente. 
	 */
	public boolean add(ByteCode instruction) throws ArrayException {
		if(this.numInstr >= ByteCodeProgram.MAX_INSTR)
			throw new ArrayException("Has intentado añadir una instruccion a ByteCodeProgram lleno");
		else {
			this.program[this.numInstr] = instruction;
			this.numInstr++;
			return true;
		}
	}
	/**
	 * Remplaza una instrucción de una posición determinada
	 * @param instruction instancia de la clase ByteCode
	 * @param programLine posición de la isntrucción
	 * @throws ArrayException Se devuelve una excepción si introducimos una línea de programa inexistente.
	 */
	public void replace(ByteCode instruction, int programLine) throws ArrayException {
		if (0 <= programLine && programLine < this.numInstr) {
			this.program[programLine] = instruction;
		}
		else
			throw new ArrayException("Error: La línea a reemplazar no pertenece al pograma");
	}

	/**
	 * Cambia a null todos los elementos del programa
	 */
	public void reset() {
		this.numInstr = 0;
	}

	/**
	 * Devuelve un string con las instrucciones del programa
	 * @return un string que describe el objeto
	 */
	
	@Override
	public String toString() {
		if (this.numInstr == 0)
			return "";
		else {
			String s = "Programa almacenado:" + System.getProperty("line.separator");
			for (int i = 0; i < this.numInstr; i++)
				s += i + ": " + this.program[i] + System.getProperty("line.separator");
	
			return s;
		}
	}

}