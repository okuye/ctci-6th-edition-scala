package Q3_06_Animal_Shelter

import scala.collection.mutable.Queue

class AnimalQueue {
  private val dogs: Queue[Dog] = Queue[Dog]()
  private val cats: Queue[Cat] = Queue[Cat]()
  private var order: Int = 0

  def enqueue(a: Animal): Unit = {
    a.setOrder(order)
    order += 1
    a match {
      case dog: Dog => dogs.enqueue(dog)
      case cat: Cat => cats.enqueue(cat)
    }
  }

  def dequeueAny(): Animal = {
    if (dogs.isEmpty) {
      dequeueCats()
    } else if (cats.isEmpty) {
      dequeueDogs()
    } else {
      val dog = dogs.head
      val cat = cats.head
      if (dog.isOlderThan(cat)) {
        dogs.dequeue()
      } else {
        cats.dequeue()
      }
    }
  }

  def peek(): Animal = {
    if (dogs.isEmpty) {
      cats.head
    } else if (cats.isEmpty) {
      dogs.head
    } else {
      val dog = dogs.head
      val cat = cats.head
      if (dog.isOlderThan(cat)) dog else cat
    }
  }

  def size(): Int = dogs.size + cats.size

  def dequeueDogs(): Dog = dogs.dequeue()

  def peekDogs(): Dog = dogs.head

  def dequeueCats(): Cat = cats.dequeue()

  def peekCats(): Cat = cats.head
}
