package Q7_12_Hash_Table

class Dummy(n: String, a: Int) {
  private val name: String = n
  private val age: Int = a

  override def toString: String = s"($name, $age)"

  def getAge: Int = age

  def getName: String = name
}
