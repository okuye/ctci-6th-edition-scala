package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode

object QuestionEBad {

  def commonAncestorBad(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (root == null) {
      null
    } else if (root == p && root == q) {
      root
    } else {
      val x = commonAncestorBad(root.left, p, q)
      if (x != null && x != p && x != q) {
        x
      } else {
        val y = commonAncestorBad(root.right, p, q)
        if (y != null && y != p && y != q) {
          y
        } else if (x != null && y != null) {
          root
        } else if (root == p || root == q) {
          root
        } else {
          if (x == null) y else x
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(9)
    val n7 = new TreeNode(6)
    val ancestor = commonAncestorBad(root, n3, n7)
    println(Option(ancestor).map(_.data).getOrElse("null"))
  }
}
