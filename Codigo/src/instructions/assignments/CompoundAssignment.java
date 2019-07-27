package instructions.assignments;

import bytecodes.arithmetics.Add;
import bytecodes.arithmetics.Div;
import bytecodes.arithmetics.Mul;
import bytecodes.arithmetics.Sub;
import bytecodes.oneparameter.Store;
import cpu.Compiler;
import cpu.LexicalParser;
import exceptions.ArrayException;
import instructions.Instruction;

/**
 * Representa la asignación var_name = term1 ArithmeticOper term2
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class CompoundAssignment implements Instruction {

	private Term t1 , t2;
	private String varName;
	private String operator;
	
	/**
	 * Constructora sin argumentos
	 */
	public CompoundAssignment() {}
	
	/**
	 * Constructora con argumentos
	 * @param varName nombre de la variable
	 * @param t1 primer termino
	 * @param operator signo de operacion
	 * @param t2 segundo termino
	 */
	public CompoundAssignment(String varName, Term t1, String operator, Term t2){
		this.operator = operator;
		this.varName = varName;
		this.t1 = t1;
		this.t2 = t2;
	}
	
	/**
	 * Método para realizar el análisis léxico.
	 * @param words Recive toda la instrucción mediante un vector de cadenas de texto.
	 * @param lexParser Recive un analizador léxico.
	 * @return Devuelve una instrucción si superó el análisis léxico, null en caso contrario.
	 */
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if(words.length == 5) {
			
			if(words[0].length() == 1) {
				
				if(words[0].charAt(0) >= 'a' && words[0].charAt(0) <= 'z') {
					
					if(words[1].length() == 1 && words[1].charAt(0) == '=') {
						
						if(words[3].length() == 1) {
							
							String operator;
							
							switch(words[3]) {
								case "+": operator = "+"; break;
								case "-": operator = "-"; break;
								case "*": operator = "*"; break;
								case "/": operator = "/"; break;
								default : operator = null;
							}
							
							Term term1 = TermParser.parse(words[2]);
							Term term2 = TermParser.parse(words[4]);
							
							if( term1 != null && term2 != null && operator != null ) {
								
								lexParser.increaseProgramCounter();
								
								return new CompoundAssignment(words[0],term1,words[3],term2);
								
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
		
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		
		switch (this.operator) {
			case "+": compiler.addByteCode(new Add()); break;
			case "-": compiler.addByteCode(new Sub()); break;
			case "*": compiler.addByteCode(new Mul()); break;
			case "/": compiler.addByteCode(new Div()); break;
		}
		
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
		
	}

}