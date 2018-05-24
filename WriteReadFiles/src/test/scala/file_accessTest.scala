import org.scalatest._
class file_accessTest extends FlatSpec with Matchers {
  "readfile" should "return a same value with " in {
    val accs_file = new file_access
    accs_file.readfile("testWrite.txt")
    val hasil = "Ini adalah text yang dicoba untuk di write"
    (accs_file.text) should be (hasil)
  }
}
