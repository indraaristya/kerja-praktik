import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements

import scala.collection.mutable.ArrayBuffer

class news {
  import net.ruippeixotog.scalascraper.browser.JsoupBrowser
  import net.ruippeixotog.scalascraper.dsl.DSL._
  import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
  import play.api.libs.json._
  import java.io._
  import scala.io.Source
  import java.text.SimpleDateFormat
  var inputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  var dateFormat = new SimpleDateFormat("dd/MM/yyyy")


  var judul: String = ""
  var content: String = ""
  var penulis: String = ""
  var editor: String = ""
  var json: JsValue = null
  var dates: String = ""
  var date = new SimpleDateFormat("dd/MM/yyyy")
  var link = ArrayBuffer[String]()

  // fungsi untuk mengambil informasi judul, isi, penulis, editor dan tanggal dari link sebuah berita di Kompas.com
  def getnews(url: String): Unit = {
//    val browser = JsoupBrowser()
//    val doc2 = browser.get(s"${url}")
//
////    val p  = doc2 >> extractor("h4", elements)
//    var p = doc2 >> "h4"
//    for (line <- p) println(line.innerHtml)


    import org.jsoup.Jsoup
    val browser = Jsoup.connect(url).get()
    var link = browser.select("a[class]").attr("class","box-shadow-new").attr("class","left ListCol1 ").html("h3").html("href")
    link = link.attr("target","_parent")
    link.forEach((s) => println(s))
  }

  // fungsi untuk menulis json ke file coba.json di folder json
  def write(json: JsValue, fn: String): Unit = {
    //    val writer = new PrintWriter(new File(s"/Users/indraaristya/Documents/KP - NoLimit/Crawling Data/json/${fn}.json" ))
    val writer = new PrintWriter(new FileOutputStream(new File(s"/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Crawling Data_All/files/${fn}.json"),true))
    writer.write(s"${json},\n")
    writer.close()
  }

  // fungsi untuk mengkonversi/merubah informasi yang didapat menjadi bentuk json
  def toJSON():JsValue = {
    json = Json.parse(s"""
    {
      "title": "${judul}",
      "content": "${content}",
      "writer": "${penulis}",
      "editor": "${editor}",
      "date": "${dates}"
    }
    """)
    return json
  }

  // fungsi untuk membaca isi dari file coba.json
  def readJSON(name: String,bagian: String): JsValue = {
    val dir = "/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Crawling Data_All/files/"
    val stream = Source.fromFile(s"${dir}${name}").getLines.mkString
    val lat = Json.parse(stream)
    val hasil = (lat \ s"${bagian}").get
    return lat
  }

  def readLink(url: String): Unit = {
    val browser = JsoupBrowser()
    val doc2 = browser.get(s"${url}")

    if (doc2.toString.contains("title")) {
      judul = doc2 >> text("title")
      judul = judul.replaceAll("\"", "'")
      println(judul)
    } else {
      judul = "None"
    }

    if (doc2.toString.contains("p")) {
      val p = doc2 >> texts("p")
      content = p.mkString(" ")
      content = content.replaceAll("\"", "'")
      println(content)
    } else {
      content = "None"
    }
    if (doc2.toString.contains("penulis")) {
      penulis = doc2 >> text("#penulis")
      penulis = penulis.drop(7)
      println(penulis)
    } else {
      penulis = "None"
    }

    if (doc2.toString.contains("editor")) {
      editor = doc2 >> text("#editor")
      editor = editor.drop(6)
      println(editor)
    } else {
      editor = "None"
    }

//    if (doc2.toString.contains("meta name='content_PublishedDate'")) {
    dates = doc2 >> attr("content")("meta[name=content_PublishedDate]")
    var inputDates = inputDate.parse(dates)
    dates = dateFormat.format(inputDates)
    print(dates)

  }

  def readLinkfile() {
    var file = "link.txt"
    val dir = "/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Crawling Data_All/files/"
    val read = Source.fromFile(s"${dir}${file}")
    for (line <- read.getLines) {
      link += line
    }
    read.close
  }
}
