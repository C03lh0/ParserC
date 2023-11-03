package Tests.Sintatic;

import CompiladorL3.CompiladorL3;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class BlockTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){}$\n");
        file.close();

        try {
            compiler = new CompiladorL3();
            compiler.runSintatic(path);
            
            Assert.assertTrue(true);
        } catch (RuntimeException e){
            Assert.fail();
        } 

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutInitialKeyTest() throws Exception {
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main ()}$\n");
        file.close();

        String phrase = "Como você é burro cara! Abre as chaves do método.";

        try {
            compiler = new CompiladorL3();
            compiler.runSintatic(path);
            
            Assert.fail();
        } catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutFinalKeyTest() throws Exception {
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){ $\n");
        file.close();

        String phrase = "Como você é burro cara! Fecha as chaves do método.";

        try {
            compiler = new CompiladorL3();
            compiler.runSintatic(path);
            
            Assert.fail();
        } catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }
}

