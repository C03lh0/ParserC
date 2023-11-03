package Tests.Lexychal.PersonalTokensTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import CompiladorL3.CompiladorL3;
import CompiladorL3.Lexico;

//Reports to @CristoferSilva

public class CristoferSTokenTest {
    
    @Test
    public void OnlyCristoferArithmeticOperator() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("*/\n");
		writeFile.printf("**");
        
        file.close();

        compiler = new CompiladorL3();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());

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

		writeFile.printf("*/\n");
		writeFile.printf("**\n");
        
        file.close();

        compiler = new CompiladorL3();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());

        File delete = new File(path);
		delete.delete();
    }
}

