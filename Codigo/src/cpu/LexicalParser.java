package cpu;

import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import instructions.Instruction;
import instructions.InstructionParser;
import main.SourceProgram;

/**
 * Analizador léxico.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class LexicalParser {

	private int programCounter;
	private SourceProgram sProgram;
	
	/**
	 * Constructora del analizador léxico.
	 * @param sProgram Recive un programa de alto nivel.
	 */
	public LexicalParser(SourceProgram sProgram) {
		this.programCounter = 0;
		this.sProgram = sProgram;
	}
	
	/**
	 * Método que  se ocupa de realizar el análisis léxico de un parsedPorgram.
	 * @param pProgram Recive un parsedProgram.
	 * @param stopKey Recive el identificador de parada del análisis.
	 * @throws LexicalAnalysisException Se lanzará una excepción si falla el análisis léxico.
	 * @throws ArrayException Se lanzará una excepción si la posición del vector no existe.
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException, ArrayException {
		
		boolean stop = false;
		
		while (this.programCounter < this.sProgram.getNumInstr() && !stop) {
			
			String sInstr = this.sProgram.getInstruction(this.programCounter).trim();
			
			if (sInstr.equalsIgnoreCase(stopKey)) {
				stop = true;
			} else {
				try {
				Instruction instr = InstructionParser.parse(sInstr, this);
				pProgram.add(instr);
				}
				catch (LexicalAnalysisException e) {
					throw new LexicalAnalysisException("Error: Fallo al realizar "
							+ "el análisis léxico de la línea " + this.programCounter + "."); 
				}
				catch (ArrayException e) {
					throw new ArrayException("Error:"
							+ "  Se ha sobrepasado el tamaño del programa."); 
				}
							
			}
		}
		
		if(!stop)
			throw new LexicalAnalysisException("Error: No se escribio la etiqueta de cierre end."); 
		
	}
	
	/**
	 * Método que incrementa el contador de programa del analizador léxico.
	 */
	public void increaseProgramCounter(){
		this.programCounter++;
	}
	
}
