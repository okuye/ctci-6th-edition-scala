package Q7_12_Hash_Table

object Question extends App {
  val bob = new Dummy("Bob", 20)
  val jim = new Dummy("Jim", 25)
  val alex = new Dummy("Alex", 30)
  val tim = new Dummy("Tim", 35)
  val maxwell = new Dummy("Maxwell", 40)
  val john = new Dummy("John", 45)
  val julie = new Dummy("Julie", 50)
  val christy = new Dummy("Christy", 55)
  val tim2 = new Dummy("Tim", 100) // This should replace the first "tim"

  val dummies = Array(bob, jim, alex, tim, maxwell, john, julie, christy, tim2)

  /* Test: Insert Elements. */
  val hash = new Hasher[String, Dummy](3)
  for (d <- dummies) {
    println(hash.put(d.getName, d))
  }

  hash.printTable()

  /* Test: Recall */
  for (d <- dummies) {
    val name = d.getName
    val dummy = hash.get(name)
    if (dummy == null) {
      println(s"Dummy named $name: null")
    } else {
      println(s"Dummy named $name: ${dummy.toString}")
    }
    val d2 = hash.remove(name)
    if (d2 == null) {
      println(s"Dummy removed named $name: null")
    } else {
      println(s"Dummy removed named $name: ${d2.toString}")
    }
  }
}
