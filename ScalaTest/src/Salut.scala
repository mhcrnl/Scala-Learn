

object Salut {
    def main(args: Array[String]){
      println("Salut din Scala!");
      var std = new Student("Mihai", "Cornel", 1234);
      std.afiseaza;
      std.setNume("Vasile");
      std.afiseaza;
      std.setPrenume("Radu");
      std.afiseaza;
      println("Nume:" + std.nume);
      println(std.toString());
    }
  
}