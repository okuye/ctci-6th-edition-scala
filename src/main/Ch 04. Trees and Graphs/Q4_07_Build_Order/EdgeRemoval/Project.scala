package Q4_07_Build_Order.EdgeRemoval

import scala.collection.mutable.{ArrayBuffer, HashMap}

class Project(n: String) {
  private val children = ArrayBuffer[Project]()
  private val map = HashMap[String, Project]()
  private val name = n
  private var dependencies = 0

  def getName: String = name

  def addNeighbor(node: Project): Unit = {
    if (!map.contains(node.getName)) {
      children += node
      map(node.getName) = node
      node.incrementDependencies()
    }
  }

  def incrementDependencies(): Unit = {
    dependencies += 1
  }

  def getChildren: ArrayBuffer[Project] = children

  def decrementDependencies(): Unit = {
    dependencies -= 1
  }

  def getNumberDependencies: Int = dependencies
}
