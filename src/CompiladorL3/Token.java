package CompiladorL3;

public class Token {
    public static int INTEGER_TYPE = 0;
    public static int REAL_TYPE = 1;
    public static int CHAR_TYPE = 2;
    public static int IDENTIFIER_TYPE = 3;
    public static int RELACIONAL_OPERATOR_TYPE = 4;
    public static int ARITHMETIC_OPERATOR_TYPE = 5;
    public static int SPECIAL_CARACTER_TYPE = 6;
    public static int RESERVED_WORD_TYPE = 7;
    public static int ASSIGNMENT_OPERADOR_TYPE = 8;
    public static int END_CODE_TYPE = 99;
    
    private int type; //tipo do token
    private String lexeme; //conteúdo do token
    
    public Token(String lexeme, int type){
        this.lexeme = lexeme;
        this.type = type;
    }
    
    public String getLexeme(){
        return this.lexeme;
    }
    
    public int getType(){
        return this.type;
    }
    
    @Override
    public String toString()
    {
        switch(this.type){
            case 0:
                return this.lexeme + " - INTEGER" ;
            case 1:
                return this.lexeme + " - REAL";
            case 2:
                return this.lexeme + " - CHAR";
            case 3:
                return this.lexeme + " - IDENTIFIER";
            case 4:
                return this.lexeme + " - RELACIONAL_OPERATOR";
            case 5:
                return this.lexeme + " - ARITHMETIC_OPERATOR";
            case 6:
                return this.lexeme + " - SPECIAL_CARACTER";
            case 7:
                return this.lexeme + " - RESERVED_WORD";
            case 8:
            	return this.lexeme + " - ASSIGNMENT_OPERATOR";
            case 99:
                return this.lexeme + " - END_CODE";    
        }
        return "";
    }
}