package Tests.Lexychal.GeneralTests;

import org.junit.Test;

import ParserC.ParserC;
import ParserC.lexicon.Lexicon;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public class ArithmeticOperatorTest {

    @Test
    public void OnlyArithmeticOperator() throws Exception {
        Lexicon lex;
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("+\n");
        writeFile.printf("-\n");
        writeFile.printf("*\n");
        writeFile.printf("/\n");

        file.close();

        parserC = new ParserC();
        parserC.runLexychal(path);
        lex = parserC.getLexicon();

        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());
        assertEquals(5, lex.nextToken().getType());

        File delete = new File(path);
        delete.delete();

    }

    @Test
    public void OtherTokensWithArithmeticOperator() throws Exception {
        Lexicon lex;
        ParserC parserC;
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

        parserC = new ParserC();
        parserC.runLexychal(path);
        lex = parserC.getLexicon();

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
