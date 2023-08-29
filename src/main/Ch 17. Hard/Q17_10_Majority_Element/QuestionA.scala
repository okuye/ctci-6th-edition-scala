package Q17_10_Majority_Element

object QuestionA {

  def validate(array: Array[Int], majority: Int): Boolean = {
    val count = array.count(_ == majority)
    count > array.length / 2
  }

  def findMajorityElement(array: Array[Int]): Int = {
    array.find(x => validate(array, x)).getOrElse(-1)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1)
    println(array.length)
    println(findMajorityElement(array))
  }

}
