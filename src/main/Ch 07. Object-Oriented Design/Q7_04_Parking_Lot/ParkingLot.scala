package Q7_04_Parking_Lot

class ParkingLot {
  private val NUM_LEVELS = 5
  private val levels: Array[Level] = (0 until NUM_LEVELS).map(new Level(_, 30)).toArray

  def parkVehicle(vehicle: Vehicle): Boolean = {
    levels.exists(_.parkVehicle(vehicle))
  }

  def print(): Unit = {
    for (i <- levels.indices) {
      println(s"Level$i: ")
      levels(i).print()
      println()
    }
    println()
  }
}
