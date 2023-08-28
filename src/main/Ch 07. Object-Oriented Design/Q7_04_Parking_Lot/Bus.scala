package Q7_04_Parking_Lot

class Bus extends Vehicle {
  spotsNeeded = 5
  size = VehicleSize.Large

  def canFitInSpot(spot: ParkingSpot): Boolean = {
    spot.getSize == VehicleSize.Large
  }

  def print(): Unit = {
    println("B")
  }
}
