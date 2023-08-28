package Q7_04_Parking_Lot

class Motorcycle extends Vehicle {
  spotsNeeded = 1
  size = VehicleSize.Motorcycle

  def canFitInSpot(spot: ParkingSpot): Boolean = true

  def print(): Unit = {
    println("M")
  }
}
