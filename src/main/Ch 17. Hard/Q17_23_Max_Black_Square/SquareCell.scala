package Q17_23_Max_Black_Square

class SquareCell(var zerosRight: Int, var zerosBelow: Int) {
  def setZerosRight(right: Int): Unit = {
    zerosRight = right
  }

  def setZerosBelow(below: Int): Unit = {
    zerosBelow = below
  }
}
