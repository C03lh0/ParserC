package ParserC.semantic;

import java.util.ArrayList;
import java.util.List;

import ParserC.lexicon.Token;

public class SOperationChecker {
	private Semantic semanticSubject;
	private List<Token> operationParts;

	public SOperationChecker(Semantic subject) {
		this.semanticSubject = subject;
		operationParts = new ArrayList<Token>();
	}

	public void currentTokenIsValidForOperation(Token currentToken) throws Exception {
		
		if (isAnIdentifier(currentToken) && operationParts.size() == 0) {
			variableIsInCurrentScope(currentToken);
			this.operationParts.add(currentToken);
			return;
		} else if(isAnIdentifier(currentToken) && variableIsInCurrentScope(currentToken) && !haveASameType(currentToken)) {
			throw new Exception("Operators have differents types in: '" + currentOperationPartsToString() + " " + currentToken.getLexema() + "'");
		}
		
		this.operationParts.add(currentToken);
		return;
		
		/*
		
		if (isAnIdentifier(currentToken) && !(operationParts.get(0).getType() == currentToken.getType())) {
			throw new Exception("Operators have differents types in: '" + currentOperationPartsToString() + "'");
		} else if (!correctLogicalSequence(currentToken)) {
			throw new Exception("Sequentially repeated tokens type: '" + currentOperationPartsToString() + "'");
		} else if (!isAnIdentifier(currentToken) && !isAnOperator(currentToken) && !isAnOperationTerminator(currentToken)) {
			throw new Exception("Invalid token for operations '" + currentOperationPartsToString() + "'");
		} else if (isAnOperationTerminator(currentToken)) {
			finishOperation();
		} else {
			throw new Exception("ERROR in operation '" + currentOperationPartsToString() + "'");
		}
		*/
	}

	private boolean haveASameType(Token currentToken) {
		Variable a = this.semanticSubject.getCurrentScope().getVariable(operationParts.get(0).getLexema());
		Variable b = this.semanticSubject.getCurrentScope().getVariable(currentToken.getLexema());
		return a.getType().equals(b.getType());
	}

	private boolean variableIsInCurrentScope(Token currentToken) throws Exception {
		if(this.semanticSubject.getCurrentScope().getVariable(currentToken.getLexema()) == null) {
			throw new Exception("Undeclared variable '" + currentToken.getLexema() + "' <-");
		}
		return true;
	}

	private void finishOperation() {
		semanticSubject.updateOperationChecker();
		operationParts = null;
	}

	private String currentOperationPartsToString() {
		String toString = "";
		for (Token currentPart : this.operationParts) {
			toString += currentPart.getLexema() + " ";
		}
		return toString;
	}

	private boolean isAnIdentifier(Token currentPart) {
		return currentPart.getType() == 3;
	}

	private boolean isAnOperator(Token currentPart) {
		return currentPart.getType() == 4 || currentPart.getType() == 5;
	}

	private boolean correctLogicalSequence(Token currentPart) {
		return operationParts.get(operationParts.size() - 1).getType() != currentPart.getType();
	}

	private boolean isAnOperationTerminator(Token currentPart) throws Exception {

		if (currentPart.getLexema().equals(";"))
			return currentPart.getLexema().equals(";");
		throw new Exception("Statement not finished: '" + currentOperationPartsToString() + "' <-");
	}
}
