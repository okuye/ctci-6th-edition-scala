package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode

object QuestionE {

  case class Result(node: TreeNode, isAncestor: Boolean)

  def commonAncestorHelper(root: TreeNode, p: TreeNode, q: TreeNode): Result = {
    if (root == null) {
      Result(null, false)
    } else if (root == p && root == q) {
      Result(root, true)
    } else {
      val rx = commonAncestorHelper(root.left, p, q)
      if (rx.isAncestor) {
        rx
      } else {
        val ry = commonAncestorHelper(root.right, p, q)
        if (ry.isAncestor) {
          ry
        } else if (rx.node != null && ry.node != null) {
          Result(root, true)
        } else if (root == p || root == q) {
          Result(root, rx.node != null || ry.node != null)
        } else {
          Result(if (rx.node != null) rx.node else ry.node, false)
        }
      }
    }
  }

  def commonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    val r = commonAncestorHelper(root, p, q)
    if (r.isAncestor) r.node else null
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(10)
    val n7 = root.find(6)
    val ancestor = commonAncestor(root, n3, n7)
    println(Option(ancestor).map(_.data).getOrElse("null"))
  }
}
