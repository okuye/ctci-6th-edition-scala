package Q4_12_Paths_with_Sum

import CtCILibrary.TreeNode

object QuestionA {

  def countPathsWithSum(root: TreeNode, targetSum: Int): Int = {
    if (root == null) return 0

    val pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0)
    val pathsOnLeft = countPathsWithSum(root.left, targetSum)
    val pathsOnRight = countPathsWithSum(root.right, targetSum)

    pathsFromRoot + pathsOnLeft + pathsOnRight
  }

  def countPathsWithSumFromNode(node: TreeNode, targetSum: Int, currentSum: Int): Int = {
    if (node == null) return 0

    var totalPaths = 0
    val newCurrentSum = currentSum + node.data

    if (newCurrentSum == targetSum) {
      totalPaths += 1
    }

    totalPaths += countPathsWithSumFromNode(node.left, targetSum, newCurrentSum)
    totalPaths += countPathsWithSumFromNode(node.right, targetSum, newCurrentSum)

    totalPaths
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(0)
    root.left = new TreeNode(0)
    root.right = new TreeNode(0)
    root.right.left = new TreeNode(0)
    root.right.left.right = new TreeNode(0)
    root.right.right = new TreeNode(0)
    println(countPathsWithSum(root, 0))
    println(countPathsWithSum(root, 4))
  }
}
