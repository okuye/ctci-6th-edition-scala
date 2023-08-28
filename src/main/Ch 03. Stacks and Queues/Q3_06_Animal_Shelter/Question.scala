package Q3_06_Animal_Shelter

object Question {
  def main(args: Array[String]): Unit = {
    val animals = new AnimalQueue()
    animals.enqueue(new Cat("Callie"))
    animals.enqueue(new Cat("Kiki"))
    animals.enqueue(new Dog("Fido"))
    animals.enqueue(new Dog("Dora"))
    animals.enqueue(new Cat("Kari"))
    animals.enqueue(new Dog("Dexter"))
    animals.enqueue(new Dog("Dobo"))
    animals.enqueue(new Cat("Copa"))

    println(animals.dequeueAny().name1())
    println(animals.dequeueAny().name1())
    println(animals.dequeueAny().name1())

    animals.enqueue(new Dog("Dapa"))
    animals.enqueue(new Cat("Kilo"))

    while (animals.size() != 0) {
      println(animals.dequeueAny().name1())
    }
  }
}
