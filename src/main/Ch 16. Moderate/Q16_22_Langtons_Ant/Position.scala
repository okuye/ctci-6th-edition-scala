package Q16_22_Langtons_Ant

case class Position(var row: Int, var column: Int) {

  // The equals and hashCode methods are automatically generated by the case class

  def clonePosition(): Position = Position(row, column)
}
