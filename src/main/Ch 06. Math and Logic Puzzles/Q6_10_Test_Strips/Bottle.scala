package Q6_10_Test_Strips

class Bottle(val id: Int) {
  private var poisoned = false

  def setAsPoisoned(): Unit = {
    poisoned = true
  }

  def isPoisoned: Boolean = poisoned
}
