package Q4_04_Check_Balanced

import CtCILibrary.TreeNode

object QuestionImproved extends App {

  def checkHeight(root: TreeNode): Int = {
    if (root == null) {
      return -1
    }
    val leftHeight = checkHeight(root.left)
    if (leftHeight == Int.MinValue) return Int.MinValue // Propagate error up

    val rightHeight = checkHeight(root.right)
    if (rightHeight == Int.MinValue) return Int.MinValue // Propagate error up

    val heightDiff = leftHeight - rightHeight
    if (Math.abs(heightDiff) > 1) {
      return Int.MinValue // Found error -> pass it back
    } else {
      return Math.max(leftHeight, rightHeight) + 1
    }
  }

  def isBalanced(root: TreeNode): Boolean = {
    checkHeight(root) != Int.MinValue
  }

  // Create balanced tree
  val array = Array(0, 1, 2, 3, 5, 6, 7, 8, 9, 10)

  // Assuming the TreeNode class has a companion object with the createMinimalBST method
  val root = TreeNode.createMinimalBST(array)

  println(s"Is balanced? ${isBalanced(root)}")

  root.insertInOrder(4) // Add 4 to make it unbalanced

  println(s"Is balanced? ${isBalanced(root)}")
}
