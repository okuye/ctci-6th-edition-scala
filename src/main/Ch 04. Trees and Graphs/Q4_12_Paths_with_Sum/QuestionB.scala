package Q4_12_Paths_with_Sum

import CtCILibrary.TreeNode
import scala.collection.mutable.HashMap

object QuestionB {

  def countPathsWithSum(root: TreeNode, targetSum: Int): Int = {
    countPathsWithSum(root, targetSum, 0, HashMap[Int, Int]())
  }

  def countPathsWithSum(node: TreeNode, targetSum: Int, runningSum: Int, pathCount: HashMap[Int, Int]): Int = {
    if (node == null) return 0

    val newRunningSum = runningSum + node.data

    val sum = newRunningSum - targetSum
    var _totalPaths = pathCount.getOrElse(sum, 0)

    if (newRunningSum == targetSum) {
      _totalPaths += 1
    }

    incrementHashTable(pathCount, newRunningSum, 1)

    val totalPathsLeft = countPathsWithSum(node.left, targetSum, newRunningSum, pathCount)
    val totalPathsRight = countPathsWithSum(node.right, targetSum, newRunningSum, pathCount)

    incrementHashTable(pathCount, newRunningSum, -1)

    _totalPaths + totalPathsLeft + totalPathsRight
  }

  def incrementHashTable(hashTable: HashMap[Int, Int], key: Int, delta: Int): Unit = {
    val newCount = hashTable.getOrElse(key, 0) + delta
    if (newCount == 0) {
      hashTable -= key
    } else {
      hashTable(key) = newCount
    }
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
