package CompiladorL3;

import CompiladorL3.semantic.Semantic;

public class OlimpoCompiler {
	
	private Lexer lexico;
	private Parser sintatico;
    private Semantic semantic;
    
    public void runSemantic(String codeFilePath) throws Exception {
		this.lexico = new Lexer(codeFilePath);
		this.semantic = new Semantic();
        
        Token token = this.lexico.nextToken();
        token = this.lexico.nextToken();
		token = this.lexico.nextToken();
		do {
			if (token.getType() != Token.END_CODE_TYPE)
				semanticAnalize(token);
			
			//System.out.println(token.toString());
			token = this.lexico.nextToken();
		} while (token != null);
		
		this.lexico.setIndiceConteudo(0);
	}
    
    public void runLexychal(String codeFilePath) throws Exception {
    	this.lexico = new Lexer(codeFilePath);
  
        Token t = null;
        while((t = this.lexico.nextToken()) != null){
            System.out.println(t.toString());
        }
        this.lexico.setIndiceConteudo(0);
    }
    
    public void runSintatic(String codeFilePath) throws Exception {
    	this.lexico = new Lexer(codeFilePath);
		Parser sintatico = new Parser(lexico);
		sintatico.s();
		this.lexico.setIndiceConteudo(0);
    }

	private void semanticAnalize(Token token) throws Exception {
		if((token.getType() != 7 && !token.getLexeme().equals("(") &&
				!token.getLexeme().equals(")")) || token.getLexeme().equals("int") ||
				token.getLexeme().equals("char") || token.getLexeme().equals("float")){
			this.semantic.runSemantic(token);
		}
	}
    
    public Lexer getLexico() {
		return this.lexico;
	}

    public Parser getSintatico() {
        return this.sintatico;
    }

}
