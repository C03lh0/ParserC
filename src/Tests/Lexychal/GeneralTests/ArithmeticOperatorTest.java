package Tests.Lexychal.GeneralTests;

import CompiladorL3.OlimpoCompiler;
import CompiladorL3.Lexical;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public class ArithmeticOperatorTest {

    @Test
    public void OnlyArithmeticOperator() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("+\n");
        writeFile.printf("-\n");
        writeFile.printf("*\n");
        writeFile.printf("/\n");

        file.close();

        compiler = new OlimpoCompiler();
        compiler.runLexical(path);
        lex = compiler.getLexicalAnalyzer();

        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());

        File delete = new File(path);
        delete.delete();

    }

    @Test
    public void OtherTokensWithArithmeticOperator() throws Exception {
        Lexical lex;
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("1.21\n");
        writeFile.printf("identifier\n");
        writeFile.printf("*\n");
        writeFile.printf("+\n");
        writeFile.printf("-\n");
        writeFile.printf("/\n");

        file.close();

        compiler = new OlimpoCompiler();
        compiler.runLexical(path);
        lex = compiler.getLexicalAnalyzer();

        assertEquals(1, lex.nextToken().getType());
        assertEquals(3, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());

        File delete = new File(path);
        delete.delete();

    }


}
