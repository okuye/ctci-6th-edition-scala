package Q7_09_Circular_Array

object Question extends App {
  val size = 10
  val array = new CircularArray[String](size)
  for (i <- 0 until size) {
    array.set(i, i.toString)
  }

  array.rotate(3)
  for (i <- 0 until size) {
    println(array.get(i))
  }

  println()

  array.rotate(2)
  for (s <- array) {
    println(s)
  }
}
