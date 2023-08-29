package Q17_24_Max_Submatrix

class SubMatrix(private val row1: Int, private val col1: Int, private val row2: Int, private val col2: Int, private val sum: Int) {
  def getSum(): Int = sum

  override def toString(): String = {
    s"[($row1,$col1) -> ($row2,$col2) = $sum]"
  }
}
