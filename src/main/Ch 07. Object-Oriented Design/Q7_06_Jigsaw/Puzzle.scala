package Q7_06_Jigsaw

import scala.collection.mutable.ListBuffer

class Puzzle(size: Int, pieces: ListBuffer[Piece]) {
  private val solution = Array.ofDim[Piece](size, size)

  def groupPieces(
      cornerPieces: ListBuffer[Piece],
      borderPieces: ListBuffer[Piece],
      insidePieces: ListBuffer[Piece]
  ): Unit = {
    for (p <- pieces) {
      if (p.isCorner) {
        cornerPieces += p
      } else if (p.isBorder) {
        borderPieces += p
      } else {
        insidePieces += p
      }
    }
  }

  def orientTopLeftCorner(piece: Piece): Unit = {
    if (!piece.isCorner) return

    for ((o, i) <- Orientation.values.zipWithIndex) {
      val current = piece.getEdgeWithOrientation(o)
      val next = piece.getEdgeWithOrientation(
        Orientation((i + 1) % Orientation.values.size)
      )
      if (current.getShape == Shape.FLAT && next.getShape == Shape.FLAT) {
        piece.setEdgeAsOrientation(current, Orientation.LEFT)
        return
      }
    }
  }

  def isBorderIndex(location: Int): Boolean = {
    location == 0 || location == size - 1
  }

  private def getMatchingEdge(
      targetEdge: Edge,
      pieces: ListBuffer[Piece]
  ): Option[Edge] = {
    pieces.collectFirst {
      case piece if piece.getMatchingEdge(targetEdge).isDefined =>
        piece.getMatchingEdge(targetEdge).get
    }
  }

  private def setEdgeInSolution(
      pieces: ListBuffer[Piece],
      edge: Edge,
      row: Int,
      column: Int,
      orientation: Orientation.Value
  ): Unit = {
    val piece = edge.getParentPiece
    piece.setEdgeAsOrientation(edge, orientation)
    pieces -= piece
    solution(row)(column) = piece
  }

  private def getPieceListToSearch(
      cornerPieces: ListBuffer[Piece],
      borderPieces: ListBuffer[Piece],
      insidePieces: ListBuffer[Piece],
      row: Int,
      column: Int
  ): ListBuffer[Piece] = {
    if (isBorderIndex(row) && isBorderIndex(column)) {
      cornerPieces
    } else if (isBorderIndex(row) || isBorderIndex(column)) {
      borderPieces
    } else {
      insidePieces
    }
  }

  private def fitNextEdge(
      piecesToSearch: ListBuffer[Piece],
      row: Int,
      column: Int
  ): Boolean = {
    if (row == 0 && column == 0) {
      val p = piecesToSearch.remove(0)
      orientTopLeftCorner(p)
      solution(0)(0) = p
    } else {
      val pieceToMatch =
        if (column == 0) solution(row - 1)(0) else solution(row)(column - 1)
      val orientationToMatch =
        if (column == 0) Orientation.BOTTOM else Orientation.RIGHT
      val edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch)

      val edge = getMatchingEdge(edgeToMatch, piecesToSearch)
      if (edge.isEmpty) return false

      val orientation = Orientation.getOpposite(orientationToMatch).getOrElse(orientationToMatch)

//      val orientation =
//        orientationToMatch.getOpposite.get // assuming getOpposite returns an Option
      setEdgeInSolution(piecesToSearch, edge.get, row, column, orientation)
    }
    true
  }

  def solve(): Boolean = {
    val cornerPieces = ListBuffer[Piece]()
    val borderPieces = ListBuffer[Piece]()
    val insidePieces = ListBuffer[Piece]()
    groupPieces(cornerPieces, borderPieces, insidePieces)

    for (row <- 0 until size; column <- 0 until size) {
      val piecesToSearch = getPieceListToSearch(
        cornerPieces,
        borderPieces,
        insidePieces,
        row,
        column
      )
      if (!fitNextEdge(piecesToSearch, row, column)) {
        return false
      }
    }

    true
  }

  def getCurrentSolution: Array[Array[Piece]] = solution
}
