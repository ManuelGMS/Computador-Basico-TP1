package instructions.conditionals;

import cpu.LexicalParser;

/**
 * Clase que trata de parsear las condiciones.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class ConditionParser {
	private final static Condition[] CONDITIONS = {
			new Equal(), new Less(), new LessEq(),
			new NotEqual()};
	/**
	 * Metodo que parsea la condicion
	 * @param line string con la linea de condicion
	 * @param lexParser clase que se encarga del análisis léxico
	 * @return objeto Condition
	 */
	public static Condition parse(String line, LexicalParser lexParser) {

		line = line.trim();
		String s[] = line.split(" +");
		
		if(s.length!=3)
			return null;
		
		else {
			Condition c = null;
			for (int i = 0; i < ConditionParser.CONDITIONS.length && c == null; i++) {
				c = ConditionParser.CONDITIONS[i].parse(s[0], s[1], s[2], lexParser);
			}

			return c;
		}
	}
}
