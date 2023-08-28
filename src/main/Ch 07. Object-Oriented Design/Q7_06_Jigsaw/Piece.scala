package Q7_06_Jigsaw

import scala.collection.mutable

class Piece(edgeList: Array[Edge]) {
  private val NUMBER_OF_EDGES = 4
  private val edges = mutable.Map[Orientation.Value, Edge]()

  for ((edge, orientation) <- edgeList.zip(Orientation.values)) {
    edge.setParentPiece(this)
    edges(orientation) = edge
  }

  def setEdgeAsOrientation(edge: Edge, orientation: Orientation.Value): Unit = {
    val currentOrientation = getOrientation(edge)
    rotateEdgesBy(orientation.id - currentOrientation.id)
  }

  private def getOrientation(edge: Edge): Orientation.Value = {
    edges.find(_._2 == edge).map(_._1).getOrElse(null)
  }

  def rotateEdgesBy(numberRotations: Int): Unit = {
    val rotated = mutable.Map[Orientation.Value, Edge]()
    val adjustedRotations = (numberRotations % NUMBER_OF_EDGES + NUMBER_OF_EDGES) % NUMBER_OF_EDGES

    for (orientation <- Orientation.values) {
      val oldOrientation = Orientation((orientation.id - adjustedRotations + NUMBER_OF_EDGES) % NUMBER_OF_EDGES)
      rotated(orientation) = edges(oldOrientation)
    }

    edges.clear()
    edges ++= rotated
  }

  def isCorner: Boolean = {
    Orientation.values.exists(o =>
      edges(o).getShape == Shape.FLAT && edges(Orientation((o.id + 1) % NUMBER_OF_EDGES)).getShape == Shape.FLAT
    )
  }

  def isBorder: Boolean = {
    Orientation.values.exists(o => edges(o).getShape == Shape.FLAT)
  }

  def getEdgeWithOrientation(orientation: Orientation.Value): Edge = {
    edges(orientation)
  }

  def getMatchingEdge(targetEdge: Edge): Option[Edge] = {
    edges.values.find(e => targetEdge.fitsWith(e))
  }

  override def toString: String = {
    val sb = new StringBuilder
    for (o <- Orientation.values) {
      sb.append(edges(o).toString + ",")
    }
    s"[$sb]"
  }
}
