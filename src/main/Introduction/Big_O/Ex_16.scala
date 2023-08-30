package Big_O

object Ex_16 {
  def permutation(str: String): Unit = {
    permutation(str, "")
  }

  def permutation(str: String, prefix: String): Unit = {
    if (str.length == 0) {
      println(prefix)
    } else {
      for (i <- 0 until str.length) {
        val rem = str.substring(0, i) + str.substring(i + 1)
        permutation(rem, prefix + str.charAt(i))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    permutation("abc")
  }
}
