package Q17_26_Sparse_Similarity

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet

import CtCILibrary.AssortedMethods

object QuestionA {
  def computeSimilarities(documents: HashMap[Int, Document]): HashMap[DocPair, Double] = {
    val docs = new ArrayList[Document](documents.values())
    computeSimilarities(docs)
  }

  def computeSimilarities(documents: ArrayList[Document]): HashMap[DocPair, Double] = {
    val similarities = new HashMap[DocPair, Double]()
    for (i <- 0 until documents.size()) {
      for (j <- i + 1 until documents.size()) {
        val doc1 = documents.get(i)
        val doc2 = documents.get(j)
        val sim = computeSimilarity(doc1, doc2)
        if (sim > 0) {
          val pair = DocPair(doc1.getId(), doc2.getId())
          similarities.put(pair, sim)
        }
      }
    }
    similarities
  }

  def computeSimilarity(doc1: Document, doc2: Document): Double = {
    val intersection = doc1.getWords().intersect(doc2.getWords()).size
    val union = doc1.size() + doc2.size() - intersection
    intersection.toDouble / union
  }

  def removeDups(array: Array[Int]): ArrayList[Int] = {
    val set = new HashSet[Int]()
    for (a <- array) {
      set.add(a)
    }
    new ArrayList[Int](set)
  }

  def main(args: Array[String]): Unit = {
    val numDocuments = 10
    val docSize = 5
    val documents = new HashMap[Int, Document]()
    for (i <- 0 until numDocuments) {
      val words = AssortedMethods.randomArray(docSize, 0, 10)
      val w = removeDups(words.toArray)
      println(s"$i: $w")
      val doc = new Document(i, w)
      documents.put(i, doc)
    }

    val similarities = computeSimilarities(documents)
    Tester.printSim(similarities)
  }
}
