package cpu;

import exceptions.ExecutionError;
import exceptions.StackException;

/**
 * Clase de la pila de operandos.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class OperandStack {
	
	private int stack[];
	private int numElems;
	private static int MAX_STACK = 100;

	/**
	 * Constructor de OperandStack.
	 */
	public OperandStack() {
		this.numElems = 0;
		this.stack = new int[OperandStack.MAX_STACK];
	}

	/**
	 * Devolvemos el valor el numero de elementos que hay en la pila.
	 * @return devuelve el número de elementos
	 */
	public int getNumElems() {
		return this.numElems;
	}

	/**
	 * Coloca el valor que se pasa por parametro en la cima de la pila
	 * @param newValue nuevo valor para la cima de la pila
	 * @throws StackException error de ejecución al superar el tamaño permitido para la pila
	 */
	public void push(int newValue) throws StackException {
		if(this.numElems>=OperandStack.MAX_STACK)
			throw new StackException("OperandStack llena");
		else {
			this.stack[this.numElems] = newValue;
			this.numElems++;
		}
	}

	/**
	 * Devuelve el valor de la cima
	 * @return el valor de la cima, si la pila es vacia devuelve un numero aleatorio
	 * @throws StackException error de ejecución al superar el tamaño permitido para la pila
	 */
	public int pop() throws StackException {
		int top;
		if (isEmpty()) {
			throw new StackException ("Tamaño de pila insuficiente");
		}
		else {
			top = this.stack[this.numElems - 1];
			this.numElems--;
		}

		return top;
	}

	/**
	 * Comprueba si la pila está o no vacia.
	 * @return true si esta vacia y false si no lo esta
	 */
	public boolean isEmpty() {
		return this.numElems == 0;
	}

	/**
	 * Desecha todos los elementos de la pila
	 */
	public void reset() {
		this.numElems = 0;
	}

	/**
	 * Devuelve un string con los valores de la pila si no esxite ninguno se escribira vacia
	 * @return un string que describe el objeto
	 */
	public String toString() {
		if (isEmpty())
			return "<vacia>";
		else {
			String s = "";
	
			for (int i = 0; i < this.numElems; i++) {
				s += this.stack[i] + " ";
			}
	
			return s;
		}
		
	}

}
