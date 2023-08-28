package Q8_02_Robot_in_a_Grid

case class Point(row: Int, column: Int) {
  override def toString: String = s"($row, $column)"

  // The `hashCode` and `equals` methods are automatically provided by the `case class`, so no need to override them.
}
