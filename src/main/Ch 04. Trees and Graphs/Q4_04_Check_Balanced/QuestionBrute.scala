package Q4_04_Check_Balanced

import CtCILibrary.{AssortedMethods, TreeNode}

object QuestionBrute extends App {

  def getHeight(root: TreeNode): Int = {
    if (root == null) {
      return -1
    }
    Math.max(getHeight(root.left), getHeight(root.right)) + 1
  }

  def isBalanced(root: TreeNode): Boolean = {
    if (root == null) {
      return true
    }
    val heightDiff = getHeight(root.left) - getHeight(root.right)
    if (Math.abs(heightDiff) > 1) {
      return false
    } else {
      return isBalanced(root.left) && isBalanced(root.right)
    }
  }

  // Create balanced tree
  val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  // Assuming the TreeNode class has a companion object with the createMinimalBST method
  val root = TreeNode.createMinimalBST(array)
  println(s"Root? ${root.data}")
  println(s"Is balanced? ${isBalanced(root)}")

  // Could be balanced, actually, but it's very unlikely...
  val unbalanced = new TreeNode(10)
  for (_ <- 0 until 10) {
    unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100))
  }
  println(s"Root? ${unbalanced.data}")
  println(s"Is balanced? ${isBalanced(unbalanced)}")
}
