package Tests.Lexychal.GeneralTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.Test;

import CompiladorL3.OlimpoCompiler;
import CompiladorL3.Lexical;

public class JustAnInputCharTest {
	
    @Test
    public void JustAnIntegerChar() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("1");

        
        file.close();

        compiler = new OlimpoCompiler();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(0, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustAnArithmeticOperatorChar() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("+");

        
        file.close();

        compiler = new OlimpoCompiler();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(5, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustAnIdentifierOperatorChar() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("a");

        
        file.close();

        compiler = new OlimpoCompiler();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(3, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustASpecialCharacterChar() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("{");

        
        file.close();

        compiler = new OlimpoCompiler();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(6, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
    @Test
    public void JustARelationalOperatorChar() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("<");

        
        file.close();

        compiler = new OlimpoCompiler();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(4, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }

    @Test
    public void JustAAssignmentOperatorChar() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
		FileWriter file = new FileWriter(path);
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("=");

        
        file.close();

        compiler = new OlimpoCompiler();
		compiler.runLexychal(path);
		lex = compiler.getLexico();

        assertEquals(8, lex.nextToken().getType());

        File delete = new File(path);
		delete.delete();		
    }
}

