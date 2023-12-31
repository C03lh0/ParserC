package Tests.Sintatic;

import CompiladorL3.OlimpoCompiler;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class ProgramTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main () {}$\n");
        file.close();

        try {
            compiler = new OlimpoCompiler();
            compiler.runSyntax(path);
            
            Assert.assertTrue(true);
        } catch (RuntimeException e){
            Assert.fail();
        }

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutReturnTypeTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("float main () {}$\n");
        file.close();

        String phrase = "Iih rapaz! Cadê o tipo de retorno do main?";

        try {
            compiler = new OlimpoCompiler();
            compiler.runSyntax(path);

            Assert.fail();
        } catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutMainTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int char () {}$\n");
        file.close();

        String phrase = "Iih rapaz! Cadê o main?";

        try {
            compiler = new OlimpoCompiler();
            compiler.runSyntax(path);

            Assert.fail();
        } catch (RuntimeException e) {
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutInitialParentesisTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main ) {}$\n");
        file.close();

        String phrase = "Ai você me quebra! Abre o parênteses do main.";

        try {
            compiler = new OlimpoCompiler();
            compiler.runSyntax(path);

            Assert.fail();
        }  catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutFinalParentesisTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main ) {}$\n");
        file.close();

        String phrase = "Ai você me quebra! Abre o parênteses do main.";

        try {
            compiler = new OlimpoCompiler();
            compiler.runSyntax(path);

            Assert.fail();
        }  catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

}

