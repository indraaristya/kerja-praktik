object main_crawl extends App {
  import play.api.libs.json._

  //menerima input link
  println("Masukkan link sebuah berita (link adalah berita dari Kompas.com)")
  print("Link: ")
  var link = scala.io.StdIn.readLine()
//  print("File Name: ")
//  var file_name = scala.io.StdIn.readLine()
  var file_name = "coba"

  val link1 = "https://tekno.kompas.com/read/2018/05/23/10151737/lazada-komentari-fenomena-ponsel-gaib-di-indonesia"
  val link2 = "https://otomotif.kompas.com/read/2018/05/23/110500715/astra-sangat-serius-mau-terlibat-di-pelabuhan-patimban"
  val link3 = "https://otomotif.kompas.com/read/2018/05/12/082200915/wuling-bersedia-ganti-mesin-euro-4-dengan-catatan."

  val news = new getNews()
  news.getURL(link) //diganti menjadi news.getURL(link) jika ingin memasukkan link inputan

  val js = news.toJSON() //merubah ke json

  news.write(js,file_name) //menulis ke file coba.json

  // membaca file coba.json
//  val news = new getNews()
//  val a = news.readJSON("coba.json","content")
//  print(a)
}
