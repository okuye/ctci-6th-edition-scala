package Q4_02_Minimal_Tree

import CtCILibrary.TreeNode

object Question extends App {
  val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  // Assuming the TreeNode class has a companion object with the createMinimalBST method
  val root = TreeNode.createMinimalBST(array)
  println(s"Root? ${root.data}")
  println(s"Created BST? ${root.isBST}")
  println(s"Height: ${root.height}")
}
