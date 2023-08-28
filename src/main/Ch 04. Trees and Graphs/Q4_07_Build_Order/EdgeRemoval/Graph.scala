package Q4_07_Build_Order.EdgeRemoval

import scala.collection.mutable.{ArrayBuffer, HashMap}

class Graph {
  private val nodes = ArrayBuffer[Project]()
  private val map = HashMap[String, Project]()

  def getOrCreateNode(name: String): Project = {
    if (!map.contains(name)) {
      val node = new Project(name)
      nodes += node
      map(name) = node
    }
    map(name)
  }

  def addEdge(startName: String, endName: String): Unit = {
    val start = getOrCreateNode(startName)
    val end = getOrCreateNode(endName)
    start.addNeighbor(end)
  }

  def getNodes: ArrayBuffer[Project] = nodes
}
