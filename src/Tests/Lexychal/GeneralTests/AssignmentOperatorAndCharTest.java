package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;

import CompiladorL3.OlimpoCompiler;
import CompiladorL3.Lexical;

public class AssignmentOperatorAndCharTest {

	@Test
	public void charTest() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("'a'\n");
		writeFile.printf("'1'\n");

		file.close();
		
		try {
			OlimpoCompiler c = new OlimpoCompiler();
			c.runLexychal(path);
			Lexical lex = c.getLexicalAnalyzer();
			
			assertEquals(2, lex.nextToken().getType());
			assertEquals(2, lex.nextToken().getType());
		} catch (Exception e) {
			Assert.fail();
		}
		
		File delete = new File(path);
		delete.delete();
	}
	
	@Test
	public void charTestError() throws Exception{
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("a''\n");
		writeFile.printf("''a\n");
		writeFile.printf("'@'\n");
		

		file.close();
		
		try {
			OlimpoCompiler c = new OlimpoCompiler();
			c.runLexychal(path);
			Lexical lex = c.getLexicalAnalyzer();
			
			assertEquals(2, lex.nextToken().getType());
			assertEquals(2, lex.nextToken().getType());
			assertEquals(2, lex.nextToken().getType());
			Assert.fail();
		} catch (Exception e){
			assertTrue(true);
		}
		
		File delete = new File(path);
		delete.delete();
	}
	
	@Test
	public void AssignmentTest() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("== ");
		writeFile.printf("=\n");
		writeFile.printf("= ");
		writeFile.printf("==");

		file.close();
		
		try {
			OlimpoCompiler c = new OlimpoCompiler();
			c.runLexychal(path);
			Lexical lex = c.getLexicalAnalyzer();
			
			assertEquals(4, lex.nextToken().getType());
			assertEquals(8, lex.nextToken().getType());
			assertEquals(8, lex.nextToken().getType());
			assertEquals(4, lex.nextToken().getType());
		} catch (Exception e) {
			Assert.fail();
		}
		
		File delete = new File(path);
		delete.delete();
	}

	
	@Test
	public void AssignmentAndCharWithOthersTypesTest() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("a=3\n");
		writeFile.printf("a= 'a'\n");
		writeFile.printf("= 2.0\t");
		writeFile.printf("if ='a'");

		file.close();
		
		try {
			OlimpoCompiler c = new OlimpoCompiler();
			c.runLexychal(path);
			Lexical lex = c.getLexicalAnalyzer();
			
			assertEquals(3, lex.nextToken().getType());
			assertEquals(8, lex.nextToken().getType());
			assertEquals(0, lex.nextToken().getType());
			
			assertEquals(3, lex.nextToken().getType());
			assertEquals(8, lex.nextToken().getType());
			assertEquals(2, lex.nextToken().getType());
			
			assertEquals(8, lex.nextToken().getType());
			assertEquals(1, lex.nextToken().getType());
			
			assertEquals(7, lex.nextToken().getType());
			assertEquals(8, lex.nextToken().getType());
			assertEquals(2, lex.nextToken().getType());
		} catch (Exception e) {
			Assert.fail();
		}
		
		File delete = new File(path);
		delete.delete();
	}


}
