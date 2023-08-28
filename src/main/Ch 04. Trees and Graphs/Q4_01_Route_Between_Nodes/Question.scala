package Q4_01_Route_Between_Nodes

import scala.collection.mutable.Queue

object Question extends App {
  import State._

  val g = createNewGraph()
  val n = g.getNodes
  val start = n(3)
  val end = n(5)
  println(search(g, start, end))

  def createNewGraph(): Graph = {
    val g = new Graph()
    val temp = new Array[Node](6)

    temp(0) = new Node("a", 3)
    temp(1) = new Node("b", 0)
    temp(2) = new Node("c", 0)
    temp(3) = new Node("d", 1)
    temp(4) = new Node("e", 1)
    temp(5) = new Node("f", 0)

    temp(0).addAdjacent(temp(1))
    temp(0).addAdjacent(temp(2))
    temp(0).addAdjacent(temp(3))
    temp(3).addAdjacent(temp(4))
    temp(4).addAdjacent(temp(5))
    for (node <- temp) {
      g.addNode(node)
    }
    g
  }

  def search(g: Graph, start: Node, end: Node): Boolean = {
    val q = Queue[Node]()
    for (u <- g.getNodes) {
      u.state = Unvisited
    }
    start.state = Visiting
    q.enqueue(start)
    while (q.nonEmpty) {
      val u = q.dequeue()
      if (u ne null) {
        for (v <- u.getAdjacent) {
          if (v.state == Unvisited) {
            if (v eq end) {
              return true
            } else {
              v.state = Visiting
              q.enqueue(v)
            }
          }
        }
        u.state = Visited
      }
    }
    false
  }
}
