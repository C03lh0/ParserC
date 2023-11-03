package CompiladorL3.semantic;

import java.util.ArrayList;
import java.util.List;

public class Scope {
    private List<Variable> declaredVariables = new ArrayList<Variable>();
    private List<Variable> unDeclaredVariables = new ArrayList<Variable>();

    public boolean addDeclaredVariable(String variableName, Type type, String value) {
        Variable newVar = new Variable(variableName, type, value);
        declaredVariables.add(newVar);
        return true;
    }

    public boolean unDeclaredVariable(String variableName, Type type, String value) {
        Variable newVar = new Variable(variableName, type, value);
        unDeclaredVariables.add(newVar);
        return true;
    }

    public boolean bothBelongToTheSameScope(Variable firstVariable, Variable secondVariable) {
        
        if(getVariable(firstVariable) != null || getVariable(secondVariable) != null) {
            return getVariable(firstVariable) == getVariable(secondVariable);
        }
        
        return false;
    }

    public Variable getVariable(Variable firstVariable) {
        if(declaredVariables.indexOf(firstVariable) == -1) {
            return null;
        }
        return declaredVariables.get(declaredVariables.indexOf(firstVariable));
    }
    
    public Variable getVariable(String name) {
        Variable var =  new Variable(name, null, null);
        if(declaredVariables.indexOf(var) != -1) {
            return declaredVariables.get(declaredVariables.indexOf(var));
        } else if (unDeclaredVariables.indexOf(var) != -1){
            return unDeclaredVariables.get(unDeclaredVariables.indexOf(var));
        }
        return null;
    }
}