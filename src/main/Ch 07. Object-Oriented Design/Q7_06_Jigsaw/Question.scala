package Q7_06_Jigsaw

import scala.collection.mutable
import scala.util.Random

object Question {

  def createRandomEdge(code: String): Edge = {
    val random = new Random()
    val shape = if (random.nextBoolean()) Shape.OUTER else Shape.INNER
    new Edge(shape, code)
  }

  def createEdges(puzzle: Array[Array[Piece]], column: Int, row: Int): Array[Edge] = {
    val key = s"$column:$row:"
    val left = if (column == 0) new Edge(Shape.FLAT, s"$key|h|e") else puzzle(row)(column - 1).getEdgeWithOrientation(Orientation.RIGHT).createMatchingEdge().get
    val top = if (row == 0) new Edge(Shape.FLAT, s"$key|v|e") else puzzle(row - 1)(column).getEdgeWithOrientation(Orientation.BOTTOM).createMatchingEdge().get
    val right = if (column == puzzle(row).length - 1) new Edge(Shape.FLAT, s"$key|h|e") else createRandomEdge(s"$key|h")
    val bottom = if (row == puzzle.length - 1) new Edge(Shape.FLAT, s"$key|v|e") else createRandomEdge(s"$key|v")
    Array(left, top, right, bottom)
  }

  def initializePuzzle(size: Int): mutable.ListBuffer[Piece] = {
    val puzzle = Array.ofDim[Piece](size, size)
    for (row <- 0 until size; column <- 0 until size) {
      val edges = createEdges(puzzle, column, row)
      puzzle(row)(column) = new Piece(edges)
    }

    val pieces = mutable.ListBuffer[Piece]()
    val r = new Random()
    for (row <- 0 until size; column <- 0 until size) {
      val rotations = r.nextInt(4)
      val piece = puzzle(row)(column)
      piece.rotateEdgesBy(rotations)
      val index = if (pieces.isEmpty) 0 else r.nextInt(pieces.length)
      pieces.insert(index, piece)
    }

    pieces
  }

  def solutionToString(solution: Array[Array[Piece]]): String = {
    solution.map(row => row.map {
      case null => "null"
      case piece => piece.toString
    }.mkString).mkString("\n")
  }

  def validate(solution: Array[Array[Piece]]): Boolean = {
    if (solution == null) return false
    for (r <- solution.indices; c <- solution(r).indices) {
      val piece = solution(r)(c)
      if (piece == null) return false
      if (c > 0 && !solution(r)(c - 1).getEdgeWithOrientation(Orientation.RIGHT).fitsWith(piece.getEdgeWithOrientation(Orientation.LEFT))) return false
      if (c < solution(r).length - 1 && !solution(r)(c + 1).getEdgeWithOrientation(Orientation.LEFT).fitsWith(piece.getEdgeWithOrientation(Orientation.RIGHT))) return false
      if (r > 0 && !solution(r - 1)(c).getEdgeWithOrientation(Orientation.BOTTOM).fitsWith(piece.getEdgeWithOrientation(Orientation.TOP))) return false
      if (r < solution.length - 1 && !solution(r + 1)(c).getEdgeWithOrientation(Orientation.TOP).fitsWith(piece.getEdgeWithOrientation(Orientation.BOTTOM))) return false
    }
    true
  }

  def testSize(size: Int): Boolean = {
    val pieces = initializePuzzle(size)
    val puzzle = new Puzzle(size, pieces)
    puzzle.solve()
    val solution = puzzle.getCurrentSolution
    println(solutionToString(solution))
    val result = validate(solution)
    println(result)
    result
  }

  def main(args: Array[String]): Unit = {
    for (size <- 1 until 10) {
      if (!testSize(size)) {
        println(s"ERROR: $size")
      }
    }
  }
}
