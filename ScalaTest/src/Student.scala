import java.io._

class Student (override val num:String, override val pre:String, val mat:Int) extends Persoana(num, pre) {
  
  //private var _nume:String = num;
  //private var _prenume:String = pre;
  private var pers = new Persoana(num, pre);
  private var _matricol:Int = mat;
  
  /*//Getter
  def nume = _nume;
  //Setter
  def setNume (value:String):Unit = _nume = value ;
  //Getter
  def prenume = _prenume;
  //Setter
  def setPrenume(value:String):Unit = _prenume = value;
  */
  //toString
  override def toString:String = 
    s"$pers $mat";
  
  def afiseaza {
    println("Nume: " + pers.nume);
    println("Prenume: " + pers.prenume);
  }
  /*
  def setNume(num:String): String = {
    var vnume:String = num ;
    return vnume;
  }
  */
}