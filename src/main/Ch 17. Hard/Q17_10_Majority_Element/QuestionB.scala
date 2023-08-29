package Q17_10_Majority_Element

object QuestionB {

  def getCandidate(array: Array[Int]): Int = {
    var majority = 0
    var count = 0
    for (n <- array) {
      if (count == 0) {
        majority = n
      }
      if (n == majority) {
        count += 1
      } else {
        count -= 1
      }
    }
    majority
  }

  def validate(array: Array[Int], majority: Int): Boolean = {
    val count = array.count(_ == majority)
    count > array.length / 2
  }

  def findMajorityElement(array: Array[Int]): Int = {
    val candidate = getCandidate(array)
    if (validate(array, candidate)) candidate else -1
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1)
    println(array.length)
    println(findMajorityElement(array))
  }

}
