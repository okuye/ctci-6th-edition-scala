package Q17_07_Baby_Names

import scala.collection.mutable

class Graph {
  private val nodes = mutable.ArrayBuffer[GraphNode]()
  private val map = mutable.HashMap[String, GraphNode]()

  def hasNode(name: String): Boolean = map.contains(name)

  def createNode(name: String, freq: Int): GraphNode = {
    if (map.contains(name)) {
      return getNode(name)
    }
    val node = new GraphNode(name, freq)
    nodes += node
    map(name) = node
    node
  }

  private def getNode(name: String): GraphNode = map(name)

  def getNodes: Seq[GraphNode] = nodes.toSeq

  def addEdge(startName: String, endName: String): Unit = {
    val start = getNode(startName)
    val end = getNode(endName)
    if (start != null && end != null) {
      start.addNeighbor(end)
      end.addNeighbor(start)
    }
  }
}
