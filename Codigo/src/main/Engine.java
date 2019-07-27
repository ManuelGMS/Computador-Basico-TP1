package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bytecodes.ByteCode;
import bytecodes.ByteCodeParser;
import commands.Command;
import commands.CommandParser;
import cpu.CPU;
import cpu.Compiler;
import cpu.LexicalParser;
import cpu.ParsedProgram;
import exceptions.ArrayException;
import exceptions.BadFormatByteCode;
import exceptions.ExecutionError;
import exceptions.LexicalAnalysisException;

/**
 * Representa el bucle de control de la aplicación.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 11/01/2017
 */
public class Engine {

	private CPU cpu;
	private boolean end;
	private SourceProgram sProgram;
	private ParsedProgram parsedProgram;
	private ByteCodeProgram bytecodeProgram;
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructora de Engine.
	 */
	public Engine() {
		this.end = false;		
		this.sProgram = new SourceProgram();
		this.parsedProgram = new ParsedProgram();
		this.bytecodeProgram = new ByteCodeProgram();
		this.cpu = new CPU(this.bytecodeProgram);
	}

	/**
	 * Se encarga de leer sucesivamente los comandos introducidos por el usuario, hasta recibir el comando QUIT.
	 */
	public void start() {

		String line = null;
		Command command = null;

		while (!this.end) {
			
			System.out.print("> ");
			line = sc.nextLine();
			try {
			command = CommandParser.parse(line);
			
			if (command != null) {
				
				System.out.println("Comienza la ejecución de " + command.toString());
					command.execute(this);
					System.out.println(this.sProgram.toString());
					System.out.println(this.bytecodeProgram.toString());
				
			} else {
				System.out.println("Error: Comando incorrecto.");
			}
			
			} catch (ExecutionError | LexicalAnalysisException | ArrayException | BadFormatByteCode e) {
				System.out.println(e.getMessage());
			}
		}

		sc.close();
		
		System.out.println("Fin de la ejecución....");
	}
	
	/**
	 * Establece que la máquina virtual va a pararse.
	 */
	public void executeQuit() {
		this.end = true;
	}
	
	/**
	 * Realiza la sustitución de una instrucción existente por una nueva isntrucción.
	 * @param programLine Recive como parámetro el número de línea de la instrucción a reemplazar.
	 * @throws ArrayException posiciones incorrectas de un array
	 */
	public void executeReplace(int programLine) throws ArrayException{
		
			if(programLine<0||programLine>=this.bytecodeProgram.getNumInstr())
				throw new ArrayException("La linea introducida no existe");
			
			System.out.print("Nueva instrucción: ");
			String line = sc.nextLine();
			System.out.println();
			ByteCode instruction;
			try {
				instruction = ByteCodeParser.parse(line);
				this.bytecodeProgram.replace(instruction, programLine);
			} catch (BadFormatByteCode | ArrayException e) {
				System.out.println(e.getMessage());
			}
			
	}
	
	/**
	 * Ordena a la CPU que debe ejecutarse el comando RUN.
	 */
	public void executeRun() {
		try {
			if( this.bytecodeProgram.getNumInstr() > 0 ) 
				this.cpu.run();
			else
				System.out.println("No hay ningún programa cargado.");
		}
		catch (ExecutionError | ArrayException e) {
			System.out.println(e.getMessage());
			this.sProgram.reset();
			this.parsedProgram.reset();
			this.bytecodeProgram.reset();
		}
	}
	
	/**
	 * Método que se ocupa de cargar el fichero que contiene el programa de alto nivel.
	 * @param path Recive la ruta al fichero fuente.
	 * @throws ExecutionError Se lanza una excepción si el fichero no pudo ser encontrado.
	 */
	public void executeLoad(String path) throws ExecutionError {
		
		try {	
		
			Scanner reader = null;
			File file = new File(path);
			
			this.sProgram.reset();
			this.parsedProgram.reset();
			this.bytecodeProgram.reset();
			
			reader = new Scanner(file);
			
			try {
				while( reader.hasNextLine() )
					this.sProgram.add(reader.nextLine());
			} catch (ArrayException e) {
					this.sProgram.reset();
					throw new ExecutionError(e.getMessage());
			} finally {
				reader.close();
			}
			
		} catch (FileNotFoundException e) {
			throw new ExecutionError("Excepcion: Fichero no encontrado...");
		}
		
	}
	
	/**
	 * Método que lannza el proceso de compilación del programa de alto nivel.
	 * @throws LexicalAnalysisException Error generado si una instrucción no supera el análisis léxico.
	 * @throws ArrayException Se genera un error si se intenta acceder a una posición inexistente.
	 */
	public void executeCompile() throws LexicalAnalysisException, ArrayException {
		
		try {
			this.lexicalAnalysis();
			this.generateByteCode();
		} catch (LexicalAnalysisException | ArrayException e) {
			this.parsedProgram.reset();
			this.bytecodeProgram.reset();
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Método que lanza el proceso de análisis sintáctico del programa, genera un parsedProgram.
	 * @throws LexicalAnalysisException Error generado si una instrucción no supera el análisis léxico.
	 * @throws ArrayException Se genera un error si se intenta acceder a una posición inexistente.
	 */
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException  {
		this.parsedProgram.reset();
		LexicalParser lexicalParser = new LexicalParser(this.sProgram);
		lexicalParser.lexicalParser(this.parsedProgram,"end");
	}
	
	/**
	 * Método que lanza el proceso de generación del programa, genera un bytecodeProgram.
	 * @throws ArrayException Se genera un error si se intenta acceder a una posición inexistente.
	 */
	private void generateByteCode() throws ArrayException {
		this.bytecodeProgram.reset();
		Compiler compiler = new Compiler(this.bytecodeProgram);
		compiler.compile(this.parsedProgram);
	}

}