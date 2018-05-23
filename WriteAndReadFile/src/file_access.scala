class file_access() {
  import scala.io.Source
  import java.io._

  def readfile(file: String) {
    val dir = "/Users/indraaristya/Documents/KP - NoLimit/WriteAndReadFile/files/"
    val read = Source.fromFile(s"${dir}${file}")
    for (line <- read.getLines) {
      println(line)
    }
    read.close
  }

  def writefile(fn: String, text_input: String) {
    val dir = "/Users/indraaristya/Documents/KP - NoLimit/T1/src/"
    val writer = new PrintWriter(new File(s"/Users/indraaristya/Documents/KP - NoLimit/WriteAndReadFile/files/${fn}.txt" ))
    writer.write(s"${text_input}")
    writer.close()
  }
}