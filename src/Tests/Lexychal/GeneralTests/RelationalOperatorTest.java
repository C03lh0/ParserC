package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import ParserC.ParserC;
import ParserC.lexicon.Lexicon;


public class RelationalOperatorTest {
    @Test
    public void OnlyRelationalOperators() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("<\n");
		writeFile.printf(">\n");
		writeFile.printf(">=\n");
		writeFile.printf("<=\n");
		writeFile.printf("==\n");
		writeFile.printf("!=");
        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }

	@Test
    public void OtherTokensWithRelationalOperators() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("1.21\n");
		writeFile.printf("identifier\n");
		writeFile.printf(">=\n");
		writeFile.printf("<=\n");
		writeFile.printf("==\n");
		writeFile.printf("!=");
        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(1, lex.nextToken().getType());
		assertEquals(3, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
	@Test
    public void LastTokenHasSpace() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("1.21\n");
		writeFile.printf("identifier\n");
		writeFile.printf(">=\n");
		writeFile.printf("<=\n");
		writeFile.printf("==\n");
		writeFile.printf("!=\n");
        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(1, lex.nextToken().getType());

		assertEquals(3, lex.nextToken().getType());
		
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());
		assertEquals(4, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
}

