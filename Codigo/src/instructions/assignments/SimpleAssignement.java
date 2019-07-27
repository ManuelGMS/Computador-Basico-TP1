package instructions.assignments;

import bytecodes.oneparameter.Store;
import cpu.Compiler;
import cpu.LexicalParser;
import exceptions.ArrayException;
import instructions.Instruction;

/**
 * Esta clase almacena asignaciones simples de la formaVariable = Term
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class SimpleAssignement implements Instruction {

	private Term rhs;
	private String varName;
	
	/**
	 * Constructora sin argumentos
	 */
	public SimpleAssignement() {}
	
	/**
	 * Constructora con argumentos
	 * @param varName es el nombre de la variable del lado izquierdo de la asignación
	 * @param rhs es el término que aparece en el lado derecho
	 */
	public SimpleAssignement(String varName, Term rhs) {
		this.varName = varName;
		this.rhs = rhs;
	}
	
	/**
	 * Método para realizar el análisis léxico.
	 * @param words Recive toda la instrucción mediante un vector de cadenas de texto.
	 * @param lexParser Recive un analizador léxico.
	 * @return Devuelve una instrucción si superó el análisis léxico, null en caso contrario.
	 */
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if(words.length == 3) {
			
			if(words[0].length() == 1) {
			
				if(words[0].charAt(0) >= 'a' && words[0].charAt(0) <= 'z') {
					
					if(words[1].length() == 1 && words[1].charAt(0) == '=') {
						
						Term term = TermParser.parse(words[2]);
						
						if(term != null) {
					
							lexParser.increaseProgramCounter();
							
							return new SimpleAssignement(words[0],term);
						
						} else {			
							return null;
						}
							
					} else {
						return null;
					}
					
				} else {
					return null;
				}
				
			} else {
				return null;
			}
			
		} else {
			return null;
		}

	}

	/**
	 * Método para realizar la compilación.
	 * @param compiler Recive un Compilador.
	 * @throws ArrayException Se lanza una excepción si la posición del vector no existe.
	 */
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.rhs.compile(compiler));
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
	}

}