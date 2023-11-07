package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import ParserC.ParserC;
import ParserC.lexicon.Lexicon;

public class ReservedWorldTest {
		//[REPORT TO @C03lh0]
	
		//[POSITIVE CASES]
	 	@Test
	    public void ReservedWordsWithSpace () throws Exception {
	        Lexicon lex;
	        ParserC parserC;
	        String path = "codigoCompilador.txt";
			FileWriter file = new FileWriter(path);
			PrintWriter writeFile = new PrintWriter(file);

			writeFile.printf("while\n");
			writeFile.printf("if\n");
			writeFile.printf("else\n");
			writeFile.printf("do\n");
			writeFile.printf("main\n");
			writeFile.printf("char\n");
			writeFile.printf("float\n");
			writeFile.printf("int\n");
			writeFile.printf("for\n");
	        
	        file.close();

	        parserC = new ParserC();
			parserC.runLexychal(path);
			lex = parserC.getLexicon();

	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        
	      
	        File delete = new File(path);
			delete.delete();		
	    }
	 	
	 	@Test
	    public void ReservedWordsWithAndWithoutSpace() throws Exception {
	        Lexicon lex;
	        ParserC parserC;
	        String path = "codigoCompilador.txt";
			FileWriter file = new FileWriter(path);
			PrintWriter writeFile = new PrintWriter(file);

			writeFile.printf("while\n");
			writeFile.printf("if\n");
			writeFile.printf("else");
			writeFile.printf("do\n");
			writeFile.printf("main\n");
			writeFile.printf("char\n");
			writeFile.printf("float");
			writeFile.printf("int\n");
			writeFile.printf("for");
	        
	        file.close();

	        parserC = new ParserC();
			parserC.runLexychal(path);
			lex = parserC.getLexicon();

	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	      
	        File delete = new File(path);
			delete.delete();		
	    }
	 	
	 	@Test
	    public void OtherTokensWhithReservedWord() throws Exception {
	        Lexicon lex;
	        ParserC parserC;
	        String path = "codigoCompilador.txt";
			FileWriter file = new FileWriter(path);
			PrintWriter writeFile = new PrintWriter(file);

			writeFile.printf("n122\n");
			writeFile.printf("if\n");
			writeFile.printf("else\n");
			writeFile.printf("mc232\n");
			writeFile.printf("mc222\n");
			writeFile.printf("the55\n");
			writeFile.printf("float\n");
			writeFile.printf("int\n");
			writeFile.printf("for\n");
	        
	        file.close();

	        parserC = new ParserC();
			parserC.runLexychal(path);
			lex = parserC.getLexicon();

	        assertEquals(3, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(3, lex.nextToken().getType());
	        assertEquals(3, lex.nextToken().getType());
	        assertEquals(3, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	        assertEquals(7, lex.nextToken().getType());
	      
	        File delete = new File(path);
			delete.delete();		
	    }
}

