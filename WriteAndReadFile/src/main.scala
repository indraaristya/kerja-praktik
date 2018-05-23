import scala.collection.mutable.ArrayBuffer

object main extends App {
  // Code untuk Read file
  println("Masukkan nama file beserta ekstensinya")
  println("Contoh: test.txt, test.csv \n")
  // File yang bisa di baca adalah file yang ada di folder files
  print("Nama File: ")
  var file_name = scala.io.StdIn.readLine()

  val file_class = new file_access()
  file_class.readfile(file_name)


  // Code untuk Write to file txt
  //  print("File name: ")
  //  val fn = scala.io.StdIn.readLine()
  //  val text = scala.io.StdIn.readLine()
  //  file_class.writefile(fn,text)

}
