package Q15_04_Deadlock_Free_Class

import scala.collection.mutable.{ArrayBuffer, HashMap}
import java.util.concurrent.locks.{Lock, ReentrantLock}

object VisitState extends Enumeration {
  val FRESH, VISITING, VISITED = Value
}

class LockNode(id: Int, max: Int) {
  import VisitState._

  private val children = ArrayBuffer[LockNode]()
  private val lockId = id
  private var lock: Lock = _
  private val maxLocks = max

  def joinTo(node: LockNode): Unit = children += node

  def remove(node: LockNode): Unit = children -= node

  def hasCycle(touchedNodes: HashMap[Int, Boolean]): Boolean = {
    val visited = Array.fill(maxLocks)(FRESH)
    checkCycle(visited, touchedNodes)
  }

  private def checkCycle(
      visited: Array[VisitState.Value],
      touchedNodes: HashMap[Int, Boolean]
  ): Boolean = {
    if (!touchedNodes.contains(lockId)) {
      touchedNodes += (lockId -> true)
    }

    visited(lockId) match {
      case VISITING => true
      case FRESH =>
        visited(lockId) = VISITING
        if (children.exists(child => child.checkCycle(visited, touchedNodes))) {
          true
        } else {
          visited(lockId) = VISITED
          false
        }
      case _ => false
    }
  }

  def getLock: Lock = {
    if (lock == null) {
      lock = new ReentrantLock()
    }
    lock
  }

  def getId: Int = lockId
}
