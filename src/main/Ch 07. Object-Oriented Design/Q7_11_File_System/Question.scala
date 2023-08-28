package Q7_11_File_System

object Question extends App {
  val root = new Directory("Food", None)
  val taco = new File("Taco", Some(root), 4)
  val hamburger = new File("Hamburger", Some(root), 9)
  root.addEntry(taco)
  root.addEntry(hamburger)

  val healthy = new Directory("Healthy", Some(root))

  val fruits = new Directory("Fruits", Some(healthy))
  val apple = new File("Apple", Some(fruits), 5)
  val banana = new File("Banana", Some(fruits), 6)
  fruits.addEntry(apple)
  fruits.addEntry(banana)

  healthy.addEntry(fruits)

  val veggies = new Directory("Veggies", Some(healthy))
  val carrot = new File("Carrot", Some(veggies), 6)
  val lettuce = new File("Lettuce", Some(veggies), 7)
  val peas = new File("Peas", Some(veggies), 4)
  veggies.addEntry(carrot)
  veggies.addEntry(lettuce)
  veggies.addEntry(peas)

  healthy.addEntry(veggies)

  root.addEntry(healthy)

  println(root.numberOfFiles)
  println(veggies.getFullPath)
}
