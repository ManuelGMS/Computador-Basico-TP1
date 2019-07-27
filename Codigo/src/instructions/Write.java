package instructions;

import bytecodes.Out;
import bytecodes.oneparameter.Load;
import cpu.Compiler;
import cpu.LexicalParser;
import exceptions.ArrayException;

/**
 * Instrucción Write.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Write implements Instruction {

	private String varName;
	
	/**
	 * Constructora de Write.
	 */
	public Write() {}
	
	/**
	 * Constructora de Write.
	 * @param varName Recive como cadena del texto el nombre de una variable.
	 */
	public Write(String varName){
		this.varName = varName;
	}

	/**
	 * Método que realiza el análisis léxico de la instrucción Write.
	 * @param words Recive la isntrucción completa como un vector de cadenas de texto.
	 * @param lexParser Recive un analizador léxico.
	 * @return Devuelve una nueva isntrucción Write si se supera el análisis léxico, null en caso contrario.
	 */
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if( words.length == 2 && words[0].equalsIgnoreCase("write") ) 
			
			if( words[1].charAt(0) >= 'a' && words[1].charAt(0) <= 'z' ) 
			
				if(words[1].length() == 1) {
					
					lexParser.increaseProgramCounter();
					
					return new Write(words[1]); 
				
				} else  
					
					return null;
		
			else
				
				return null;
						
		else 
			
			return null;

	}

	/**
	 * Método que compila la instrucción Write.
	 * @param compiler Recive un compilador.
	 * @throws ArrayException Se lanza un error si la posición del array no existe.
	 */
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
	
		compiler.addByteCode(new Load(compiler.getIndex(this.varName)));
		compiler.addByteCode(new Out());
		
	}

}