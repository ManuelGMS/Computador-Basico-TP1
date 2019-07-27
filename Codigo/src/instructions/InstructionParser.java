package instructions;

import cpu.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import instructions.assignments.CompoundAssignment;
import instructions.assignments.SimpleAssignement;
import instructions.conditionals.IfThen;
import instructions.conditionals.While;

/**
 * Clase que trata de parsear las instrucciones.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class InstructionParser {

	private static final Instruction instructions[] = { 
			new CompoundAssignment(),
			new SimpleAssignement(),
			new IfThen(), 
			new Return(), 
			new While(), 
			new Write() 
	};
	
	/**
	 * Método que parsea la instrucción actual llamando a los analizadores léxicos de las instrucciones.
	 * @param instr Se recive la instrucción como una cadena de texto.
	 * @param lexParser Se recive un analizador léxico.
	 * @return Devuelve una instrucción si esta pudo ser parseada. En caso contrario, lanza excepción.
	 * @throws LexicalAnalysisException Se lanza una excepción si no se superó el análisis léxico.
	 * @throws ArrayException Se lanza una excepción si la posición del array no existe.
	 */
	public static Instruction parse(String instr,LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
	
		int i = 0;
		Instruction instruction = null;
		
		while( i < InstructionParser.instructions.length &&  instruction == null ) 
			instruction = InstructionParser.instructions[i++].lexParse(instr.trim().split(" +"), lexParser);
		
		if(instruction!=null)
			return instruction;
		else
			throw new LexicalAnalysisException();
		
	}
	
}
