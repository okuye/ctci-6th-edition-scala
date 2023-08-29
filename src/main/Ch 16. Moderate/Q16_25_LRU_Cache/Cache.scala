package Q16_25_LRU_Cache

import scala.jdk.CollectionConverters._

class Cache(maxSize: Int) {
  private val map = new java.util.HashMap[Int, LinkedListNode]()
  private var listHead: LinkedListNode = null
  private var listTail: LinkedListNode = null

  def getValue(key: Int): String = {
    val item = map.get(key)
    if (item == null) {
      null
    } else {
      if (item != listHead) {
        removeFromLinkedList(item)
        insertAtFrontOfLinkedList(item)
      }
      item.value
    }
  }

  private def removeFromLinkedList(node: LinkedListNode): Unit = {
    if (node == null) {
      return
    }
    if (node.prev != null) {
      node.prev.next = node.next
    }
    if (node.next != null) {
      node.next.prev = node.prev
    }
    if (node == listTail) {
      listTail = node.prev
    }
    if (node == listHead) {
      listHead = node.next
    }
  }

  private def insertAtFrontOfLinkedList(node: LinkedListNode): Unit = {
    if (listHead == null) {
      listHead = node
      listTail = node
    } else {
      listHead.prev = node
      node.next = listHead
      listHead = node
      listHead.prev = null
    }
  }

  def removeKey(key: Int): Boolean = {
    val node = map.get(key)
    removeFromLinkedList(node)
    map.remove(key)
    true
  }

  def setKeyValue(key: Int, value: String): Unit = {
    removeKey(key)
    if (map.size() >= maxSize && listTail != null) {
      removeKey(listTail.key)
    }
    val node = new LinkedListNode(key, value)
    insertAtFrontOfLinkedList(node)
    map.put(key, node)
  }

  def getCacheAsString(): String = {
    if (listHead == null) {
      ""
    } else {
      listHead.printForward()
    }
  }

  private class LinkedListNode(val key: Int, val value: String) {
    var next: LinkedListNode = null
    var prev: LinkedListNode = null

    def printForward(): String = {
      val data = s"($key,$value)"
      if (next != null) {
        data + "->" + next.printForward()
      } else {
        data
      }
    }
  }
}

object Question {
  def main(args: Array[String]): Unit = {
    val cache_size = 5
    val cache = new Cache(cache_size)

    cache.setKeyValue(1, "1")
    println(cache.getCacheAsString())
    cache.setKeyValue(2, "2")
    println(cache.getCacheAsString())
    cache.setKeyValue(3, "3")
    println(cache.getCacheAsString())
    cache.getValue(1)
    println(cache.getCacheAsString())
    cache.setKeyValue(4, "4")
    println(cache.getCacheAsString())
    cache.getValue(2)
    println(cache.getCacheAsString())
    cache.setKeyValue(5, "5")
    println(cache.getCacheAsString())
    cache.getValue(5)
    println(cache.getCacheAsString())
    cache.setKeyValue(6, "6")
    println(cache.getCacheAsString())
    cache.getValue(1)
    println(cache.getCacheAsString())
    cache.setKeyValue(5, "5a")
    println(cache.getCacheAsString())
    cache.getValue(3)
    println(cache.getCacheAsString())
  }
}