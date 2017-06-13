

class Persoana(val num:String, val pre:String) {
  
  private var _nume:String = num;
  private var _prenume:String = pre;
  
  //Getter
  def nume = _nume;
  //Setter
  def setNume(value:String):Unit = _nume = value;
  //Getter
  def prenume = _prenume;
  //Setter
  def setPrenume(value:String):Unit = _prenume  = value;
  //toString
  override def toString:String = s"$num $pre" ;
}