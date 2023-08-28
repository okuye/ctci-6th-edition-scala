package Q4_10_Check_Subtree

import CtCILibrary.AssortedMethods
import CtCILibrary.TreeNode

object QuestionA {

  def containsTree(t1: TreeNode, t2: TreeNode): Boolean = {
    val string1 = new StringBuilder
    val string2 = new StringBuilder

    getOrderString(t1, string1)
    getOrderString(t2, string2)

    string1.indexOf(string2.toString) != -1
  }

  def getOrderString(node: TreeNode, sb: StringBuilder): Unit = {
    if (node == null) {
      sb.append("X") // Add null indicator
      return
    }
    sb.append(node.data) // Add root
    getOrderString(node.left, sb) // Add left
    getOrderString(node.right, sb) // Add right
  }

  def main(args: Array[String]): Unit = {
    // t2 is a subtree of t1
    val array1 = Array(1, 2, 1, 3, 1, 1, 5)
    val array2 = Array(2, 3, 1)

    val t1 = AssortedMethods.createTreeFromArray(array1)
    val t2 = AssortedMethods.createTreeFromArray(array2)

    if (containsTree(t1, t2)) {
      println("t2 is a subtree of t1")
    } else {
      println("t2 is not a subtree of t1")
    }

    // t4 is not a subtree of t3
    val array3 = Array(1, 2, 3)
    val t3 = AssortedMethods.createTreeFromArray(array1)
    val t4 = AssortedMethods.createTreeFromArray(array3)

    if (containsTree(t3, t4)) {
      println("t4 is a subtree of t3")
    } else {
      println("t4 is not a subtree of t3")
    }
  }
}
