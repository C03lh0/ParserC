package CompiladorL3;

public class Parser {
    private Lexer lexicalAnalyzer;
    private Token token;

    public Parser(Lexer lexicalAnalyzer) {
        this.lexicalAnalyzer = lexicalAnalyzer;
    }

    public void s() throws Exception {
        token = lexicalAnalyzer.nextToken();
        if(!token.getLexeme().equals("int")){
            throw new RuntimeException("Iih rapaz! Cadê o tipo de retorno do main?");
        } else {
            token = lexicalAnalyzer.nextToken();
            if(!token.getLexeme().equals("main")){
                throw new RuntimeException("Iih rapaz! Cadê o main?");
            }
        }

        token = lexicalAnalyzer.nextToken();
        if(!token.getLexeme().equals("(")){
            throw new RuntimeException("Ai você me quebra! Abre o parênteses do main.");
        } else{
            token = lexicalAnalyzer.nextToken();
            if(!token.getLexeme().equals(")")){
                throw new RuntimeException("Ai você me quebra! Fecha o parênteses do main.");
            }
        }
        token = lexicalAnalyzer.nextToken();

        this.block();

        if(token.getType() == Token.END_CODE_TYPE){
            System.out.println("Boa minha fera! Escreveu o código certinho, botou pra lascar!");
        } else{
            throw new RuntimeException("Lascou! Deu bronca logo perto do fim do programa :(");
        }
    }

    private void block() throws Exception{
        
        if(!token.getLexeme().equals("{")){
            throw new RuntimeException("Como você é burro cara! Abre as chaves do método.");
        }
        this.token = this.lexicalAnalyzer.nextToken();
        
        this.InvalidMethod();
        this.goToDeclaretionOrComand();
        
        if(!token.getLexeme().equals("}")){
            throw new RuntimeException("Como você é burro cara! Fecha as chaves do método.");
        }
        this.token = this.lexicalAnalyzer.nextToken();
    }

    private void InvalidMethod() {
		if(this.token.getLexeme().equals("=")) {
			throw new RuntimeException("Lascou! Qual é o identificador bença?");
		}else if(this.token.getLexeme().equals("(")) {
			throw new RuntimeException("Cade a palavra reservada da condicional pra começar bença?");
		}
	}

	private void command() throws Exception{
        if(token.getType() == Token.IDENTIFIER_TYPE || token.getLexeme().equals("{")){
            this.basicCommand();
        }else if(token.getLexeme().equals("while")){
            this.iteration();
        } else if(token.getLexeme().equals("if")){
            token = lexicalAnalyzer.nextToken();
            if(!token.getLexeme().equals("(")){
                throw new RuntimeException("Ei comparça! Bora, abre o parênteses do if.");
            }
            
            this.relationalExpression();

            if(!token.getLexeme().equals(")")){
                throw new RuntimeException("Ei comparça! Bora, fecha o parênteses do if.");
            }
            token = lexicalAnalyzer.nextToken();
            
            if(!token.getLexeme().equals("{")){
                throw new RuntimeException("Ei comparça! Bora, abre o '{' do if.");
            }
           
            if(!isComand()){
                throw new RuntimeException("Poxa comparça! Estava esperando você declara algum comando pertinho de "+token.getLexeme());
            }
            this.command(); 

            if(!token.getLexeme().equals("else")){
                throw new RuntimeException("Ei comparça, cade o ELSE do teu if?");
            } 
            token = lexicalAnalyzer.nextToken();
            
            if(!token.getLexeme().equals("{")){
                throw new RuntimeException("Ei comparça! Bora, abre o '{' do else.");
            }

            if(!isComand()){
                throw new RuntimeException("Poxa comparça! Estava esperando você declara algum comando pertinho de "+token.getLexeme());
            }
            
            this.command();
           
            if(!token.getLexeme().equals("?")){
                throw new RuntimeException("Ei comparça, teu else acaba não é? Coloca '?' depois de '}'");
            }
            token = lexicalAnalyzer.nextToken();
        } else {
            throw new RuntimeException("Poxa comparça! Estava esperando você declara algum comando pertinho de "+token.getLexeme());
        }
    }

    private void goToDeclaretionOrComand() throws Exception {
        if(token.getLexeme().equals("int") || token.getLexeme().equals("float") || token.getLexeme().equals("char") || isReservedWorld(token.getLexeme()) ||
        token.getLexeme().equals("{") || isComand()){

            if(token.getLexeme().equals("return")){
                token = lexicalAnalyzer.nextToken();
                if(token.getLexeme().equals("0")){
                    token = lexicalAnalyzer.nextToken();
                    if(token.getLexeme().equals(";")){
                        token = lexicalAnalyzer.nextToken();
                        
                    }
                }
                return;
            }

            this.declaretaionOrComand();
            this.goToDeclaretionOrComand();
        }
    }

    private boolean isReservedWorld(String world) {
		ReservedWorld reservedWorld = new ReservedWorld(world);
		return reservedWorld.EqualsReservedWorld();
	}

    private void declaretaionOrComand() throws Exception {
        if(token.getLexeme().equals("int") || token.getLexeme().equals("float") || 
        token.getLexeme().equals("char")){
            this.declarationVariables();
        } else if (isComand()){
            this.command();
        } else {
            throw new RuntimeException("Lamentavel! Estava esperando tu declarar um comando pertinho de "+token.getLexeme());
        }
    }

    private boolean isComand() {
        return token.getType() == Token.IDENTIFIER_TYPE || token.getLexeme().equals("{") ||
        token.getLexeme().equals("while") || token.getLexeme().equals("if");
    }
    
    private void basicCommand() throws Exception{
        if(token.getType() == Token.IDENTIFIER_TYPE){
            this.assignment();
        } else if (token.getLexeme().equals("{")){
            this.block();
        } else {
            throw new RuntimeException("Ei bença, complicado em! Cade o identificador ou { para iniciar o bloco?");
        }

    }

    private void iteration() throws Exception{
        if(!token.getLexeme().equalsIgnoreCase("while")){
            throw new RuntimeException("Cade o while pra começar bença?");
        }
        token = lexicalAnalyzer.nextToken();
        if(!token.getLexeme().equalsIgnoreCase("(")){
            throw new RuntimeException("Ô Bença coloca o ( para iniciar a expreção relacional do while");
        }
        
        this.relationalExpression();

        if(!token.getLexeme().equalsIgnoreCase(")")){
            throw new RuntimeException("Ô Bença coloca o ) para finalizar a expreção relacional do while");
        }
        token = lexicalAnalyzer.nextToken();
        this.command();
    }

    private void assignment() throws Exception{
        if(token.getType() != Token.IDENTIFIER_TYPE){
            throw new RuntimeException("Lascou! Qual é o identificador bença?");
        }
        
        token = lexicalAnalyzer.nextToken();
        if(token.getType() != Token.ASSIGNMENT_OPERADOR_TYPE){
            throw new RuntimeException("Lascou! Cade o operador de atribuição bença?");
        }
        
        token = lexicalAnalyzer.nextToken(); 
        if(!isValidTerm() && !token.getLexeme().equals("(")) {
        	throw new RuntimeException("Sim, essa expressao vai receber o que? coloca o valor bença!");
        }
        this.arithmeticExpression();
        
        if(!token.getLexeme().equals(";")){ 
            throw new RuntimeException("Finaliza a atribuição ae bença, coloca o ';'");
        }
        token = lexicalAnalyzer.nextToken();
    }

    private void Type() throws Exception{
        if(token.getLexeme().equals("int") || token.getLexeme().equals("float") || token.getLexeme().equals("char")){
            token = lexicalAnalyzer.nextToken();
        } else {
            throw new RuntimeException("To na espera de um tipo Bebezinho <3");
        }
    }

    public void declarationVariables() throws Exception{
        this.Type();
        if(token.getType() != Token.IDENTIFIER_TYPE){
            throw new RuntimeException("Cade o identificador bença?");
        }

        token = lexicalAnalyzer.nextToken();
        if(token.getType() == Token.ASSIGNMENT_OPERADOR_TYPE){
            token = lexicalAnalyzer.nextToken(); 
            if(!isValidTerm()) {
        	    throw new RuntimeException("Sim, essa expressao vai receber o que? coloca o valor bença!");
            }
            this.arithmeticExpression();
        }

        if(!token.getLexeme().equalsIgnoreCase(";")){
            throw new RuntimeException("Eeeeeeeeei bença? Tu vai finalizar a declação de variavel não?");
        }

        token= lexicalAnalyzer.nextToken();
    }

    private void relationalExpression() throws Exception {
        if ((token.getLexeme().equals("(")) || (isValidTerm())) {
        	this.token = lexicalAnalyzer.nextToken();
            arithmeticExpression();
        } else {
            throw new RuntimeException("Rapaz, isso aqui nao e uma expressao aritmetica nao visse..."); 
        }

        if(!(this.token.getType() == Token.RELACIONAL_OPERATOR_TYPE))
            throw new RuntimeException("Erro, relaciona ai o que foi! Ta faltando o operador relacional mermao...");
        this.token = lexicalAnalyzer.nextToken();

        if (!(isValidTerm()) && !(token.getLexeme().equals("("))) {
        	throw new RuntimeException("Rapaz, isso aqui nao e uma expressao aritmetica nao visse...");
        } 
        
        arithmeticExpression();
    }

    private void arithmeticExpression() throws Exception {
        this.arithmeticExpressionTerm();
        this.arithmeticExpressionDerivated();
    }

    private void arithmeticExpressionDerivated() throws Exception {
        //Modified for @aquiles
        if (this.token.getType() == Token.ARITHMETIC_OPERATOR_TYPE) {
            this.arithmeticExpressionOperator();
            this.arithmeticExpressionTerm();
            this.arithmeticExpressionDerivated();
        }
        //else nothing will happen, just return
    }

    private void arithmeticExpressionTerm() throws Exception {
        if(token.getLexeme().equals("(")) {
            this.token = lexicalAnalyzer.nextToken();
            this.arithmeticExpressionWithParentesis();
        } else if (isValidTerm()) {
            this.token = lexicalAnalyzer.nextToken();
        } else {
            throw new RuntimeException("Ta de comedia, ne pirra? Ta faltando um termo valido (id, int, float ou char) nessa expressao");
        }
    }

    private boolean isValidTerm() {
        return this.token.getType() == Token.IDENTIFIER_TYPE || 
                this.token.getType() == Token.INTEGER_TYPE ||
                this.token.getType() == Token.REAL_TYPE ||
                this.token.getType() == Token.CHAR_TYPE;
    }

    private void arithmeticExpressionWithParentesis() throws Exception {
        this.arithmeticExpression();

        if(!token.getLexeme().equals(")")){
            throw new RuntimeException("Ai você me quebra! Fecha o parênteses perto da expressao aritmetica");
        }
        this.token = lexicalAnalyzer.nextToken();
    }

    private void arithmeticExpressionOperator() throws Exception {
        //Modified for @aquilesR
        if (this.token.getType() == Token.ARITHMETIC_OPERATOR_TYPE) {
            this.token = lexicalAnalyzer.nextToken();
        } else {
            throw new RuntimeException("Ei boy, tiracao! Ta faltando um operador aritmetico (+,-,/,*) nessa expressao");
        }
    }

}
