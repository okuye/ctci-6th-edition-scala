package Q17_12_BiNode

object QuestionC {

  def printAsTree(root: BiNode, spaces: String): Unit = {
    if (root == null) {
      println(spaces + "- null")
    } else {
      println(spaces + "- " + root.data)
      printAsTree(root.node1, spaces + "   ")
      printAsTree(root.node2, spaces + "   ")
    }
  }

  def createTree(): BiNode = {
    val nodes = Array.fill(7)(null: BiNode).zipWithIndex.map { case (_, i) => new BiNode(i) }
    nodes(4).node1 = nodes(2)
    nodes(4).node2 = nodes(5)
    nodes(2).node1 = nodes(1)
    nodes(2).node2 = nodes(3)
    nodes(5).node2 = nodes(6)
    nodes(1).node1 = nodes(0)
    nodes(4)
  }

  def printLinkedListTree(root: BiNode): Unit = {
    var node = root
    while (node != null) {
      if (node.node2 != null && node.node2.node1 != node) {
        print(s"inconsistent node: $node")
      }
      print(node.data + "->")
      node = node.node2
    }
    println()
  }

  def convertToCircular(root: BiNode): BiNode = {
    if (root == null) return null

    val part1 = convertToCircular(root.node1)
    val part3 = convertToCircular(root.node2)

    if (part1 == null && part3 == null) {
      root.node1 = root
      root.node2 = root
      return root
    }
    val tail3 = if (part3 == null) null else part3.node1

    // join left to root
    if (part1 == null) {
      concat(part3.node1, root)
    } else {
      concat(part1.node1, root)
    }

    // join right to root
    if (part3 == null) {
      concat(root, part1)
    } else {
      concat(root, part3)
    }

    // join right to left
    if (part1 != null && part3 != null) {
      concat(tail3, part1)
    }

    if (part1 == null) root else part1
  }

  def convert(root: BiNode): BiNode = {
    val head = convertToCircular(root)
    head.node1.node2 = null
    head.node1 = null
    head
  }

  def concat(x: BiNode, y: BiNode): Unit = {
    x.node2 = y
    y.node1 = x
  }

  def main(args: Array[String]): Unit = {
    val root = createTree()
    printAsTree(root, "")
    val r = convert(root)
    printLinkedListTree(r)
  }
}
