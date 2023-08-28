package Q4_05_Validate_BST

import CtCILibrary.AssortedMethods
import CtCILibrary.TreeNode

object QuestionB {

  def checkBST(n: TreeNode, min: Option[Int], max: Option[Int]): Boolean = {
    if (n == null) {
      true
    } else if ((min.isDefined && n.data <= min.get) || (max.isDefined && n.data > max.get)) {
      false
    } else {
      checkBST(n.left, min, Some(n.data)) && checkBST(n.right, Some(n.data), max)
    }
  }

  def checkBST(n: TreeNode): Boolean = {
    checkBST(n, None, None)
  }

  def checkBSTAlternate(n: TreeNode): Boolean = {
    checkBSTAlternate(n, IntWrapper(0), IntWrapper(0))
  }

  def checkBSTAlternate(n: TreeNode, min: IntWrapper, max: IntWrapper): Boolean = {
    if (n.left == null) {
      min.data = n.data
    } else {
      val leftMin = IntWrapper(0)
      val leftMax = IntWrapper(0)
      if (!checkBSTAlternate(n.left, leftMin, leftMax)) {
        return false
      }
      if (leftMax.data > n.data) {
        return false
      }
      min.data = leftMin.data
    }
    if (n.right == null) {
      max.data = n.data
    } else {
      val rightMin = IntWrapper(0)
      val rightMax = IntWrapper(0)
      if (!checkBSTAlternate(n.right, rightMin, rightMax)) {
        return false
      }
      if (rightMin.data <= n.data) {
        return false
      }
      max.data = rightMax.data
    }
    true
  }

  def createTestTree(): TreeNode = {
    val head = AssortedMethods.randomBST(10, -10, 10)
    var node = head
    var continueLoop = true
    while (node != null && continueLoop) {
      val n = AssortedMethods.randomIntInRange(-10, 10)
      val rand = AssortedMethods.randomIntInRange(0, 5)
      rand match {
        case 0 => node.data = n
        case 1 => node = node.left
        case 2 => node = node.right
        case 3 | 4 => continueLoop = false
        case _ =>
      }
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val array = Array(Int.MinValue, 3, 5, 6, 10, 13, 15, Int.MaxValue)
    val node = TreeNode.createMinimalBST(array)
    node.print()
    val isBst = checkBST(node)
    println(isBst)
  }
}

case class IntWrapper(var data: Int)
