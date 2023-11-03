package Tests.Lexychal.PersonalTokensTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import CompiladorL3.CompiladorL3;
import CompiladorL3.Lexico;

public class MatheusTokenTest {
	    //[REPORT TO @C03lh0]
	
		//[POSITIVE CASES]
	
		@Test 
	    public void TokenMatheusNoSpaceEndToken() throws Exception {
	        Lexico lex;
	        CompiladorL3 compiler;
	        String path = "codigoCompilador.txt";
			FileWriter file = new FileWriter(path);
			PrintWriter writeFile = new PrintWriter(file);

			writeFile.printf("+++\n");
			writeFile.printf("++\n");
			writeFile.printf("---");
			
	        
	        file.close();

	        compiler = new CompiladorL3();
			compiler.runLexychal(path);
			lex = compiler.getLexico();

	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	       

	        File delete = new File(path);
			delete.delete();
	    }
	 	
		@Test
	 	public void TokenMatheusSpaceEndToken() throws Exception {
		        Lexico lex;
		        CompiladorL3 compiler;
		        String path = "codigoCompilador.txt";
				FileWriter file = new FileWriter(path);
				PrintWriter writeFile = new PrintWriter(file);

				writeFile.printf("+++\n");
				writeFile.printf("---\n");
				writeFile.printf("--\n");
		        
		        file.close();

		        compiler = new CompiladorL3();
				compiler.runLexychal(path);
				lex = compiler.getLexico();

		        assertEquals(5, lex.nextToken().getTipo());
		        assertEquals(5, lex.nextToken().getTipo());
		        assertEquals(5, lex.nextToken().getTipo());

		        File delete = new File(path);
				delete.delete();
		 }
	 	 
		@Test
	 	public void TokenMatheusWhithOtherTokens() throws Exception {
	        Lexico lex;
	        CompiladorL3 compiler;
	        String path = "codigoCompilador.txt";
			FileWriter file = new FileWriter(path);
			PrintWriter writeFile = new PrintWriter(file);

			writeFile.printf("+++\n");
			writeFile.printf("++\n");
			writeFile.printf("+\n");
			writeFile.printf("-\n");
			writeFile.printf("--\n");
			writeFile.printf("---\n");
			writeFile.printf("while\n");
			writeFile.printf("123\n");
			writeFile.printf("vb15\n");
			writeFile.printf(";\n");
	        
	        file.close();

	        compiler = new CompiladorL3();
			compiler.runLexychal(path);
			lex = compiler.getLexico();

	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(5, lex.nextToken().getTipo());
	        assertEquals(7, lex.nextToken().getTipo());
	        assertEquals(0, lex.nextToken().getTipo());
	        assertEquals(3, lex.nextToken().getTipo());
	        assertEquals(6, lex.nextToken().getTipo());

	        File delete = new File(path);
			delete.delete();
	    }
		
		//[NEGATIVE CASES]
		@Test (expected = RuntimeException.class)
	 	 public void TokenMatheusInvalid() throws Exception {
		        Lexico lex;
		        CompiladorL3 compiler;
		        String path = "codigoCompilador.txt";
				FileWriter file = new FileWriter(path);
				PrintWriter writeFile = new PrintWriter(file);

				writeFile.printf("++++\n");
		        
		        file.close();

		        compiler = new CompiladorL3();
				compiler.runLexychal(path);
				lex = compiler.getLexico();

		        assertEquals(5, lex.nextToken().getTipo());

		        File delete = new File(path);
				delete.delete();
		  }
		
		@Test (expected = RuntimeException.class)
	 	 public void TokenMatheusChanged() throws Exception {
		        Lexico lex;
		        CompiladorL3 compiler;
		        String path = "codigoCompilador.txt";
				FileWriter file = new FileWriter(path);
				PrintWriter writeFile = new PrintWriter(file);

				writeFile.printf("+-+\n");
		        
		        file.close();

		        compiler = new CompiladorL3();
				compiler.runLexychal(path);
				lex = compiler.getLexico();

		        assertEquals(5, lex.nextToken().getTipo());

		        File delete = new File(path);
				delete.delete();
		  }
}

