package Q4_10_Check_Subtree

import CtCILibrary.AssortedMethods
import CtCILibrary.TreeNode

object QuestionB {

  def containsTree(t1: TreeNode, t2: TreeNode): Boolean = {
    if (t2 == null) {
      return true // The empty tree is a subtree of every tree.
    }
    subTree(t1, t2)
  }

  def subTree(r1: TreeNode, r2: TreeNode): Boolean = {
    if (r1 == null) {
      false // big tree empty & subtree still not found.
    } else if (r1.data == r2.data && matchTree(r1, r2)) {
      true
    } else {
      subTree(r1.left, r2) || subTree(r1.right, r2)
    }
  }

  def matchTree(r1: TreeNode, r2: TreeNode): Boolean = {
    if (r1 == null && r2 == null) {
      true // nothing left in the subtree
    } else if (r1 == null || r2 == null) {
      false // exactly one tree is empty, therefore trees don't match
    } else if (r1.data != r2.data) {
      false // data doesn't match
    } else {
      matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right)
    }
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(1, 2, 1, 3, 1, 1, 5)
    val array2 = Array(2, 3, 1)

    val t1 = AssortedMethods.createTreeFromArray(array1)
    val t2 = AssortedMethods.createTreeFromArray(array2)

    if (containsTree(t1, t2)) {
      println("t2 is a subtree of t1")
    } else {
      println("t2 is not a subtree of t1")
    }

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
