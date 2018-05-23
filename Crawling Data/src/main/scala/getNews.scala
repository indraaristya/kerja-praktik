import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements

class getNews {
  import net.ruippeixotog.scalascraper.browser.JsoupBrowser
  import net.ruippeixotog.scalascraper.dsl.DSL._
  import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
  import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
  import play.api.libs.json._
  import play.api.libs.json.Reads._
  import play.api.libs.functional.syntax._
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

  def getURL(url: String): Unit = {

    val browser = JsoupBrowser()
    val doc2 = browser.get(s"${url}")

    judul = doc2 >> text("title")
    println(judul)

    val p = doc2 >> texts("p")
    content  = p.mkString(" ")
    content = content.replaceAll("\"","")
    println(content)

    penulis = doc2 >> text("#penulis")
    penulis = penulis.drop(7)
    println(penulis)

    editor = doc2 >> text("#editor")
    editor = editor.drop(6)
    println(editor)

    dates = doc2 >> attr("content")("meta[name=content_PublishedDate]")
    var inputDates = inputDate.parse(dates)
    dates = dateFormat.format(inputDates)
    print(dates)

//    var a = doc2 >> text("article__date")
//    print(a)

  }

  def write(json: JsValue, fn: String): Unit = {
    val writer = new PrintWriter(new File(s"/Users/indraaristya/Documents/KP - NoLimit/Crawling Data/json/${fn}.json" ))
//    val writer = new PrintWriter(new FileOutputStream(new File(s"/Users/indraaristya/Documents/KP - NoLimit/Crawling Data/json/${fn}.json"),true))
    writer.write(s"${json},\n")
    writer.close()
  }

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

  def readJSON(name: String): JsValue = {
    val dir = "/Users/indraaristya/Documents/KP - NoLimit/Crawling Data/json/"
    val stream = Source.fromFile(s"${dir}${name}").getLines.mkString
    val lat = Json.parse(stream)
    return lat
  }

  def readJSON(name: String,bagian: String): JsValue = {
    val dir = "/Users/indraaristya/Documents/KP - NoLimit/Crawling Data/json/"
    val stream = Source.fromFile(s"${dir}${name}").getLines.mkString
    val lat = Json.parse(stream)
    val hasil = (lat \ s"${bagian}").get
    return lat
  }
}
