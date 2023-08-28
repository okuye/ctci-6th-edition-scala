package Q7_06_Jigsaw

class Edge(private var shape: Shape.Shape, private var code: String) {
  private var parentPiece: Piece = _

  def getCode: String = code

  def createMatchingEdge(): Option[Edge] = {
    if (shape == Shape.FLAT) None
    else Some(new Edge(Shape.getOpposite(shape).getOrElse(Shape.FLAT), getCode))
  }

  def fitsWith(edge: Edge): Boolean = {
    edge.getCode == getCode
  }

  def setParentPiece(parentPiece: Piece): Unit = {
    this.parentPiece = parentPiece
  }

  def getParentPiece: Piece = parentPiece

  def getShape: Shape.Shape = shape

  override def toString: String = code
}