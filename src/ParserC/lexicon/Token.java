package ParserC.lexicon;

public class Token {
    public static int TYPE_INTEGER = 0;
    public static int TYPE_REAL = 1;
    public static int TYPE_CHAR = 2;
    public static int TYPE_IDENTIFIER = 3;
    public static int TYPE_RELATIONAL_OPERATOR = 4;
    public static int TYPE_ARITHMETICAL_OPERATOR = 5;
    public static int TYPE_ESPECIAL_CHARACTER = 6;
    public static int TYPE_RESERVED_WORLD = 7;
    public static int TYPE_ASSIGNMENT_OPERATOR = 8;
    public static int TYPE_FINISHED_CODE = 99;
    
    private int type; //tipo do token
    private String lexema; //conteúdo do token
    
    public Token(String lexema, int type){
        this.lexema = lexema;
        this.type = type;
    }
    
    public String getLexema(){
        return this.lexema;
    }
    
    public int getType(){
        return this.type;
    }
    
    @Override
    public String toString()
    {
        switch(this.type){
            case 0:
                return this.lexema + " - INTEIRO" ;
            case 1:
                return this.lexema + " - REAL";
            case 2:
                return this.lexema + " - CHAR";
            case 3:
                return this.lexema + " - IDENTIFICADOR";
            case 4:
                return this.lexema + " - OPERADOR_RELACIONAL";
            case 5:
                return this.lexema + " - OPERADOR_ARITMETICO";
            case 6:
                return this.lexema + " - CARACTER_ESPECIAL";
            case 7:
                return this.lexema + " - PALAVRA_RESERVADA";
            case 8:
            	return this.lexema + " - OPERADOR_DE_ATRIBUICAO";
            case 99:
                return this.lexema + " - FIM_CODIGO";    
        }
        return "";
    }
}