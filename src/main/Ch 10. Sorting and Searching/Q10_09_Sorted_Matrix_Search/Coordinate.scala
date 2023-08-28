package Q10_09_Sorted_Matrix_Search

class Coordinate(var row: Int, var column: Int) {

  def inbounds(matrix: Array[Array[Int]]): Boolean = {
    row >= 0 &&
      column >= 0 &&
      row < matrix.length &&
      column < matrix(0).length
  }

  def isBefore(p: Coordinate): Boolean = {
    row <= p.row && column <= p.column
  }

  def moveDownRight(): Unit = {
    row += 1
    column += 1
  }

  def setToAverage(min: Coordinate, max: Coordinate): Unit = {
    row = (min.row + max.row) / 2
    column = (min.column + max.column) / 2
  }

  // Note: The clone method is not necessary in Scala. If you still need a copy,
  // you can implement a custom copy method or use case classes which provide a default copy method.
}
