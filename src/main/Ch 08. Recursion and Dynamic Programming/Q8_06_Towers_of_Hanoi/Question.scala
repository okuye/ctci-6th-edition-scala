package Q8_06_Towers_of_Hanoi

object Question {
  def main(args: Array[String]): Unit = {
    val source = new Tower("s")
    val destination = new Tower("d")
    val buffer = new Tower("b")

    // Load up tower
    val numberOfDisks = 5
    for (disk <- numberOfDisks - 1 to 0 by -1) {
      source.add(disk)
    }

    source.print()
    source.moveDisks(numberOfDisks, destination, buffer)
    destination.print()
  }
}
