package Q15_07_FizzBuzz

//class FizzBuzzThread(div3: Boolean, div5: Boolean, max: Int, toPrint: String) extends Thread {
class FizzBuzzThread(div3: Boolean, div5: Boolean, max: Int, toPrint: String)
  extends Thread {
  import FizzBuzzThread._

  protected def getCurrent: Int = {
    current
  }

  def print(): Unit = {
    println(toPrint)
  }

  override def run(): Unit = {
    while (true) {
      lock.synchronized {
        if (current > max) {
          return
        }
        if ((current % 3 == 0) == div3 && (current % 5 == 0) == div5) {
          print()
          current += 1
        }
      }
    }
  }
}

object FizzBuzzThread {
  private val lock = new Object
  private var current = 1
}
