package ParserC;

public class Main {

	public static void main(String[] args) {
		String path = "src/CompiladorL3/codigo.txt";
		ParserC c = new ParserC();
		try {
			c.runLexychal(path);
			c.runSintatic(path);
			c.runSemantic(path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
