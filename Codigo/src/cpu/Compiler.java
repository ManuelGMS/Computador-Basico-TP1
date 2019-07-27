package cpu;

import bytecodes.ByteCode;
import exceptions.ArrayException;
import instructions.Instruction;
import main.ByteCodeProgram;

/**
 * Compilador.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Compiler {
	
	private int numVars;
	private String[] varTable;
	private ByteCodeProgram bcProgram;
	
	/**
	 * Constructora del compilador.
	 * @param byteCodeProgram Recive un programa de byteCodes.
	 */
	public Compiler(ByteCodeProgram byteCodeProgram) {
		this.numVars = 0;
		this.varTable = new String[26];
		this.bcProgram = byteCodeProgram;
	}
	
	/**
	 * Método para realizar la compilación.
	 * @param pProgram Recive un parsedProgram.
	 * @throws ArrayException Se lanza una excepción si la posición del vector no existe.
	 */
	public void compile(ParsedProgram pProgram) throws ArrayException {
		
		try {
			for( int i = 0 ; i < pProgram.getNumInstr() ; i++ ) {
				Instruction inst = pProgram.getInstruction(i);
				inst.compile(this);
				
			}
		}
		catch (ArrayException e) {
			throw new ArrayException("Error:  "
					+ e.getMessage()); 
		}
		
		
		
	}
	
	/**
	 * Método para añadir un nuevo byteCode.
	 * @param bc Recive un byteCode para añadirlo.
	 * @throws ArrayException Se lanzará una excepción si la posición del vector no existe.
	 */
	public void addByteCode(ByteCode bc) throws ArrayException {
		this.bcProgram.add(bc);
	}
	
	/**
	 * Método para obtener el índice de una variable almacenada en la tabla de variables.
	 * @param varName Nombre de la variable.
	 * @return Se devuelve el índice de la variable.
	 * @throws ArrayException Se lanza una excepción si la posición del vector no existe.
	 */
	public int getIndex(String varName) throws ArrayException {
    
		try {
			
			int i = 0;
	        boolean stop = false;
	        
	        while(i<this.numVars && !stop) {
	            
	        	if(this.varTable[i].equalsIgnoreCase(varName)) {
	            	stop = true;
	            } else { 
	            	i++;
	            }
	        	
	       }
	       
	        if( stop ) {
	        	return i;
	        } else {
	        	this.varTable[this.numVars] = varName;
	            this.numVars++;
	            return (this.numVars - 1);
	        }
	        
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayException("Error, la tabla de variables está llena.");
		}
       
	}
	
	/**
	 * Método para obtener el contador de programa.
	 * @return Devuelve el valor del contado de programa.
	 */
	public int getProgramCounter() {
		return this.bcProgram.getNumInstr();
	}
		
}
