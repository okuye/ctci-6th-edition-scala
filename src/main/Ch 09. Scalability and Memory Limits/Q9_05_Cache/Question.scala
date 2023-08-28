package Q9_05_Cache

object Question {

  def generateResults(i: Int): Array[String] = {
    Array(s"resultA$i", s"resultB$i", s"resultC$i")
  }

  def main(args: Array[String]): Unit = {
    val cache = new Cache()

    for (i <- 0 until 20) {
      val query = s"query$i"
      cache.insertResults(query, generateResults(i))

      if (i == 9 || i == 16 || i == 19) {
        cache.getResults("query2")
        cache.getResults("query6")
        cache.getResults("query9")
      }
    }

    for (i <- 0 until 30) {
      val query = s"query$i"
      val results = cache.getResults(query)
      print(s"$query: ")

      if (results == null) {
        print("null")
      } else {
        results.foreach(result => print(s"$result, "))
      }

      println()
    }
  }
}
