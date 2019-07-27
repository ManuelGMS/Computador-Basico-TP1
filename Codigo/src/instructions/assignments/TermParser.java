package instructions.assignments;

/**
 * Clase que trata de parsear los terminos.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class TermParser {

	private final static Term Terms[] = { 
			new Number(), 
			new Variable() 
	};
	
	/**
	 * Metodo que parsea el termino
	 * @param term string con el termino que parsear
	 * @return un objeto Term
	 */
	public static Term parse(String term){
		
		int i = 0;
		Term t = null;
		
		while( i < TermParser.Terms.length && t == null )
			t = TermParser.Terms[i++].parse(term);
		
		return t;
		
	}
	
}
