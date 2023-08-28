package Q15_07_FizzBuzz

class NumberThread(div3: Boolean, div5: Boolean, max: Int)
  extends FizzBuzzThread(div3, div5, max, null) {

  override def print(): Unit = {
    println(getCurrent) // Use the getter method to access current
  }
}
