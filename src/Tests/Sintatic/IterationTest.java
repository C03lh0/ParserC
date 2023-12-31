package Tests.Sintatic;

import CompiladorL3.OlimpoCompiler;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class IterationTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("while (id == 1) {j = 3;}\n");
        writeFile.printf("}$");
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
    
    //DISPARANDO ERRO DO METODO BLOCK DE FECHAR }
    @Test
    public void withoutWhileTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("(id == 1) {j = 3;}\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Cade a palavra reservada da condicional pra começar bença?";

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
    public void withoutInitialParentesisTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("while id == 1) {j = 3;}\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ô Bença coloca o ( para iniciar a expreção relacional do while";

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

        writeFile.printf("int main (){\n\t");
        writeFile.printf("while (id == 1 {j = 3;}\n");
        writeFile.printf("}");
        file.close();

        String phrase = "Ô Bença coloca o ) para finalizar a expreção relacional do while";

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

