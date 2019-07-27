package cpu;
import java.util.Random;

/**
 * Representa la memoria de la maquina.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class Memory {
	private Integer[] memory; 	
	private final static int MAX_MEM = 200;
	private boolean empty;
	private int size;

	/**
	 * Constructor de la clase Memory
	 */
	public Memory() {
		this.empty = true;
		this.memory = new Integer[Memory.MAX_MEM];
		this.size = Memory.MAX_MEM;

		for (int i = 0; i < this.size; i++)
			this.memory[i] = null;
	}

	/**
	 * Borra todos los elementos de la memoria
	 */
	public void reset() {
		this.empty = true;
		for (int i = 0; i < this.size; i++)
			this.memory[i] = null;
	}

	/**
	 * Escribe en la memoria
	 * 
	 * @param pos posicion a escribir en la memoria
	 * @param value valor a escribir
	 * @return si la posicion es menor que cero devuelve false si no devuelve true
	 */
	public boolean write(int pos, int value) {
		if (pos < 0)
			return false;
		else {
			this.empty = false;
			if (pos >= this.memory.length)
				resize(pos);
	
			this.memory[pos] = value;
			return true;
		}
	}

	/**
	 * Lee de la memoria
	 * 
	 * @param pos posicion a leer
	 * @return devuelve el valor que hay en memoria. Si no existe el elemento en memoria devuelve un numero aleatorio.
	 */
	public int read(int pos) {
		if (pos>=0 && pos < this.memory.length && this.memory[pos] != null)
			return this.memory[pos];
		else
			return new Random().nextInt();
	}

	/**
	 * Redimensiona la memoria a el numero multiplicado por dos que se pasa como parametro.
	 * @param pos posición de la memoria
	 */
	private void resize(int pos) {
		Integer newMemory[] = new Integer[pos * 2];
		for (int i = 0; i < this.size; i++) {
			newMemory[i] = this.memory[i];
		}
		
		for (int i = this.size; i < pos * 2; i++)
			newMemory[i] = null;

		this.memory = newMemory;
		this.size = pos * 2;

	}

	/**
	 * Devuelve un string con los valores de la memoria si no esxite ninguno se escribira vacia
	 * @return un string que describe el objeto
	 */
	public String toString() {
		if (this.empty)
			return "<vacia>";
		else  {
			String s = "";
			for (int i = 0; i < this.size; i++) {
				if (this.memory[i] != null)
					s += "[" + i + "]:" + this.memory[i] + " ";
			}
			return s;
		}
	}

}