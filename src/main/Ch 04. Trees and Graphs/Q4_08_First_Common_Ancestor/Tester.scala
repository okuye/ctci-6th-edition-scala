package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode

import scala.collection.mutable.ArrayBuffer

object Tester {

  def resultToString(s: String, x: TreeNode, y: TreeNode, anc: TreeNode): String = {
    s + ": " + (if (x == null) "null" else x.data.toString) +
      " & " + (if (y == null) "null" else y.data.toString) +
      " -> " + (if (anc == null) "null" else anc.data.toString)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array)

    val nodes = ArrayBuffer[TreeNode]()
    array.foreach(a => nodes += root.find(a))
    nodes += new TreeNode(11)

    for (x <- nodes) {
      for (y <- nodes) {
        val r1 = QuestionA.commonAncestor(x, y)
        val r2 = QuestionB.commonAncestor(x, y)
        val r3 = QuestionC.commonAncestor(root, x, y)
        val r4 = QuestionD.commonAncestor(root, x, y)
        val r5 = QuestionE.commonAncestor(root, x, y)

        val s1 = resultToString("A", x, y, r1)
        val s2 = resultToString("B", x, y, r2)
        val s3 = resultToString("C", x, y, r3)
        val s4 = resultToString("D", x, y, r4)
        val s5 = resultToString("D", x, y, r5)

        if (r1 == r2 && r2 == r3 && r3 == r4 && r4 == r5) {
          println("SUCCESS: " + s1)
        } else {
          println("ERROR")
          println(s1)
          println(s2)
          println(s3)
          println(s4)
          println(s5)
        }
      }
    }
  }
}
