package Q4_08_First_Common_Ancestor

class TreeNode(val data: Int, var left: TreeNode = null, var right: TreeNode = null, var parent: TreeNode = null) {
  def insertInOrder(d: Int): Unit = {
    if (d <= data) {
      if (left == null) {
        left = new TreeNode(d)
        left.parent = this
      } else {
        left.insertInOrder(d)
      }
    } else {
      if (right == null) {
        right = new TreeNode(d)
        right.parent = this
      } else {
        right.insertInOrder(d)
      }
    }
  }

  def find(d: Int): TreeNode = {
    if (d == data) {
      this
    } else if (d <= data) {
      left.find(d)
    } else if (d > data) {
      right.find(d)
    } else {
      null
    }
  }

  // Additional methods and utilities can be added here
}

object QuestionF {

  def commonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (p == null || q == null) {
      null
    } else {
      var ap = p.parent
      while (ap != null) {
        var aq = q.parent
        while (aq != null) {
          if (aq == ap) {
            return aq
          }
          aq = aq.parent
        }
        ap = ap.parent
      }
      null
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(5, 3, 6, 1, 9, 11)
    val root = new TreeNode(20)
    array.foreach(root.insertInOrder)
    val n1 = root.find(1)
    val n9 = root.find(9)
    val ancestor = commonAncestor(root, n1, n9)
    println(ancestor.data)
  }
}
