package ParserC.lexicon;

public class ReservedWorld {
	private String reservedWorld;
	
	private final String RESERVEDWORLD_MAIN = "main";
	private final String RESERVEDWORLD_IF = "if";
	private final String RESERVEDWORLD_ELSE = "else";
	private final String RESERVEDWORLD_WHILE = "while";
	private final String RESERVEDWORLD_DO = "do";
	private final String RESERVEDWORLD_FOR = "for";
	private final String RESERVEDWORLD_INT = "int";
	private final String RESERVEDWORLD_FLOAT = "float";
	private final String RESERVEDWORLD_CHAR = "char";
	
	public ReservedWorld(String reservedWorld) {
		this.reservedWorld = reservedWorld;
	}
	
	public boolean equalsReservedWorld() {
		
		return this.reservedWorld.equals(this.RESERVEDWORLD_MAIN) ||
				this.reservedWorld.equals(this.RESERVEDWORLD_IF) || 
				this.reservedWorld.equals(this.RESERVEDWORLD_ELSE)||
				this.reservedWorld.equals(this.RESERVEDWORLD_WHILE) || 
				this.reservedWorld.equals(this.RESERVEDWORLD_DO) || 
				this.reservedWorld.equals(this.RESERVEDWORLD_FOR) || 
				this.reservedWorld.equals(this.RESERVEDWORLD_INT) || 
				this.reservedWorld.equals(this.RESERVEDWORLD_FLOAT) || 
				this.reservedWorld.equals(this.RESERVEDWORLD_CHAR);
	}

}
