package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import ParserC.ParserC;
import ParserC.lexicon.Lexicon;

public class InitialGeneralTest {

	@Test 
	public void BasicInitialGeneral() throws Exception {
		String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("n1\n");
		writeFile.printf("n2\n");
		writeFile.printf("n123\n");
		writeFile.printf("1\n");
		writeFile.printf("123\n");
		writeFile.printf("1.0\n");
		writeFile.printf("11.0\n");
		writeFile.printf(")({},\n");
		writeFile.printf("	;\n");
		writeFile.printf("123abs\n");
		writeFile.printf("1_\n");
		writeFile.printf("$");
		
		file.close();
		
		ParserC c = new ParserC();
		c.runLexychal(path);
		Lexicon lex = c.getLexicon();
		
		
		assertEquals(3, lex.nextToken().getType());
		assertEquals(3, lex.nextToken().getType());
		assertEquals(3, lex.nextToken().getType());

		assertEquals(0, lex.nextToken().getType());
		assertEquals(0, lex.nextToken().getType());

		assertEquals(1, lex.nextToken().getType());
		assertEquals(1, lex.nextToken().getType());

		assertEquals(6, lex.nextToken().getType());
		assertEquals(6, lex.nextToken().getType());
		assertEquals(6, lex.nextToken().getType());
		assertEquals(6, lex.nextToken().getType());
		assertEquals(6, lex.nextToken().getType());
		assertEquals(6, lex.nextToken().getType());

		assertEquals(0, lex.nextToken().getType());

		assertEquals(3, lex.nextToken().getType());

		assertEquals(0, lex.nextToken().getType());

		assertEquals(3, lex.nextToken().getType()); 

		assertEquals(99, lex.nextToken().getType());
		

		File delete = new File(path);
		delete.delete();
	}

	@Test
    public void AssignmentExpression() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("char a = 'a';");
  

        file.close();

        parserC = new ParserC();
        parserC.runLexychal(path);
        lex = parserC.getLexicon();

        assertEquals(7, lex.nextToken().getType());
        assertEquals(3, lex.nextToken().getType());
        assertEquals(8, lex.nextToken().getType());
        assertEquals(2, lex.nextToken().getType());
        assertEquals(6, lex.nextToken().getType());

        File delete = new File(path);
        delete.delete();
    }
}

