package Tests.Sintatic;

import CompiladorL3.OlimpoCompiler;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Reports to @aquilesRod

public class ArithmeticExpressionTest {

    @Test
    public void correctSyntaxTest() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("a = 10+(25/3+10-20)/(10);\n");
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

//    @Test
//    public void withoutArithmeticOperatorTest() throws Exception {
//        CompiladorL3 compiler;
//        String path = "codigoCompilador.txt";
//        FileWriter file = new FileWriter(path);
//        PrintWriter writeFile = new PrintWriter(file);
//
//        writeFile.printf("int main (){\n\t");
//        writeFile.printf("a = 10+20 10\n");
//        writeFile.printf("}$");
//        file.close();
//
//        String phrase = "Ei boy, tiracao! Ta faltando um operador aritmetico (+,-,/,*) nessa expressao";
//
//        try {
//            compiler = new CompiladorL3();
//            compiler.runSintatic(path);
//            Assert.fail();
//        }  catch (RuntimeException e){
//            assertEquals(phrase, e.getMessage());
//        }
//
//        File delete = new File(path);
//        delete.delete();
//    }
    
    @Test
    public void withoutValidTermAfterOperator() throws Exception {
        OlimpoCompiler compiler;
        String path = "codigoCompilador.txt";
        FileWriter file = new FileWriter(path);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.printf("int main (){\n\t");
        writeFile.printf("a = 10*10+10- \n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ta de comedia, ne pirra? Ta faltando um termo valido (id, int, float ou char) nessa expressao";

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
        writeFile.printf("a = (b*10\n");
        writeFile.printf("}$");
        file.close();

        String phrase = "Ai você me quebra! Fecha o parênteses perto da expressao aritmetica";

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

