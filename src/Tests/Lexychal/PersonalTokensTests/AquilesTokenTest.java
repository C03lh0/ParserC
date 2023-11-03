package Tests.Lexychal.PersonalTokensTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;

import CompiladorL3.CompiladorL3;
import CompiladorL3.Lexico;

//Reports to @aquilesRod

public class AquilesTokenTest {

	@Test
	public void aquilesTokenTest1() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("#123##2##32#\n");
		writeFile.printf("#432100#\n");

		file.close();
		
		try {
			CompiladorL3 c = new CompiladorL3();
			c.runLexychal(path);
			Lexico lex = c.getLexico();
			
			assertEquals(88, lex.nextToken().getTipo());
			assertEquals(88, lex.nextToken().getTipo());
		} catch (Exception e) {
			Assert.fail();
		}
		
		File delete = new File(path);
		delete.delete();
	}
	
	@Test
	public void aquilesTokenTest2() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("##10\n");
		writeFile.printf("#a# ");
		writeFile.printf("#@#\t");

		file.close();
		
		try {
			CompiladorL3 c = new CompiladorL3();
			c.runLexychal(path);
			Lexico lex = c.getLexico();
			
			assertEquals(88, lex.nextToken().getTipo());
			assertEquals(88, lex.nextToken().getTipo());
			assertEquals(88, lex.nextToken().getTipo());
			Assert.fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		
		File delete = new File(path);
		delete.delete();
	}

	@Test
	public void aquilesTokenWithOtherTypesTest() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);
		
		writeFile.printf("#144#>");
		writeFile.printf("#2# 2.0");
		writeFile.printf("abc = #100000#");

		file.close();
		
		try {
			CompiladorL3 c = new CompiladorL3();
			c.runLexychal(path);
			Lexico lex = c.getLexico();
			
			assertEquals(88, lex.nextToken().getTipo());
			assertEquals(4, lex.nextToken().getTipo());
			
			assertEquals(88, lex.nextToken().getTipo());
			assertEquals(1, lex.nextToken().getTipo());
			
			assertEquals(3, lex.nextToken().getTipo());
			assertEquals(8, lex.nextToken().getTipo());
			assertEquals(88, lex.nextToken().getTipo());
		} catch (Exception e) {
			Assert.fail();
		}
		
		File delete = new File(path);
		delete.delete();
	}

}

