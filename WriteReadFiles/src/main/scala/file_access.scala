class file_access {
  import scala.io.Source
  import java.io._

  var text: String = ""

  def readfile(file: String) {
    val dir = "/Users/indraaristya/Documents/Kerja Praktek - NoLimit/WriteReadFiles/files/"
    val read = Source.fromFile(s"${dir}${file}")
    text = read.mkString
    read.close
  }

  def writefile(fn: String, text_input: String) {
    val dir = "/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Write and Read File/"
    val writer = new PrintWriter(new File(s"/Users/indraaristya/Documents/Kerja Praktek - NoLimit/WriteReadFiles/files/${fn}.txt" ))
    writer.write(s"${text_input}")
    writer.close()
  }
}