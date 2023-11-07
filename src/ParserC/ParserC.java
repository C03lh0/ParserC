package ParserC;

import ParserC.lexicon.Lexicon;
import ParserC.lexicon.Token;
import ParserC.semantic.Semantic;
import ParserC.sintatic.Sintatic;

public class ParserC {
	
	private Lexicon lexicon;
	private Sintatic sintatic;
    private Semantic semantic;
    
    public void runSemantic(String codeFilePath) throws Exception {
		this.lexicon = new Lexicon(codeFilePath);
		this.semantic = new Semantic();
        
        Token token = this.lexicon.nextToken();
        token = this.lexicon.nextToken();
		token = this.lexicon.nextToken();
		do {
			if (token.getType() != Token.TYPE_FINISHED_CODE)
				semanticAnalize(token);
			
			//System.out.println(token.toString());
			token = this.lexicon.nextToken();
		} while (token != null);
		
		this.lexicon.setContentIndex(0);
	}
    
    public void runLexychal(String codeFilePath) throws Exception {
    	this.lexicon = new Lexicon(codeFilePath);
  
        Token t = null;
        while((t = this.lexicon.nextToken()) != null){
            System.out.println(t.toString());
        }
        this.lexicon.setContentIndex(0);
    }
    
    public void runSintatic(String codeFilePath) throws Exception {
    	this.lexicon = new Lexicon(codeFilePath);
		sintatic = new Sintatic(lexicon);
		sintatic.runSintaticAnalyzer();
		this.lexicon.setContentIndex(0);
    }

	private void semanticAnalize(Token token) throws Exception {
		if((token.getType() != 7 && !token.getLexema().equals("(") &&
				!token.getLexema().equals(")")) || token.getLexema().equals("int") ||
				token.getLexema().equals("char") || token.getLexema().equals("float")){
			this.semantic.runSemantic(token);
		}
	}
    
    public Lexicon getLexicon() {
		return this.lexicon;
	}

    public Sintatic getSintatic() {
        return this.sintatic;
    }

}
