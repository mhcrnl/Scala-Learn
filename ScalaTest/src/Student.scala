

class Student (val nume: String, val prenume: String) {
  var vnume: String = nume;
  var vprenume: String = prenume;
  
  def afiseaza {
    println("Nume: " + vnume);
    println("Prenume: " + vprenume);
  }
}