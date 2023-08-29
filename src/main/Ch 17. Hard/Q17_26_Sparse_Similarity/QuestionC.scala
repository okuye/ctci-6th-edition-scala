package Q17_26_Sparse_Similarity

import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.Map.Entry

object QuestionC {
  case class Element(word: Int, document: Int) extends Ordered[Element] {
    def compare(that: Element): Int = {
      if (word == that.word) document - that.document
      else word - that.word
    }
  }

  def computeSimilarities(documents: HashMap[Int, Document]): HashMap[DocPair, Double] = {
    val elements = sortWords(documents)
    val similarities = computeIntersections(elements)
    adjustToSimilarities(documents, similarities)
    similarities
  }

  def sortWords(docs: HashMap[Int, Document]): ArrayList[Element] = {
    val elements = new ArrayList[Element]()
    for ((_, doc) <- docs) {
      val words = doc.getWords()
      for (word <- words) {
        elements.add(Element(word, doc.getId()))
      }
    }
    Collections.sort(elements)
    elements
  }

  def increment(similarities: HashMap[DocPair, Double], doc1: Int, doc2: Int): Unit = {
    val pair = DocPair(doc1, doc2)
    val newSimilarity = similarities.getOrElse(pair, 0.0) + 1.0
    similarities.put(pair, newSimilarity)
  }

  def computeIntersections(elements: ArrayList[Element]): HashMap[DocPair, Double] = {
    val similarities = new HashMap[DocPair, Double]()
    var i = 0
    while (i < elements.size()) {
      val left = elements.get(i)
      var j = i + 1
      while (j < elements.size()) {
        val right = elements.get(j)
        if (left.word != right.word) {
          j = elements.size() // Break inner loop
        } else {
          increment(similarities, left.document, right.document)
        }
        j += 1
      }
      i += 1
    }
    similarities
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
