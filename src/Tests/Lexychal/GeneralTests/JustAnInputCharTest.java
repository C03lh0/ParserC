package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import ParserC.ParserC;
import ParserC.lexicon.Lexicon;

public class JustAnInputCharTest {
	
    @Test
    public void JustAnIntegerChar() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("1");

        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(0, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustAnArithmeticOperatorChar() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("+");

        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(5, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustAnIdentifierOperatorChar() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("a");

        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(3, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustASpecialCharacterChar() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("{");

        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(6, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustARelationalOperatorChar() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("<");

        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(4, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }

    @Test
    public void JustAAssignmentOperatorChar() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("=");

        
        file.close();

        parserC = new ParserC();
		parserC.runLexychal(path);
		lex = parserC.getLexicon();

        assertEquals(8, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
}

