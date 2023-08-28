package Q1_06_String_Compression

object Tester {

  def main(args: Array[String]): Unit = {
    val str = "aaaaabbbbaaaabbddc"
    println(str)
    println(QuestionA.compressBad(str))
    println(QuestionB.compress(str))
    println(QuestionC.compress(str))
  }

}
