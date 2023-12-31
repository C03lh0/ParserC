package Tests.Sintatic;

import CompiladorL3.OlimpoCompiler;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class AssignmentTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("a = 10;\n");
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
    
    //TA DISPARANDO ERRO DO METODO BLOCK FECHAR }
    @Test
    public void withoutIdentifierTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("= 10;\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Lascou! Qual é o identificador bença?";

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
    public void withoutAssignmentCharacterTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("a 10;\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Lascou! Cade o operador de atribuição bença?";

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
    public void withoutReceivedValueTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("a = \n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Sim, essa expressao vai receber o que? coloca o valor bença!";

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
    public void withoutFinalSenteceTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("a = 10\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Finaliza a atribuição ae bença, coloca o ';'";

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

