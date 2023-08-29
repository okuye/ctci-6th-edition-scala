package Q17_26_Sparse_Similarity

import java.util.ArrayList

class Document(private val docId: Int, private val words: ArrayList[Int]) {
  def getWords: ArrayList[Int] = words

  def getId: Int = docId

  def size: Int = if (words == null) 0 else words.size()
}
