package Q17_07_Baby_Names

import scala.collection.mutable

class GraphNode(val name: String, var frequency: Int) {
  private val neighbors = mutable.ArrayBuffer[GraphNode]()
  private val map = mutable.HashMap[String, GraphNode]()
  private var visited = false

  def getFrequency: Int = frequency

  def addNeighbor(node: GraphNode): Boolean = {
    if (map.contains(node.name)) {
      return false
    }
    neighbors += node
    map(node.name) = node
    true
  }

  def getNeighbors: Seq[GraphNode] = neighbors.toSeq


  def isVisited: Boolean = visited

  def setIsVisited(v: Boolean): Unit = {
    visited = v
  }
}
