package Q17_23_Max_Black_Square

class Subsquare(val row: Int, val column: Int, val size: Int) {
  def print(): Unit = {
    println("(" + row + ", " + column + ", " + size + ")")
  }
}
