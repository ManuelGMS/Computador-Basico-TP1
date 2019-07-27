package instructions.conditionals;

import cpu.Compiler;
import cpu.LexicalParser;
import cpu.ParsedProgram;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import instructions.Instruction;

/**
 * Clase que representa la instruccion if
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class IfThen implements Instruction {

	private Condition condition;
	private ParsedProgram ifBody;
	
	/**
	 * Constructora sin argumentos
	 */
	public IfThen(){
		super();
	}
	
	/**
	 * Constructora con argumentos
	 * @param condition condicion del if
	 * @param whileBody cuerpo del if
	 */
	public IfThen(Condition condition, ParsedProgram whileBody){
		this.condition = condition;
		this.ifBody = whileBody;
	}

	/**
	 * Método para el análisis léxico.
	 * @param words Recive la instrucción completa mediante un vector de cadenas de texto.
	 * @param lexParser Recive un analizador léxico.
	 * @return Devuelve una instrucción si esta superó el análisis léxico, null en caso contrario.
	 * @throws LexicalAnalysisException Se lanzauna excepción si se produjo un error en el análisis léxico.
	 * @throws ArrayException Se lanza una exepción si la posición del vector no existe.
	 */
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
		if (words.length != 4 || !words[0].equalsIgnoreCase("if"))
			return null;
		else {
			Condition condition = ConditionParser.parse(words[1]+" "+words[2]+" "+words[3], lexParser);
			lexParser.increaseProgramCounter();
			if(condition==null)
				return null;
			else {
				ParsedProgram ifBody = new ParsedProgram();
				lexParser.lexicalParser(ifBody, "ENDIF");
				lexParser.increaseProgramCounter();
				return new IfThen(condition,ifBody);
			}
		}
	}

	/**
	 * Método para realizar la compilación.
	 * @param compiler Recive un Compilador.
	 * @throws ArrayException Se lanza una exepción si la posición del vector no existe.
	 */
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		this.condition.setJump(compiler.getProgramCounter());
		
	}

}
