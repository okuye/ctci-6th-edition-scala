package Q17_07_Baby_Names

import scala.collection.mutable

object QuestionA {

  def constructGroups(names: Map[String, Int]): mutable.Map[String, NameSet] = {
    val groups = mutable.Map[String, NameSet]()
    for ((name, frequency) <- names) {
      val group = new NameSet(name, frequency)
      groups(name) = group
    }
    groups
  }

  def mergeClasses(groups: mutable.Map[String, NameSet], synonyms: Array[Array[String]]): Unit = {
    for (entry <- synonyms) {
      val name1 = entry(0)
      val name2 = entry(1)
      val set1 = groups(name1)
      val set2 = groups(name2)
      if (set1 != set2) {
        val smaller = if (set2.size < set1.size) set2 else set1
        val bigger = if (set2.size < set1.size) set1 else set2

        val otherNames = smaller.getNames
        val frequency = smaller.getFrequency
        bigger.copyNamesWithFrequency(otherNames, frequency)

        for (name <- otherNames) {
          groups(name) = bigger
        }
      }
    }
  }

  def convertToMap(groups: mutable.Map[String, NameSet]): Map[String, Int] = {
    groups.mapValues(_.getFrequency).toMap
  }

  def trulyMostPopular(names: Map[String, Int], synonyms: Array[Array[String]]): Map[String, Int] = {
    val groups = constructGroups(names)
    mergeClasses(groups, synonyms)
    convertToMap(groups)
  }

  def main(args: Array[String]): Unit = {
    val names = Map(
      "John" -> 3,
      "Jonathan" -> 4,
      "Johnny" -> 5,
      "Chris" -> 1,
      "Kris" -> 3,
      "Brian" -> 2,
      "Bryan" -> 4,
      "Carleton" -> 4
    )

    val synonyms = Array(
      Array("John", "Jonathan"),
      Array("Jonathan", "Johnny"),
      Array("Chris", "Kris"),
      Array("Brian", "Bryan")
    )

    val finalList = trulyMostPopular(names, synonyms)
    for ((name, frequency) <- finalList) {
      println(s"$name: $frequency")
    }
  }

}
