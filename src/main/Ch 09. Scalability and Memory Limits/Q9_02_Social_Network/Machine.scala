package Q9_02_Social_Network

import scala.collection.mutable

class Machine(val machineID: Int) {
  val persons: mutable.HashMap[Int, Person] = mutable.HashMap()

  def getPersonWithID(personID: Int): Option[Person] = persons.get(personID)
}
