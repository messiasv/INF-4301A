package ast;

public class Aff extends Exp{

  private String name;
  private Exp value;
  public Aff(String l, Exp r){
    this.name = l;
    this.value = r;
  }

  public String getName(){
    return this.name;
  }

  public Exp getValue(){
    return this.value;
  }
}
