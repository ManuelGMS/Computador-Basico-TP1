package instructions.conditionals;

import bytecodes.oneparameter.conditionaljumps.ConditionalJumps;
import cpu.Compiler;
import cpu.LexicalParser;
import exceptions.ArrayException;
import instructions.assignments.Term;
import instructions.assignments.TermParser;

/**
 * Clase que representa la condicion
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public abstract class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition;
	
	/**
	 * Constructora sin argumentos
	 */
	public Condition() {
		super();
	}
	
	/**
	 * Constructora con argumentos
	 * @param t1 primer termino
	 * @param t2 segundo termino
	 */
	public Condition(Term t1, Term t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	/**
	 * Parsea un string a un objeto Condition
	 * @param t1 primer termino
	 * @param op operando
	 * @param t2 segundo termino
	 * @param lexParser clase que se encarga del análisis léxico
	 * @return un objeto Condition
	 */
	public Condition parse(String t1, String op, String t2,
			LexicalParser lexParser) {
		Term term1 = TermParser.parse(t1);
		Term term2 = TermParser.parse(t2);
		if(term1==null||term2==null)
			return null;
		else
			return parse(term1, op, term2);
	}
	
	/**
	 * Traduce un objeto Condition a bytecode
	 * @param compiler clase que se encarga de la compilacion
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		this.condition = compileAux();
		compiler.addByteCode(this.condition);
	}
	
	/**
	 * Cambia la direccion de salto de condition
	 * @param j direccion de salto
	 */
	public void setJump(int j) {
		this.condition.setJump(j);
	}
	
	/**
	 * Ayuda a parsear a un Condition
	 * @param t1 primer termino
	 * @param op operando
	 * @param t2 segundo termino
	 * @return un objeto Condition
	 */
	abstract protected Condition parse(Term t1, String op, Term t2);
	
	/**
	 * Ayuda a compilar la condicion
	 * @return un objeto ConditionalJumps
	 */
	abstract protected ConditionalJumps compileAux();
}
