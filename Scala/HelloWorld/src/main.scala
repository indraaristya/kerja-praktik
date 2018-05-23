class main(x: String) {
  var y = x.split(" ")
  var a = 0
  var result = 0
  def sum() = for (a<-0 to y.length-1) {
    result += y.apply(a).toInt
  }

  def min() = for (a<-0 to y.length-2) {
    if (a == 1) {
      result += y.apply(a).toInt - y.apply(a + 1).toInt
    } else {
      result -= y.apply(a).toInt
    }
  }

  def multiply() =for (a<-0 to y.length-1) {
    result *= y.apply(a).toInt
  }

  def bagi() = for (a<-0 to y.length-2) {
    if (a == 1) {
      result += y.apply(a).toInt / y.apply(a + 1).toInt
    } else {
      result /= y.apply(a+1).toInt
    }
  }
}


class menu() {
  println("Kalkulator Sederhana")
  println("Masukkan angka dipisahkan spasi")
  println("1. Penjumlahan")
  println("2. Pengurangan")
  println("3. Perkalian")
  println("4. Pembagian")

  private var input = scala.io.StdIn.readInt()

  def returnInput() = input
}

class Person() {
  private var name = ""
  private var age = 0

  def this(nama: String) {
    this()
    this.name = nama
  }

  def this(nama: String, umur: Int) {
    this(nama)
    this.age = umur
  }

  def setName(str: String) = name = str
  def setAge(in: Int) = age = in
  def getName() = name
  def getAge() = age
}

class Student(nama:String, umur:Int, jur: String) extends Person() {
  private var major = jur
  super.setName(nama)
  super.setAge(umur)

  def getKelas() = major
}

case class Book(jdl:String) {
  var judul = jdl
}

class write {
  import java.io._
    def main(args: Array[String]) {
      val writer = new PrintWriter(new File("/Users/indraaristya/Documents/Scala/HelloWorld/test.txt" ))

      writer.write("Hello Scala")
      writer.close()
      print("Done")

  }
}
