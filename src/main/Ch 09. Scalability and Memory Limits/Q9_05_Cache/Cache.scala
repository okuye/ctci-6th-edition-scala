package Q9_05_Cache

import scala.collection.mutable

class Cache {
  val MaxSize = 10
  var head: Node = _
  var tail: Node = _
  val map = mutable.HashMap[String, Node]()
  var size: Int = 0

  def moveToFront(node: Node): Unit = {
    if (node == head) {
      return
    }
    removeFromLinkedList(node)
    node.next = head
    if (head != null) {
      head.prev = node
    }
    head = node
    size += 1

    if (tail == null) {
      tail = node
    }
  }

  def moveToFront(query: String): Unit = {
    val node = map(query)
    moveToFront(node)
  }

  def removeFromLinkedList(node: Node): Unit = {
    if (node == null) {
      return
    }

    if (Option(node.next).isDefined || Option(node.prev).isDefined) {
      size -= 1
    }

    val prev = node.prev
    if (prev != null) {
      prev.next = node.next
    }

    val next = node.next
    if (next != null) {
      next.prev = prev
    }

    if (node == head) {
      head = next
    }

    if (node == tail) {
      tail = prev
    }

    node.next = null
    node.prev = null
  }

  def getResults(query: String): Array[String] = {
    if (map.contains(query)) {
      val node = map(query)
      moveToFront(node)
      node.results
    } else {
      null
    }
  }

  def insertResults(query: String, results: Array[String]): Unit = {
    if (map.contains(query)) {
      val node = map(query)
      node.results = results
      moveToFront(node)
      return
    }

    val node = new Node(query, results)
    moveToFront(node)
    map += (query -> node)

    if (size > MaxSize) {
      map -= tail.query
      removeFromLinkedList(tail)
    }
  }
}
