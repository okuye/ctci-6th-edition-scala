package Q3_06_Animal_Shelter

class Cat(n: String) extends Animal(n) {
  override def name1(): String = "Cat: " + _name
}
