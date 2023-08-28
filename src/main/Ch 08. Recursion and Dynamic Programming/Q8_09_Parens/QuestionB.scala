package Q8_09_Parens

object QuestionB {

  def addParen(
      list: scala.collection.mutable.ListBuffer[String],
      leftRem: Int,
      rightRem: Int,
      str: Array[Char],
      index: Int
  ): Unit = {
    if (leftRem < 0 || rightRem < leftRem) return // invalid state

    if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
      list += new String(str)
    } else {
      str(index) = '(' // Add left and recurse
      addParen(list, leftRem - 1, rightRem, str, index + 1)

      str(index) = ')' // Add right and recurse
      addParen(list, leftRem, rightRem - 1, str, index + 1)
    }
  }

  def generateParens(count: Int): Seq[String] = {
    val str = new Array[Char](count * 2)
    val list = scala.collection.mutable.ListBuffer[String]()
    addParen(list, count, count, str, 0)
    list.toList
  }

  def main(args: Array[String]): Unit = {
    val list = generateParens(6)
    list.foreach(println)
    println(list.size)
  }
}
