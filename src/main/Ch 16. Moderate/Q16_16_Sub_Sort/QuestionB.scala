package Q16_16_Sub_Sort

object QuestionB {

  def findRightSequenceStart(array: Array[Int]): Int = {
    var max = Int.MinValue
    var lastNo = 0
    for (i <- array.indices) {
      if (max > array(i)) {
        lastNo = i
      }
      max = Math.max(array(i), max)
    }
    lastNo
  }

  def findLeftSequenceEnd(array: Array[Int]): Int = {
    var min = Int.MaxValue
    var lastNo = 0
    for (i <- array.indices.reverse) {
      if (min < array(i)) {
        lastNo = i
      }
      min = Math.min(array(i), min)
    }
    lastNo
  }

  def findUnsortedSequence(array: Array[Int]): Range = {
    val leftSequenceEnd = findRightSequenceStart(array)
    val rightSequenceEnd = findLeftSequenceEnd(array)
    Range(leftSequenceEnd, rightSequenceEnd)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19)
    val r = findUnsortedSequence(array)
    println(r.toString)
    println(s"${array(r.start)}, ${array(r.end)}")
  }
}
