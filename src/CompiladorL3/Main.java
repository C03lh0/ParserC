package CompiladorL3;

public class Main {

	public static void main(String[] args) {
		String path = "src/CompiladorL3/codigo.txt";
		OlimpoCompiler c = new OlimpoCompiler();
		try {
			c.runLexychal(path);
			c.runSintatic(path);
			c.runSemantic(path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
