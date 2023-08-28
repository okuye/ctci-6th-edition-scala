package Q3_06_Animal_Shelter

abstract class Animal(n: String) {
  private var order: Int = _
  protected val _name: String = n

  def name1(): String

  def setOrder(ord: Int): Unit = {
    order = ord
  }

  def getOrder: Int = order

  def isOlderThan(a: Animal): Boolean = this.order < a.getOrder
}
