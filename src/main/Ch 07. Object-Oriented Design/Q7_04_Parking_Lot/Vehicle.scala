package Q7_04_Parking_Lot

import scala.collection.mutable.ArrayBuffer

abstract class Vehicle {
  protected val parkingSpots: ArrayBuffer[ParkingSpot] = ArrayBuffer[ParkingSpot]()
  protected var licensePlate: String = _
  var spotsNeeded: Int = _
  protected var size: VehicleSize.Value = _

  def getSpotsNeeded: Int = spotsNeeded

  def getSize: VehicleSize.Value = size

  def parkInSpot(spot: ParkingSpot): Unit = {
    parkingSpots += spot
  }

  def clearSpots(): Unit = {
    parkingSpots.foreach(_.removeVehicle())
    parkingSpots.clear()
  }

  def canFitInSpot(spot: ParkingSpot): Boolean

  def print(): Unit
}
