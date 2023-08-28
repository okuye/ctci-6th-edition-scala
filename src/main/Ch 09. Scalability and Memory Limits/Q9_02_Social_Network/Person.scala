package Q9_02_Social_Network

import scala.collection.mutable.ArrayBuffer

class Person(val personID: Int) {
  private val friends = ArrayBuffer[Int]()
  private var info: String = _

  def getInfo: String = info

  def setInfo(info: String): Unit = {
    this.info = info
  }

  def getFriends: ArrayBuffer[Int] = friends

  def getID: Int = personID

  def addFriend(id: Int): Unit = {
    friends += id
  }
}
