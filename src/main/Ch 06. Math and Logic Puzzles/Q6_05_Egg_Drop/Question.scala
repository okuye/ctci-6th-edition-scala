package Q6_05_Egg_Drop

object Question {
  var breakingPoint = 89
  var countDrops = 0

  def willBreak(floor: Int): Boolean = {
    countDrops += 1
    floor >= breakingPoint
  }

  def findBreakingPoint(floors: Int): Int = {
    var interval = 14
    var previousFloor = 0
    var egg1 = interval

    // Drop egg1 at decreasing intervals.
    while (!willBreak(egg1) && egg1 <= floors) {
      interval -= 1
      previousFloor = egg1
      egg1 += interval
    }

    // Drop egg2 at 1 unit increments.
    var egg2 = previousFloor + 1
    while (egg2 < egg1 && egg2 <= floors && !willBreak(egg2)) {
      egg2 += 1
    }

    // If it didn’t break, return -1.
    if (egg2 > floors) -1 else egg2
  }

  def main(args: Array[String]): Unit = {
    var max = 0
    for (i <- 1 to 100) {
      countDrops = 0
      breakingPoint = i
      val bp = findBreakingPoint(100)

      if (bp == breakingPoint) {
        println(s"SUCCESS: $i -> $bp -> $countDrops")
      } else {
        println(s"ERROR: $i -> $bp vs $breakingPoint")
        return
      }
      max = Math.max(countDrops, max)
    }
    println(max)
  }
}
