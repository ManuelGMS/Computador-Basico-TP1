package main;

import exceptions.ArrayException;

/**
 * Clase creada para la gestión del código fuente de alto nivel.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class SourceProgram {

	private int numInstr;
	private String[] sProgram;
	private static int MAX_INSTR = 100;
	
	/**
	 * Constructora de SourceProgram.
	 */
	public SourceProgram() {
		this.numInstr = 0;
		this.sProgram = new String[SourceProgram.MAX_INSTR];
	}
	
	/**
	 * Método que obtiene el número de instrucciones del programa de alto nivel.
	 * @return Devuelve el número de instrucciones que componen el programa de alto nivel.
	 */
	public int getNumInstr() {
		return this.numInstr;
	}
	
	/**
	 * Método que obtiene la instrucción de alto nivel que se encuentra en una determinada línea.
	 * @param pos Número de línea en la que se encuentra la instrucción que queremos obtener.
	 * @return Devuelve la instrucción de la línea especificada.
	 * @throws ArrayException Se devuelve una excepción si introducimos una línea de programa inexistente.
	 */
	public String getInstruction(int pos) throws ArrayException {
		if (0 <= pos && pos < this.numInstr)
			return this.sProgram[pos];
		else
			throw new ArrayException("Has intentado acceder a una posisicion que no existe de SourceProgram");
	}

	/**
	 * Método para añadir nuevas instrucciones al programa de alto nivel
	 * @param instruction Nueva instrucción a instroducir.
	 * @throws ArrayException Se devuelve una excepción si introducimos una línea de programa inexistente.
	 */
	public void add(String instruction) throws ArrayException {
		if(this.numInstr >= SourceProgram.MAX_INSTR)
			throw new ArrayException("Has intentado añadir una instruccion a SourceProgram lleno.");
		else {
			this.sProgram[this.numInstr++] = instruction;
		}
	}

	/**
	 * Método para resetear el programa de alto nivel.
	 */
	public void reset() {
		this.numInstr = 0;
	}

	/**
	 * Devuelve una cadena de texto que contiene el programa de alto nivel instroducido.
	 * @return Devuelve una cadena de texto con el programa de alto nivel introducido.
	 */
	
	@Override
	public String toString() {
		
		if (this.numInstr == 0)
			return "";
		else {
			String s = "Programa fuente almacenado:" + System.getProperty("line.separator");
			for (int i = 0; i < this.numInstr; i++)
				s += i + ": " + this.sProgram[i] + System.getProperty("line.separator");
	
			return s;
		}
	}
	
}
