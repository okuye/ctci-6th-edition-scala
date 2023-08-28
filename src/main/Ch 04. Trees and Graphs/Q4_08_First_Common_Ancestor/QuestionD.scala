package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode

object QuestionD {

  def commonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (!covers(root, p) || !covers(root, q)) {
      null
    } else {
      ancestorHelper(root, p, q)
    }
  }

  def ancestorHelper(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (root == null || root == p || root == q) {
      root
    } else {
      val pIsOnLeft = covers(root.left, p)
      val qIsOnLeft = covers(root.left, q)
      if (pIsOnLeft != qIsOnLeft) {
        root
      } else {
        val childSide = if (pIsOnLeft) root.left else root.right
        ancestorHelper(childSide, p, q)
      }
    }
  }

  def covers(root: TreeNode, p: TreeNode): Boolean = {
    if (root == null) false
    else if (root == p) true
    else covers(root.left, p) || covers(root.right, p)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(1)
    val n7 = root.find(7)
    val ancestor = commonAncestor(root, n3, n7)
    println(ancestor.data)
  }
}
