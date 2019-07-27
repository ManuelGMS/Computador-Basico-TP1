package main;

/**
 * Lanza la placicación. Crea un objeto del tipo Engine, e invoca a su método start.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Main {
	
	/**
	 * Método que inicia el programa.
	 * @param args argumentos que se envian al programa.
	 */
	public static void main(String args[]) {
		Engine engine = new Engine();
		engine.start();
	}

}
