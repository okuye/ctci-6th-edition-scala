package Q17_26_Sparse_Similarity

import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.Map.Entry
import java.util.Set

import CtCILibrary.AssortedMethods
import CtCILibrary.HashMapList

object QuestionB {
  def computeSimilarities(documents: HashMap[Int, Document]): HashMap[DocPair, Double] = {
    val wordToDocs = groupWords(documents)
    val similarities = computeIntersections(wordToDocs)
    adjustToSimilarities(documents, similarities)
    similarities
  }

  def groupWords(documents: HashMap[Int, Document]): HashMapList[Int, Int] = {
    val wordToDocs = new HashMapList[Int, Int]()

    for ((_, doc) <- documents) {
      val words = doc.getWords()
      for (word <- words) {
        wordToDocs.put(word, doc.getId())
      }
    }

    wordToDocs
  }

  def computeIntersections(wordToDocs: HashMapList[Int, Int]): HashMap[DocPair, Double] = {
    val similarities = new HashMap[DocPair, Double]()
    val words: Set[Int] = wordToDocs.keySet()
    for (word <- words) {
      val docs: ArrayList[Int] = wordToDocs.get(word)
      Collections.sort(docs)
      for (i <- 0 until docs.size()) {
        for (j <- i + 1 until docs.size()) {
          increment(similarities, docs.get(i), docs.get(j))
        }
      }
    }

    similarities
  }

  def increment(similarities: HashMap[DocPair, Double], doc1: Int, doc2: Int): Unit = {
    val pair = DocPair(doc1, doc2)
    val newSimilarity = similarities.getOrElse(pair, 0.0) + 1.0
    similarities.put(pair, newSimilarity)
  }

  def adjustToSimilarities(documents: HashMap[Int, Document], similarities: HashMap[DocPair, Double]): Unit = {
    for ((pair, intersection) <- similarities) {
      val doc1 = documents(pair.doc1)
      val doc2 = documents(pair.doc2)
      val union = doc1.size() + doc2.size() - intersection
      similarities.put(pair, intersection / union)
    }
  }

  def main(args: Array[String]): Unit = {
    val numDocuments = 10
    val docSize = 5
    val documents = new HashMap[Int, Document]()
    for (i <- 0 until numDocuments) {
      val words = AssortedMethods.randomArray(docSize, 0, 10)
      val w = Tester.removeDups(words)
      println(s"$i: $w")
      val doc = new Document(i, w)
      documents.put(i, doc)
    }

    val similarities = computeSimilarities(documents)
    Tester.printSim(similarities)
  }
}
