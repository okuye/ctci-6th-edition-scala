package Q7_04_Parking_Lot

import scala.util.Random

object Question extends App {
  val lot = new ParkingLot()

  var v: Vehicle = _
  while (v == null || lot.parkVehicle(v)) {
    lot.print()
    val r = Random.nextInt(11)
    v = r match {
      case x if x < 2 => new Bus()
      case x if x < 4 => new Motorcycle()
      case _ => new Car()
    }
    print("\nParking a ")
    v.print()
    println()
  }
  println("Parking Failed. Final state: ")
  lot.print()
}
