package CompiladorL3;

import CompiladorL3.semantic.Semantic;

public class OlimpoCompiler {
	
	private Lexical lexicalAnalyzer;
	private Parser syntaxAnalyzer;
    private Semantic semanticAnalyzer;
    
    public void runSemantic(String codeFilePath) throws Exception {
		this.lexicalAnalyzer = new Lexical(codeFilePath);
		this.semanticAnalyzer = new Semantic();
        
        Token token = this.lexicalAnalyzer.nextToken();
        token = this.lexicalAnalyzer.nextToken();
		token = this.lexicalAnalyzer.nextToken();
		do {
			if (token.getType() != Token.END_CODE_TYPE)
				analyzeSemantic(token);
			
			//System.out.println(token.toString());
			token = this.lexicalAnalyzer.nextToken();
		} while (token != null);
		
		this.lexicalAnalyzer.setContentIndex(0);
	}
    
    public void runLexical(String codeFilePath) throws Exception {
    	this.lexicalAnalyzer = new Lexical(codeFilePath);
  
        Token t = null;
        while((t = this.lexicalAnalyzer.nextToken()) != null){
            System.out.println(t.toString());
        }
        this.lexicalAnalyzer.setContentIndex(0);
    }
    
    public void runSyntax(String codeFilePath) throws Exception {
    	this.lexicalAnalyzer = new Lexical(codeFilePath);
		Parser sintatico = new Parser(lexicalAnalyzer);
		sintatico.s();
		this.lexicalAnalyzer.setContentIndex(0);
    }

	private void analyzeSemantic(Token token) throws Exception {
		if((token.getType() != 7 && !token.getLexeme().equals("(") &&
				!token.getLexeme().equals(")")) || token.getLexeme().equals("int") ||
				token.getLexeme().equals("char") || token.getLexeme().equals("float")){
			this.semanticAnalyzer.runSemantic(token);
		}
	}
    
    public Lexical getLexicalAnalyzer() {
		return this.lexicalAnalyzer;
	}

    public Parser getSyntaxAnalyzer() {
        return this.syntaxAnalyzer;
    }

}
