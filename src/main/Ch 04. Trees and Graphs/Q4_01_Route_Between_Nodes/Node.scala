package Q4_01_Route_Between_Nodes

object State extends Enumeration {
  type StateType = Value
  val Unvisited, Visited, Visiting = Value
}

class Node(vertex: String, adjacentLength: Int) {
  import State._

  private val adjacent = new Array[Node](adjacentLength)
  var adjacentCount: Int = 0
  var state: StateType = _

  def addAdjacent(x: Node): Unit = {
    if (adjacentCount < adjacent.length) {
      adjacent(adjacentCount) = x
      adjacentCount += 1
    } else {
      println("No more adjacent can be added")
    }
  }

  def getAdjacent: Array[Node] = adjacent

  def getVertex: String = vertex
}
