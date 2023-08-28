package Q4_09_BST_Sequences

import CtCILibrary.TreeNode

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Question {

  def weaveLists(first: ListBuffer[Int], second: ListBuffer[Int], results: ArrayBuffer[ListBuffer[Int]], prefix: ListBuffer[Int]): Unit = {
    if (first.isEmpty || second.isEmpty) {
      val result = prefix.clone()
      result ++= first
      result ++= second
      results += result
      return
    }

    val headFirst = first.remove(0)
    prefix.append(headFirst)
    weaveLists(first, second, results, prefix)
    prefix.remove(prefix.length - 1)
    first.insert(0, headFirst)

    val headSecond = second.remove(0)
    prefix.append(headSecond)
    weaveLists(first, second, results, prefix)
    prefix.remove(prefix.length - 1)
    second.insert(0, headSecond)
  }

  def allSequences(node: TreeNode): ArrayBuffer[ListBuffer[Int]] = {
    val result = ArrayBuffer[ListBuffer[Int]]()

    if (node == null) {
      result += ListBuffer[Int]()
      return result
    }

    val prefix = ListBuffer(node.data)

    val leftSeq = allSequences(node.left)
    val rightSeq = allSequences(node.right)

    for (left <- leftSeq; right <- rightSeq) {
      val weaved = ArrayBuffer[ListBuffer[Int]]()
      weaveLists(left, right, weaved, prefix)
      result ++= weaved
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val node = new TreeNode(100)
    val array = Array(100, 50, 20, 75, 150, 120, 170)
    array.foreach(a => node.insertInOrder(a))
    val allSeq = allSequences(node)
    allSeq.foreach(list => println(list.mkString(", ")))
    println(allSeq.size)
  }
}
