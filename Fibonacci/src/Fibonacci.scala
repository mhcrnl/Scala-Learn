/*
 * https://peter-braun.org/de/2012/06/fibonacci-numbers-in-scala/
 * http://alvinalexander.com/scala/how-to-write-text-files-in-scala-printwriter-filewriter
 * http://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples
 */
import java.io._
import scala.util.control._
//import resource._
import scala.io.Source
import java.io.{FileNotFoundException, IOException}
import scala.util.{Try, Success, Failure}
class Fibonacci {
  
  def fibo1(n:Int):Int = n match {
    //Utilizare recursie
    case 0 | 1 => n
    case _ => fibo1(n-1) + fibo1(n-2)
  }
  
  def fibo2(n:Int): Int ={
    var a=0; var b=1; var i =0;
    while(i<n){
      val c =a+b
      a=b
      b=c;
      i=i+1
    }
    return a
  }
  
  def fibo3(n:Int): Int = {
    def fib_tail(n:Int, a:Int, b:Int):Int =n match{
      case 0 => a
      case _=> fib_tail(n-1, b, a+b)
    }
    return fib_tail(n,0,1)
  }
  
 def fibo4(n:Int): Int = {
   //Ultimii 6 digiti ai numerelor fibonacci
    def fib_tail(n:Int, a:Int, b:Int):Int =n match{
      case 0 => a
      case _=> fib_tail(n-1, b, (a+b) % 1000000)
    }
    return fib_tail(n,0,1)
  } 
  def fibo5(n:Int): Int = {
   //Ultimii 6 digiti ai numerelor fibonacci
    def fib_tail(n:Int, a:Int, b:Int):Int =n match{
      case 0 => a
      case _=> fib_tail(n-1, b, (a+b) % 1000000)
    }
    return fib_tail(n%1500000,0,1)
  } 
  
  def scrieInFila(fila:String){
    //PrintWriter
    val pw = new PrintWriter(new File(fila))
    for(num <- 0 to 30){
      pw.write(fibo1(num))
    }
    pw.close()
  }
  
  def scrieInFila_bw(fila:String){
    val file = new File(fila)
    val bw = new BufferedWriter(new FileWriter(file))
    for(num <- 0 to 30){
      bw.write(fibo1(num))
    }
    bw.close()
  }
  def readTextFile(filename: String): Option[List[String]] = {
    try {
        val lines = using(io.Source.fromFile(filename)) { source =>
            (for (line <- source.getLines) yield line).toList
        }
        Some(lines)
    } catch {
        case e: Exception => None
    }
  }
  //nu citeste - probabil doar in consola sistemului
  def readFromFile(file:String){
    val bufferedSource = Source.fromFile(file)
    for(line <- bufferedSource.getLines){
      println(line.toUpperCase)
    }
    bufferedSource.close
    //Source.fromFile(file).foreach {print}
  }
  def readTextFileWithTry(filename: String): Try[List[String]] = {
    Try {
        val lines = using(io.Source.fromFile(filename)) { source =>
            (for (line <- source.getLines) yield line).toList
        }
        lines
    }
  }
}


object FiboTest{
  
  def main(args:Array[String]){
    
    var num:Int = 0;
    var numF:Int = 30;
    var fib = new Fibonacci();
    
    for(num <- 0 to 40){
      println ("Numarul: " +num+" = "+ fib.fibo1(num));
    } 
    for(num <- 0 to 40){
      println ("Numarul fibo2: " +num+" = "+ fib.fibo2(num));
    } 
    for(num <- 0 to 40){
      println ("Numarul fibo3: " +num+" = "+ fib.fibo3(num));
    } 
    for(num <- 0 to 40){
      println ("Numarul fibo4: " +num+" = "+ fib.fibo4(num));
    }
    for(num <- 0 to 40){
      println ("Numaarul fibo5: " +num+" = "+ fib.fibo5(num));
    }
    
    fib.scrieInFila("fibonacci.txt")
    fib.scrieInFila_bw("fibonacci_bw.txt")
    fib.readFromFile("salut.txt")
    fib.readTextFileWithTry("salut.txt")
    scala.io.Source.fromFile("Fibonacci/salut.txt" ).foreach{  print  }
  }
}