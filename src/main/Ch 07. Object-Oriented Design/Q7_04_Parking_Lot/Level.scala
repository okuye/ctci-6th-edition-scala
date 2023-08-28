package Q7_04_Parking_Lot

class Level(flr: Int, numberSpots: Int) {
  private val floor: Int = flr
  private val spots: Array[ParkingSpot] = new Array[ParkingSpot](numberSpots)
  private var _availableSpots: Int = 0
  private val SPOTS_PER_ROW = 10

  {
    val largeSpots = numberSpots / 4
    val bikeSpots = numberSpots / 4
    val compactSpots = numberSpots - largeSpots - bikeSpots
    for (i <- 0 until numberSpots) {
      val sz = if (i < largeSpots) {
        VehicleSize.Large
      } else if (i < largeSpots + compactSpots) {
        VehicleSize.Compact
      } else {
        VehicleSize.Motorcycle
      }
      val row = i / SPOTS_PER_ROW
      spots(i) = new ParkingSpot(this, row, i, sz)
    }
    _availableSpots = numberSpots
  }

  def availableSpots(): Int = _availableSpots

  def parkVehicle(vehicle: Vehicle): Boolean = {
    if (availableSpots() < vehicle.spotsNeeded) {
      return false
    }
    val spotNumber = findAvailableSpots(vehicle)
    if (spotNumber < 0) {
      return false
    }
    parkStartingAtSpot(spotNumber, vehicle)
  }

  private def parkStartingAtSpot(spotNumber: Int, vehicle: Vehicle): Boolean = {
    vehicle.clearSpots()
    var success = true
    for (i <- spotNumber until spotNumber + vehicle.spotsNeeded) {
      success &= spots(i).park(vehicle)
    }
    availableSpots -= vehicle.spotsNeeded
    success
  }

  private def findAvailableSpots(vehicle: Vehicle): Int = {
    val spotsNeeded = vehicle.spotsNeeded
    var lastRow = -1
    var spotsFound = 0
    for (i <- spots.indices) {
      val spot = spots(i)
      if (lastRow != spot.getRow) {
        spotsFound = 0
        lastRow = spot.getRow
      }
      if (spot.canFitVehicle(vehicle)) {
        spotsFound += 1
      } else {
        spotsFound = 0
      }
      if (spotsFound == spotsNeeded) {
        return i - (spotsNeeded - 1)
      }
    }
    -1
  }

  def print(): Unit = {
    var lastRow = -1
    for (i <- spots.indices) {
      val spot = spots(i)
      if (spot.getRow != lastRow) {
        println("  ")
        lastRow = spot.getRow
      }
      spot.print()
    }
  }

  def spotFreed(): Unit = {
    availableSpots += 1
  }
}
