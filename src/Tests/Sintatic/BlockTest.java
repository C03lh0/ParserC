package Tests.Sintatic;

import org.junit.*;

import ParserC.ParserC;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class BlockTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){}$\n");
        file.close();

        try {
            parserC = new ParserC();
            parserC.runSintatic(path);
            
            Assert.assertTrue(true);
        } catch (RuntimeException e){
            Assert.fail();
        } 

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutInitialKeyTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main ()}$\n");
        file.close();

        String phrase = "Como você é burro cara! Abre as chaves do método.";

        try {
            parserC = new ParserC();
            parserC.runSintatic(path);
            
            Assert.fail();
        } catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutFinalKeyTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){ $\n");
        file.close();

        String phrase = "Como você é burro cara! Fecha as chaves do método.";

        try {
            parserC = new ParserC();
            parserC.runSintatic(path);
            
            Assert.fail();
        } catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }
}

