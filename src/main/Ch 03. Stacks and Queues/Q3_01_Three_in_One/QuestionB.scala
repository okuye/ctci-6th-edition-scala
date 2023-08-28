package Q3_01_Three_in_One

import CtCILibrary.AssortedMethods

object QuestionB {
  def printStacks(stacks: MultiStack): Unit = {
    println(AssortedMethods.arrayToString(stacks.getValues))
  }

  def main(args: Array[String]): Unit = {
    val stacks = new MultiStack(3, 4)
    printStacks(stacks)
    stacks.push(0, 10)
    printStacks(stacks)
    stacks.push(1, 20)
    printStacks(stacks)
    stacks.push(2, 30)
    printStacks(stacks)

    stacks.push(1, 21)
    printStacks(stacks)
    stacks.push(0, 11)
    printStacks(stacks)
    stacks.push(0, 12)
    printStacks(stacks)

    stacks.pop(0)
    printStacks(stacks)

    stacks.push(2, 31)
    printStacks(stacks)

    stacks.push(0, 13)
    printStacks(stacks)
    stacks.push(1, 22)
    printStacks(stacks)

    stacks.push(2, 31)
    printStacks(stacks)
    stacks.push(2, 32)
    printStacks(stacks)
    stacks.push(2, 33)
    printStacks(stacks)
    stacks.push(2, 34)
    printStacks(stacks)

    stacks.pop(1)
    printStacks(stacks)
    stacks.push(2, 35)
    printStacks(stacks)

    println(s"Final Stack: ${AssortedMethods.arrayToString(stacks.getValues)}")
  }
}
