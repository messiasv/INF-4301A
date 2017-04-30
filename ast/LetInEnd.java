package ast;

import java.util.HashMap;
import java.util.ArrayList;

public class LetInEnd extends Exp{

  private HashMap<String, Exp> variables;
  private ArrayList<Exp> instructions;

	public LetInEnd (HashMap<String, Exp> variables, ArrayList<Exp> instructions){
    this.variables    = variables;
    this.instructions = instructions;
	}

  public HashMap<String, Exp> getVariables() {
    return this.variables;
  }

  public ArrayList<Exp> getInstructions() {
    return this.instructions;
  }
}
