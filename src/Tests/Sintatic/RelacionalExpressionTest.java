package Tests.Sintatic;

import CompiladorL3.OlimpoCompiler;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class RelacionalExpressionTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){ \n\t");
        writeFile.printf("if (a > (b+2)){ \n\t");
        writeFile.printf("a = 2; }");
        writeFile.printf("else { \n");
        writeFile.printf("a = 3; }? \n");
        writeFile.printf("}$");
        file.close();

        try {
            compiler = new OlimpoCompiler();
            compiler.runSintatic(path);
            
            Assert.assertTrue(true);
        } catch (RuntimeException e){
        	System.out.println(e.getMessage());
            Assert.fail();
        } 

        File delete = new File(path);
        delete.delete();
    }

    @Test
    public void withoutRelacionalOperatorTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){ \n\t");
        writeFile.printf("if (a+2){ \n\t");
        writeFile.printf("a = 2; }");
        writeFile.printf("else { \n");
        writeFile.printf("a = 3; } \n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Erro, relaciona ai o que foi! Ta faltando o operador relacional mermao...";

        try {
            compiler = new OlimpoCompiler();
            compiler.runSintatic(path);
            
            Assert.fail();
        }  catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }
}
