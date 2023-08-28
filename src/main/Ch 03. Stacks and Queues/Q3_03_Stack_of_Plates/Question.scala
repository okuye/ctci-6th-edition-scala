package Q3_03_Stack_of_Plates

object Question {
  def main(args: Array[String]): Unit = {
    val capacityPerSubstack = 5
    val set = new SetOfStacks(capacityPerSubstack)
    for (i <- 0 until 34) {
      set.push(i)
    }
    for (_ <- 0 until 35) {
      println(s"Popped ${set.pop()}")
    }
  }
}
