package CompiladorL3;

public class Main {

	public static void main(String[] args) {
		String path = "src/CompiladorL3/codigo.txt";
		OlimpoCompiler c = new OlimpoCompiler();
		try {
			c.runLexical(path);
			c.runSyntax(path);
			c.runSemantic(path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
