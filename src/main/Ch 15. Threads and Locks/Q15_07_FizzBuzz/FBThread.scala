package Q15_07_FizzBuzz

class FBThread(validate: Int => Boolean, printer: Int => String, max: Int) extends Thread {

  import FBThread._

  override def run(): Unit = {
    while (true) {
      lock.synchronized {
        if (current > max) {
          return
        }
        if (validate(current)) {
          println(printer(current))
          current += 1
        }
      }
    }
  }
}

object FBThread {
  private val lock = new Object
  private var current = 1
}
