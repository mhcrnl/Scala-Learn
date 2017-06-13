

class Fibonacci {
  
  def fibo1(n:Int):Int = n match {
    //Utilizare recursie
    case 0 | 1 => n
    case _ => fibo1(n-1) + fibo1(n-2)
  }
}


object FiboTest{
  
  def main(args:Array[String]){
    
    var num:Int = 0;
    var numF:Int = 30;
    var fib = new Fibonacci();
    
    for(num <- 0 to 40){
      println ("Numerul: " +num+" = "+ fib.fibo1(num));
    } 
  }
}