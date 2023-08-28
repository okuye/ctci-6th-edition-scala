package Q15_04_Deadlock_Free_Class

import java.util.concurrent.locks.Lock
import scala.collection.mutable.{HashMap, ListBuffer}

object LockFactory {
  private var instance: LockFactory = _

  def getInstance(): LockFactory = instance

  def initialize(count: Int): LockFactory = {
    if (instance == null) {
      instance = new LockFactory(count)
    }
    instance
  }
}

class LockFactory(count: Int) {
  private val numberOfLocks: Int = count
  private val locks: Array[LockNode] = Array.fill(count)(null)
  private val lockOrder: HashMap[Int, ListBuffer[LockNode]] = new HashMap()

  for (i <- 0 until numberOfLocks) {
    locks(i) = new LockNode(i, count)
  }

  private def hasCycle(touchedNodes: HashMap[Int, Boolean], resourcesInOrder: Array[Int]): Boolean = {
    resourcesInOrder.exists { resource =>
      if (!touchedNodes(resource)) {
        val n = locks(resource)
        n.hasCycle(touchedNodes)
      } else {
        false
      }
    }
  }

  def declare(ownerId: Int, resourcesInOrder: Array[Int]): Boolean = {
    val touchedNodes = HashMap(resourcesInOrder.map(_ -> false): _*)

    for (index <- 1 until resourcesInOrder.length) {
      val prev = locks(resourcesInOrder(index - 1))
      val curr = locks(resourcesInOrder(index))
      prev.joinTo(curr)
    }

    if (hasCycle(touchedNodes, resourcesInOrder)) {
      for (j <- 1 until resourcesInOrder.length) {
        val p = locks(resourcesInOrder(j - 1))
        val c = locks(resourcesInOrder(j))
        p.remove(c)
      }
      false
    } else {
      val list = ListBuffer(resourcesInOrder.map(locks(_)): _*)
      lockOrder.put(ownerId, list)
      true
    }
  }

  def getLock(ownerId: Int, resourceID: Int): Option[Lock] = {
    lockOrder.get(ownerId) match {
      case Some(list) if list.nonEmpty && list.head.getId == resourceID =>
        val head = list.remove(0)
        Some(head.getLock)
      case _ => None
    }
  }
}
