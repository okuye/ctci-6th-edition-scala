package Q4_05_Validate_BST

import CtCILibrary.TreeNode

object Question {
  var lastPrinted: Option[Int] = None

  def checkBST(node: TreeNode): Boolean = {
    checkBST(node, isLeft = true)
  }

  def checkBST(n: TreeNode, isLeft: Boolean): Boolean = {
    if (n == null) {
      return true
    }

    if (!checkBST(n.left, isLeft = true)) {
      return false
    }

    if (lastPrinted.isDefined) {
      if (isLeft) {
        if (n.data < lastPrinted.get) {
          return false
        }
      } else {
        if (n.data <= lastPrinted.get) {
          return false
        }
      }
    }
    lastPrinted = Some(n.data)

    if (!checkBST(n.right, isLeft = false)) {
      return false
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val array = Array(Int.MinValue, Int.MaxValue - 2, Int.MaxValue - 1, Int.MaxValue)
    val node = TreeNode.createMinimalBST(array)
    println(checkBST(node))

    test()
  }

  def test(): Unit = {
    println("test cases for equals condition.")

    val array2 = Array(1, 2, 3, 4)
    var node = TreeNode.createMinimalBST(array2)
    node.left.data = 2
    node.print()
    lastPrinted = None
    var condition = checkBST(node)
    println(s"should be true: $condition")

    val array3 = Array(1, 2, 3, 4)
    node = TreeNode.createMinimalBST(array3)
    node.right.data = 2
    node.print()
    lastPrinted = None
    condition = checkBST(node)
    println(s"should be false: $condition")
  }
}
