package Tests.Sintatic;

import CompiladorL3.CompiladorL3;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class VariableDeclarationTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("char caractere;\n");
        writeFile.printf("}$");
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
    public void withoutIdentifierTest() throws Exception {
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("int\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Cade o identificador bença?";

        try {
            compiler = new CompiladorL3();
            compiler.runSintatic(path);
            
            Assert.fail();
        }  catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }
    
    @Test
    public void withoutFinalSentenceTest() throws Exception {
        CompiladorL3 compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("float average\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Eeeeeeeeei bença? Tu vai finalizar a declação de variavel não?";

        try {
            compiler = new CompiladorL3();
            compiler.runSintatic(path);
            
            Assert.fail();
        }  catch (RuntimeException e){
        	assertEquals(phrase, e.getMessage());
        }

        File delete = new File(path);
        delete.delete();
    }

}

