package Q4_07_Build_Order.DFS

import scala.collection.mutable

class Graph {
  private val nodes = mutable.ArrayBuffer[Project]()
  private val map = mutable.HashMap[String, Project]()

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

  def getNodes: Seq[Project] = nodes.toSeq
}