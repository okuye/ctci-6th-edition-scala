package Q9_02_Social_Network

import scala.collection.mutable

class Server {
  val machines: mutable.HashMap[Int, Machine] = mutable.HashMap()
  val personToMachineMap: mutable.HashMap[Int, Int] = mutable.HashMap()

  def getMachineWithId(machineID: Int): Option[Machine] =
    machines.get(machineID)

  def getMachineIDForUser(personID: Int): Int =
    personToMachineMap.getOrElse(personID, -1)

  def getPersonWithID(personID: Int): Option[Person] = {
    val machineIDOpt = personToMachineMap.get(personID)
    machineIDOpt
      .flatMap(machineID => getMachineWithId(machineID))
      .flatMap(machine => machine.getPersonWithID(personID))
  }
}
