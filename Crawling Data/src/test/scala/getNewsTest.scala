import org.scalatest._
import play.api.libs.json.{JsValue, Json}

class getNewsTest extends FlatSpec {
  "The var" should "be the same with" in {
    val link4 = "https://tekno.kompas.com/read/2018/05/23/17060097/trafik-data-indosat-diprediksi-meningkat-87-persen-saat-lebaran"
    val link1 = "https://tekno.kompas.com/read/2018/05/23/10151737/lazada-komentari-fenomena-ponsel-gaib-di-indonesia"

    val news = new getNews()
    news.getURL(link4)
    assert(news.judul === "Trafik Data Indosat Diprediksi Meningkat 87 Persen saat Lebaran - Kompas.com")
    assert(news.content === "KOMPAS.com - Memasuki masa Ramadhan, mudik dan perayaan Lebaran, Indosat Ooredoo telah menyiapkan kapasitas jaringannya baik untuk data, suara maupun SMS. Untuk kapasitas layanan data ditingkatkan menjadi 11,394 TeraByte/hari, untuk memenuhi puncak kenaikan trafik data yang diprediksi meningkat sebesar 83,7 persen, dibandingkan tahun lalu. Sementara itu, untuk kapasitas suara ditingkatkan menjadi 37,49 juta Erlang/hari dan kapasitas SMS ditingkatkan menjadi 1,01 milyar SMS/hari, dimana kedua kapasitas ini juga sudah disiapkan melampaui dari prediksi trafik tertinggi yang mungkin terjadi. Tidak hanya meningkatkan kapasitas jaringan, kondisi jaringan telekomunikasi juga dipantau selama Ramadhan dan Mudik Lebaran melalui Indosat Ooredoo Network Operation Center (i-NOC) sebagai pusat monitoring seluruh jaringan secara nasional. Monitoring jaringan secara lebih intensif juga dilakukan melalui Command Center yang akan beroperasi beberapa hari sebelum dan sesudah masa Mudik Lebaran. Monitoring itu dilakukan untuk mengidentifikasi secara proaktif melalui tim Performance Monitoring, bahkan sebelum sebuah gangguan berimbas bagi pelanggan, dan secara reaktif melalui tim Customer Service sehingga bila ada kendala dapat diselesaikan sesegera mungkin. ”Indosat Ooredoo berkomitmen memberikan pengalaman terbaik dalam menggunakan situasi apa pun,' ujar Dejan Kastelic, Chief Technology and Information Officer Indosat Ooredoo dalam keterangan tertuis yang diterima KompasTekno, Rabu (23/5/2018). 'Termasuk saat terjadinya kepadatan trafik telekomunikasi selama bulan Ramadhan, mudik Lebaran dan perayaan Lebaran itu sendiri,' imbuhnya. Dalam beberapa bulan terakhir, Indosat Ooredoo juga telah melakukan refarming frekuensi 1800 MHz dan mengaktivasi spektrum baru di kanal 2,1 GHz, untuk mendukung cakupan 4G dan menghadirkan kecepatan lebih di wilayah-wilayah penting.   ")
    assert(news.penulis === "None")
    assert(news.editor === "Reska K. Nistanto")
    assert(news.dates === "23/05/2018")

    val newss = new getNews()
    newss.getURL(link1)
    assert(newss.judul === "Lazada Komentari Fenomena Ponsel Gaib di Indonesia - Kompas.com")
    assert(newss.content === "JAKARTA, KOMPAS.com - Di kalangan warganet Indonesia saat ini beredar istilah ' ponsel gaib', mengacu pada produk smartphone yang sulit diperoleh lantaran stoknya seakan terbatas dan bisa ludes dibeli dalam hitungan detik di sesi penjualan online. Menanggapi fenomena tersebut, pihak Lazada Indonesia selaku e-commerce yang getol menggelar flash sale untuk penjualan ponsel mengatakan, tidak pernah dengan sengaja membatasi stok barang sehingga hanya berjumlah sedikit dan cepat habis. 'Kami tak pernah sengaja membatasi, misalnya hanya dua atau tiga digit. Pasti kami stok ribuan jumlahnya,' ujar CMO Lazada Indonesia Achmad Alkatiri ketika ditemui KompasTekno di sela acara pengumuman program Lazada Puasale di Jakarta, Selasa (22/5/2018). Achmad mengaku tak bisa menguraikan berapa persisnya stok yang disiapkan untuk masing ponsel di gelaran flash sale. Hal tersebut, menurut dia, tergantung dari kesepakatan dengan tiap vendor perangkat rekanan. 'Itu bukan gaib,' tukas Achmad. 'Kami ada banyak stok, tapi kuasa soal berapa banyak stok yang disiapkan untuk hari itu ada di tangan temen-teman brand,' kata Achmad. Algoritma anti-reseller   Achmad mengatakan pihaknya masih belum mengetahui ada atau tidaknya permainan tengkulak tersebut di ajang flash sale. Dia berjanji akan melakukan tindak lanjutnya. Yang jelas, menurut dia, Lazada menerapkan algoritma khusus untuk mencegah skema pemborongan barang oleh pihak-pihak tertentu. Algoritma inilah, lanjut Achmad, yang menyebabkan pembelian sering dibatalkan sepihak (cancel) oleh Lazada, apabila si pembeli bersangkutan terendus hendak memborong. Algoritma Lazada sanggup melacak pembelian oleh orang yang sama. Misalnya, meskipun menggunakan akun berbeda, tapi apabila alamat pengirimannya sama maka akan dianggap sebagai indikasi memborong. 'Yang di-cancel itu biasanya yang order lebih dari satu. Kami ini fokusnya untuk end consumer, bukan reseller. Makanya, kalau ada yang ngomel cancel, itu most likely order lebih dari satu,' tandas Achmad. Baca juga: Dituding Jual Ponsel Gaib di Indonesia, Ini Kata Xiaomi  ")
    assert(newss.penulis === "Oik Yusuf")
    assert(newss.editor === "Reza Wahyudi")
    assert(newss.dates === "23/05/2018")
  }

  "Json file" should "be the same as" in {
    val link4 = "https://tekno.kompas.com/read/2018/05/23/17060097/trafik-data-indosat-diprediksi-meningkat-87-persen-saat-lebaran"
    val link1 = "https://tekno.kompas.com/read/2018/05/23/10151737/lazada-komentari-fenomena-ponsel-gaib-di-indonesia"

    val news = new getNews()
    news.getURL(link4)
    news.toJSON()
    var jsonTest: JsValue = null
    jsonTest = Json.parse(s"""
    {
      "title": "Trafik Data Indosat Diprediksi Meningkat 87 Persen saat Lebaran - Kompas.com",
      "content": "KOMPAS.com - Memasuki masa Ramadhan, mudik dan perayaan Lebaran, Indosat Ooredoo telah menyiapkan kapasitas jaringannya baik untuk data, suara maupun SMS. Untuk kapasitas layanan data ditingkatkan menjadi 11,394 TeraByte/hari, untuk memenuhi puncak kenaikan trafik data yang diprediksi meningkat sebesar 83,7 persen, dibandingkan tahun lalu. Sementara itu, untuk kapasitas suara ditingkatkan menjadi 37,49 juta Erlang/hari dan kapasitas SMS ditingkatkan menjadi 1,01 milyar SMS/hari, dimana kedua kapasitas ini juga sudah disiapkan melampaui dari prediksi trafik tertinggi yang mungkin terjadi. Tidak hanya meningkatkan kapasitas jaringan, kondisi jaringan telekomunikasi juga dipantau selama Ramadhan dan Mudik Lebaran melalui Indosat Ooredoo Network Operation Center (i-NOC) sebagai pusat monitoring seluruh jaringan secara nasional. Monitoring jaringan secara lebih intensif juga dilakukan melalui Command Center yang akan beroperasi beberapa hari sebelum dan sesudah masa Mudik Lebaran. Monitoring itu dilakukan untuk mengidentifikasi secara proaktif melalui tim Performance Monitoring, bahkan sebelum sebuah gangguan berimbas bagi pelanggan, dan secara reaktif melalui tim Customer Service sehingga bila ada kendala dapat diselesaikan sesegera mungkin. ”Indosat Ooredoo berkomitmen memberikan pengalaman terbaik dalam menggunakan situasi apa pun,' ujar Dejan Kastelic, Chief Technology and Information Officer Indosat Ooredoo dalam keterangan tertuis yang diterima KompasTekno, Rabu (23/5/2018). 'Termasuk saat terjadinya kepadatan trafik telekomunikasi selama bulan Ramadhan, mudik Lebaran dan perayaan Lebaran itu sendiri,' imbuhnya. Dalam beberapa bulan terakhir, Indosat Ooredoo juga telah melakukan refarming frekuensi 1800 MHz dan mengaktivasi spektrum baru di kanal 2,1 GHz, untuk mendukung cakupan 4G dan menghadirkan kecepatan lebih di wilayah-wilayah penting.   ",
      "writer": "None",
      "editor": "Reska K. Nistanto",
      "date": "23/05/2018"
    }
    """)
    assert(news.json === jsonTest)

    val newss = new getNews()
    newss.getURL(link1)
    newss.toJSON()
    var jsonTests: JsValue = null
    jsonTests = Json.parse(s"""
    {
      "title": "Lazada Komentari Fenomena Ponsel Gaib di Indonesia - Kompas.com",
      "content": "JAKARTA, KOMPAS.com - Di kalangan warganet Indonesia saat ini beredar istilah ' ponsel gaib', mengacu pada produk smartphone yang sulit diperoleh lantaran stoknya seakan terbatas dan bisa ludes dibeli dalam hitungan detik di sesi penjualan online. Menanggapi fenomena tersebut, pihak Lazada Indonesia selaku e-commerce yang getol menggelar flash sale untuk penjualan ponsel mengatakan, tidak pernah dengan sengaja membatasi stok barang sehingga hanya berjumlah sedikit dan cepat habis. 'Kami tak pernah sengaja membatasi, misalnya hanya dua atau tiga digit. Pasti kami stok ribuan jumlahnya,' ujar CMO Lazada Indonesia Achmad Alkatiri ketika ditemui KompasTekno di sela acara pengumuman program Lazada Puasale di Jakarta, Selasa (22/5/2018). Achmad mengaku tak bisa menguraikan berapa persisnya stok yang disiapkan untuk masing ponsel di gelaran flash sale. Hal tersebut, menurut dia, tergantung dari kesepakatan dengan tiap vendor perangkat rekanan. 'Itu bukan gaib,' tukas Achmad. 'Kami ada banyak stok, tapi kuasa soal berapa banyak stok yang disiapkan untuk hari itu ada di tangan temen-teman brand,' kata Achmad. Algoritma anti-reseller   Achmad mengatakan pihaknya masih belum mengetahui ada atau tidaknya permainan tengkulak tersebut di ajang flash sale. Dia berjanji akan melakukan tindak lanjutnya. Yang jelas, menurut dia, Lazada menerapkan algoritma khusus untuk mencegah skema pemborongan barang oleh pihak-pihak tertentu. Algoritma inilah, lanjut Achmad, yang menyebabkan pembelian sering dibatalkan sepihak (cancel) oleh Lazada, apabila si pembeli bersangkutan terendus hendak memborong. Algoritma Lazada sanggup melacak pembelian oleh orang yang sama. Misalnya, meskipun menggunakan akun berbeda, tapi apabila alamat pengirimannya sama maka akan dianggap sebagai indikasi memborong. 'Yang di-cancel itu biasanya yang order lebih dari satu. Kami ini fokusnya untuk end consumer, bukan reseller. Makanya, kalau ada yang ngomel cancel, itu most likely order lebih dari satu,' tandas Achmad. Baca juga: Dituding Jual Ponsel Gaib di Indonesia, Ini Kata Xiaomi  ",
      "writer": "Oik Yusuf",
      "editor": "Reza Wahyudi",
      "date": "23/05/2018"
    }
    """)
    assert(newss.json === jsonTests)
  }
}
