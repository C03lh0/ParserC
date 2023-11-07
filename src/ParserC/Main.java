package ParserC;

public class Main {

	public static void main(String[] args) {
		String path = "src/ParserC/codigo.txt";
		ParserC parserC = new ParserC();
		try {
			parserC.runLexychal(path);
			parserC.runSintatic(path);
			parserC.runSemantic(path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
