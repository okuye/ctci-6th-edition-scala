package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode


object QuestionB {
  def commonAncestor(p: TreeNode, q: TreeNode): TreeNode = {
    val delta = depth(p) - depth(q)
    var first = if (delta > 0) q else p
    var second = if (delta > 0) p else q
    second = goUpBy(second, delta.abs)
    while (first != second && first != null && second != null) {
      first = first.parent
      second = second.parent
    }
    if (first == null || second == null) null else first
  }

  def goUpBy(node: TreeNode, delta: Int): TreeNode = {
    var n = node
    var d = delta
    while (d > 0 && n != null) {
      n = n.parent
      d -= 1
    }
    n
  }

  def depth(node: TreeNode): Int = {
    var depth = 0
    var n = node
    while (n != null) {
      n = n.parent
      depth += 1
    }
    depth
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(3)
    val n7 = root.find(7)
    val ancestor = commonAncestor(n3, n7)
    println(ancestor.data)
  }
}
