object main extends App {

  //menerima input link
  var file_name = "coba"
  val newss = new news()
  newss.readLinkfile()
  println(newss.link)

  for (i <- 0 to newss.link.length-1) {
//    println(newss.link.apply(i))
    newss.readLink(newss.link.apply(i))
    val js = newss.toJSON()
    newss.write(js,file_name)
    println("\n")
  }

//  newss.getnews("http://regional.kompas.com/read/2018/05/24/04573511/merapi-kembali-meletus-terdengar-suara-gemuruh-dan-hujan-pasir") //diganti menjadi news.getURL(link) jika ingin memasukkan link inputan
}
