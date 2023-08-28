package Q3_06_Animal_Shelter

class Dog(n: String) extends Animal(n) {
  override def name1(): String = "Dog: " + _name
}
