package Tests.Lexychal.PersonalTokensTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.junit.Test;

import CompiladorL3.CompiladorL3;
import CompiladorL3.Lexico;

//Reports to @BrunoMartinns

public class BrunoTokenTest {
    
    @Test
    public void brunoTokenTest() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        Writer file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("&:\n");
        writeFile.printf("-\n");
        writeFile.printf("*\n");
        writeFile.printf("/\n");

        file.close();

        compiler = new CompiladorL3();
        compiler.runLexychal(path);
        lex = compiler.getLexico();

        assertEquals(77, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());

        File delete = new File(path);
        delete.delete();

    }

    @Test
    public void brunoTokenTest2() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("1.21\n");
        writeFile.printf("identifier\n");
        writeFile.printf("*\n");
        writeFile.printf("+\n");
        writeFile.printf("-\n");
        writeFile.printf("&:\n");

        file.close();

        compiler = new CompiladorL3();
        compiler.runLexychal(path);
        lex = compiler.getLexico();

        assertEquals(1, lex.nextToken().getTipo());
        assertEquals(3, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(5, lex.nextToken().getTipo());
        assertEquals(77, lex.nextToken().getTipo());

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void brunoTokenTest3() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("&:");
        writeFile.printf("&:\n");
        writeFile.printf("&:");

        file.close();

        compiler = new CompiladorL3();
        compiler.runLexychal(path);
        lex = compiler.getLexico();

        assertEquals(77, lex.nextToken().getTipo());
        assertEquals(77, lex.nextToken().getTipo());
        assertEquals(77, lex.nextToken().getTipo());

        File delete = new File(path);
        delete.delete();
    }


    @Test
    public void brunoTokenTest4() throws Exception {
        Lexico lex;
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("&:");

        file.close();

        compiler = new CompiladorL3();
        compiler.runLexychal(path);
        lex = compiler.getLexico();

        assertEquals(77, lex.nextToken().getTipo());

        File delete = new File(path);
        delete.delete();
    }
}

