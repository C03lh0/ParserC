package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import CompiladorL3.CompiladorL3;
import CompiladorL3.Lexico;


public class RelationalOperatorTest {
    @Test
    public void OnlyRelationalOperators() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
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

        compiler = new CompiladorL3();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());

        File delete = new File(path);
		delete.delete();		
    }

	@Test
    public void OtherTokensWithRelationalOperators() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
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

        compiler = new CompiladorL3();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(1, lex.nextToken().getTipo());
		assertEquals(3, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());

        File delete = new File(path);
		delete.delete();		
    }
	@Test
    public void LastTokenHasSpace() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
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

        compiler = new CompiladorL3();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(1, lex.nextToken().getTipo());

		assertEquals(3, lex.nextToken().getTipo());
		
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());
		assertEquals(4, lex.nextToken().getTipo());

        File delete = new File(path);
		delete.delete();		
    }
}
