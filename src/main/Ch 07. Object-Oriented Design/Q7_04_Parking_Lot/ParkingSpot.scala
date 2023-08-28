package Q7_04_Parking_Lot

class ParkingSpot(private val level: Level, private val row: Int, private val spotNumber: Int, private val spotSize: VehicleSize.Value) {
  private var vehicle: Option[Vehicle] = None

  def isAvailable: Boolean = vehicle.isEmpty

  def canFitVehicle(v: Vehicle): Boolean = isAvailable && v.canFitInSpot(this)

  def park(v: Vehicle): Boolean = {
    if (!canFitVehicle(v)) return false
    vehicle = Some(v)
    v.parkInSpot(this)
    true
  }

  def getRow: Int = row

  def getSpotNumber: Int = spotNumber

  def getSize: VehicleSize.Value = spotSize

  def removeVehicle(): Unit = {
    level.spotFreed()
    vehicle = None
  }

  def print(): Unit = {
    vehicle match {
      case Some(v) => v.print()
      case None => spotSize match {
        case VehicleSize.Compact => println("c")
        case VehicleSize.Large => println("l")
        case VehicleSize.Motorcycle => println("m")
      }
    }
  }
}
