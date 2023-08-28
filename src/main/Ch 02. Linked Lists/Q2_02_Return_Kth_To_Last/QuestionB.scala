object NthToLast {

  class Node(var data: Int) {
    var next: Node = _
  }

  def nthToLast(head: Node, k: Int, i: Array[Int]): Node = {
    if (head == null) {
      return null
    }
    val nd = nthToLast(head.next, k, i)
    i(0) += 1
    if (i(0) == k) {
      return head
    }
    nd
  }

  def nthToLast(head: Node, k: Int): Node = {
    val i = Array(0)
    nthToLast(head, k, i)
  }

  def createList(count: Int): Node = {
    val head = new Node(0)
    var last = head
    for (i <- 1 until count) {
      val n = new Node(i)
      last.next = n
      last = n
    }
    head
  }

  def printList(head: Node): Unit = {
    var current = head
    while (current != null) {
      print(current.data)
      current = current.next
    }
  }

  def main(args: Array[String]): Unit = {
    val count = 5
    val head = createList(count)
    printList(head)
    println()
    for (k <- 0 to count) {
      val n = nthToLast(head, k)
      if (n != null) {
        println(s"$k: ${n.data}")
      }
    }
  }
}
