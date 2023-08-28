package Q4_01_Route_Between_Nodes

class Graph {
  val MAX_VERTICES = 6
  private val vertices = new Array[Node](MAX_VERTICES)
  private var count = 0

  def addNode(x: Node): Unit = {
    if (count < vertices.length) {
      vertices(count) = x
      count += 1
    } else {
      println("Graph full")
    }
  }

  def getNodes: Array[Node] = vertices
}
