package Q10_08_Find_Duplicates

class BitSet(size: Int) {
  private val bitset: Array[Int] = Array.fill((size >> 5) + 1)(0)

  def get(pos: Int): Boolean = {
    val wordNumber = pos >> 5
    val bitNumber = pos & 0x1F
    (bitset(wordNumber) & (1 << bitNumber)) != 0
  }

  def set(pos: Int): Unit = {
    val wordNumber = pos >> 5
    val bitNumber = pos & 0x1F
    bitset(wordNumber) |= 1 << bitNumber
  }
}
