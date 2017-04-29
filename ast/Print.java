package ast;

public class Print extends Exp{

  Exp to_print;
  public Print(Exp a){
    this.to_print = a;
  }

  public Exp getPrint(){
    return this.to_print;
  }

}
