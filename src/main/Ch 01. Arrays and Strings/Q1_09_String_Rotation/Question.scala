package Q1_09_String_Rotation

object Question {

  def isSubstring(big: String, small: String): Boolean = {
    big.contains(small)
  }

  def isRotation(s1: String, s2: String): Boolean = {
    val len = s1.length
    if (len == s2.length && len > 0) {
      val s1s1 = s1 + s1
      isSubstring(s1s1, s2)
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val pairs = Array(
      ("apple", "pleap"),
      ("waterbottle", "erbottlewat"),
      ("camera", "macera")
    )
    for (pair <- pairs) {
      val word1 = pair._1
      val word2 = pair._2
      val is_rotation = isRotation(word1, word2)
      println(s"$word1, $word2: $is_rotation")
    }
  }
}
