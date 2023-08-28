package Q7_04_Parking_Lot

class Car extends Vehicle {
  spotsNeeded = 1
  size = VehicleSize.Compact

  def canFitInSpot(spot: ParkingSpot): Boolean = {
    spot.getSize == VehicleSize.Large || spot.getSize == VehicleSize.Compact
  }

  def print(): Unit = {
    println("C")
  }
}
