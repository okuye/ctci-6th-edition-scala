package Q17_26_Sparse_Similarity

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Map.Entry

object Tester {
  def removeDups(array: Array[Int]): ArrayList[Int] = {
    val set = new HashSet[Int]()
    for (a <- array) {
      set.add(a)
    }
    val list = new ArrayList[Int]()
    list.addAll(set)
    list
  }

  def isEqual(one: HashMap[DocPair, Double], two: HashMap[DocPair, Double]): Boolean = {
    if (one.size != two.size) {
      return false
    }

    for (a <- one.entrySet()) {
      val key = a.getKey
      if (!two.containsKey(key)) {
        return false
      }
      val sim1 = a.getValue
      val sim2 = two.get(key)
      if (sim1 != sim2) {
        return false
      }
    }
    true
  }

  def printSim(similarities: HashMap[DocPair, Double]): Unit = {
    for (result <- similarities.entrySet()) {
      val pair = result.getKey
      val sim = result.getValue
      println(pair.doc1 + ", " + pair.doc2 + " : " + sim)
    }
  }

  def addTo(documents: HashMap[Int, Document], id: Int, array: Array[Int]): Unit = {
    val w = removeDups(array)
    val doc = new Document(id, w)
    documents.put(id, doc)
  }

  def main(args: Array[String]): Unit = {
    val documents = new HashMap[Int, Document]()

    val array1 = Array(14, 15, 100, 9, 3)
    addTo(documents, 13, array1)

    val array2 = Array(32, 1, 9, 3, 5)
    addTo(documents, 16, array2)

    val array3 = Array(15, 29, 2, 6, 8, 7)
    addTo(documents, 19, array3)

    val array4 = Array(7, 10)
    addTo(documents, 24, array4)

    val simA = QuestionA.computeSimilarities(documents)
    val simB = QuestionB.computeSimilarities(documents)
    val simC = QuestionC.computeSimilarities(documents)
    println("----------")
    printSim(simA)
    println("----------")
    printSim(simB)
    println("----------")
    printSim(simC)
    println("----------")

    println(isEqual(simA, simB))
    println(isEqual(simB, simC))
    println(isEqual(simA, simC))
  }
}
