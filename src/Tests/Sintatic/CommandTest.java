package Tests.Sintatic;

import org.junit.*;

import ParserC.ParserC;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class CommandTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n");
        writeFile.printf("if (id < 4) {id = 0;} else {id = 4;}? \n");
        writeFile.printf("}$");
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
    
    //TA DISPARANDO ERRO DO METODO BLOCK FECHAR }
    @Test
    public void withoutIFTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("(id < 4) {id = 0;} else {id = 4;}? \n");
        writeFile.printf("}$");
        file.close();
        
        String phrase = "Cade a palavra reservada da condicional pra começar bença?";

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
    public void withoutInitialParentesisTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("if id < 4) {id = 0;} else {id = 4;}? \n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ei comparça! Bora, abre o parênteses do if.";

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
    public void withoutFinalParentesisTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("if (id < 4 {id = 0;} else {id = 4;}? \n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ei comparça! Bora, fecha o parênteses do if.";

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
    public void withoutElseTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("if (id < 4) {id = 0;} {id = 4;}? \n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ei comparça, cade o ELSE do teu if?";

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
    public void withoutInterrogationTest() throws Exception {
        ParserC parserC;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){ \n\t");
        writeFile.printf("if (id < 4) {id = 0;} else {id = 4;}\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ei comparça, teu else acaba não é? Coloca '?' depois de '}'";

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

