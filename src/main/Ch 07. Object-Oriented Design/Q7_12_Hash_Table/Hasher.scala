package Q7_12_Hash_Table

import scala.collection.mutable.ArrayBuffer

class Hasher[K, V](capacity: Int) {
  private class LinkedListNode(var key: K, var value: V) {
    var next: LinkedListNode = _
    var prev: LinkedListNode = _

    def printForward(): String = {
      val data = s"($key,$value)"
      if (next != null) data + "->" + next.printForward()
      else data
    }
  }

  private val arr = ArrayBuffer.fill[LinkedListNode](capacity)(null)

  def put(key: K, value: V): V = {
    val node = getNodeForKey(key)
    if (node != null) {
      val oldValue = node.value
      node.value = value
      oldValue
    } else {
      val newNode = new LinkedListNode(key, value)
      val index = getIndexForKey(key)
      if (arr(index) != null) {
        newNode.next = arr(index)
        newNode.next.prev = newNode
      }
      arr(index) = newNode
      null.asInstanceOf[V]
    }
  }

  def remove(key: K): V = {
    val node = getNodeForKey(key)
    if (node == null) return null.asInstanceOf[V]

    if (node.prev != null) node.prev.next = node.next
    else {
      val hashKey = getIndexForKey(key)
      arr(hashKey) = node.next
    }

    if (node.next != null) node.next.prev = node.prev
    node.value
  }

  def get(key: K): V = {
    val node = getNodeForKey(key)
    if (node == null) null.asInstanceOf[V]
    else node.value
  }

  private def getNodeForKey(key: K): LinkedListNode = {
    val index = getIndexForKey(key)
    var current = arr(index)
    while (current != null) {
      if (current.key == key) return current
      current = current.next
    }
    null
  }

  def getIndexForKey(key: K): Int = {
    Math.abs(key.hashCode() % arr.size)
  }

  def printTable(): Unit = {
    for (i <- arr.indices) {
      val s = if (arr(i) == null) "" else arr(i).printForward()
      println(s"$i: $s")
    }
  }
}
