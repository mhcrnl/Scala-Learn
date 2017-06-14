import java.io._

object ReadWrite {
  def main(args: Array[String]){
    val writer = new PrintWriter(new File("test.txt"))
    writer. write("Salut!")
    writer.close()
  }
  
}