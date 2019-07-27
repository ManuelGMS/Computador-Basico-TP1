package instructions.conditionals;

import bytecodes.oneparameter.GoTo;
import cpu.Compiler;
import cpu.LexicalParser;
import cpu.ParsedProgram;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import instructions.Instruction;

/**
 * Clase que representa la instruccion While
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class While implements Instruction {

	private Condition condition;
	private ParsedProgram whileBody;
	
	/**
	 * Constructora sin argumentos
	 */
	public While(){
		super();
	}
	
	/**
	 * Constructora con argumentos
	 * @param condition condicion del while
	 * @param whileBody cuerpo del while
	 */
	public While(Condition condition, ParsedProgram whileBody){
		this.condition = condition;
		this.whileBody = whileBody;
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
		if (words.length != 4 || !words[0].equalsIgnoreCase("while"))
			return null;
		else {
			Condition condition = ConditionParser.parse(words[1]+" "+words[2]+" "+words[3], lexParser);
			lexParser.increaseProgramCounter();
			if(condition==null)
				return null;
			else {
				ParsedProgram wBody = new ParsedProgram();
				lexParser.lexicalParser(wBody, "ENDWHILE");
				lexParser.increaseProgramCounter();
				return new While(condition,wBody);
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
		int comeback = compiler.getProgramCounter();
		this.condition.compile(compiler);
		compiler.compile(this.whileBody);
		compiler.addByteCode(new GoTo(comeback));
		int jump = compiler.getProgramCounter();
		this.condition.setJump(jump);
		
	}

}
