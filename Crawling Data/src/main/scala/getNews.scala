import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements

class getNews {
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

  // fungsi untuk mengambil informasi judul, isi, penulis, editor dan tanggal dari link sebuah berita di Kompas.com
  def getURL(url: String): Unit = {
    val browser = JsoupBrowser()
    val doc2 = browser.get(s"${url}")

    judul = doc2 >> text("title")
    judul = judul.replaceAll("\"","'")
//    println(judul)

    val p = doc2 >> texts("p")
    content  = p.mkString(" ")
    content = content.replaceAll("\"","'")
//    println(content)

    if (doc2.toString.contains("penulis")) {
      penulis = doc2 >> text("#penulis")
      penulis = penulis.drop(7)
    } else {
      penulis = "None"
    }
//    println(penulis)

    if (doc2.toString.contains("editor")) {
      editor = doc2 >> text("#editor")
      editor = editor.drop(6)
    } else {
      editor = "None"
    }
//    println(editor)

    dates = doc2 >> attr("content")("meta[name=content_PublishedDate]")
    var inputDates = inputDate.parse(dates)
    dates = dateFormat.format(inputDates)
//    print(dates)
  }

  // fungsi untuk menulis json ke file coba.json di folder json
  def write(json: JsValue, fn: String): Unit = {
//    val writer = new PrintWriter(new File(s"/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Crawling Data/json/${fn}.json" ))
    val writer = new PrintWriter(new FileOutputStream(new File(s"/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Crawling Data/json/${fn}.json"),true))
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
    val dir = "/Users/indraaristya/Documents/Kerja Praktek - NoLimit/Crawling Data/json/"
    val stream = Source.fromFile(s"${dir}${name}").getLines.mkString
    val lat = Json.parse(stream)
    val hasil = (lat \ s"${bagian}").get
    return lat
  }
}
