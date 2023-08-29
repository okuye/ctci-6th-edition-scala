package CtCILibrary

import scala.collection.mutable

class HashMapList[T, E] {
  private val map = mutable.HashMap[T, mutable.ArrayBuffer[E]]()

  // Insert item into list at key
  def put(key: T, item: E): Unit = {
    if (!map.contains(key)) {
      map(key) = mutable.ArrayBuffer[E]()
    }
    map(key) += item
  }

  // Insert list of items at key
  def put(key: T, items: mutable.ArrayBuffer[E]): Unit = {
    map(key) = items
  }

  // Get list of items at key
  def get(key: T): Option[mutable.ArrayBuffer[E]] = {
    map.get(key)
  }

  // Check if HashMapList contains key
  def containsKey(key: T): Boolean = {
    map.contains(key)
  }

  // Check if list at key contains value
  def containsKeyValue(key: T, value: E): Boolean = {
    map.get(key).exists(_.contains(value))
  }

  // Get the list of keys
  def keySet(): Set[T] = {
    map.keySet.toSet
  }

  override def toString: String = {
    map.toString()
  }
}
