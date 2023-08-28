package Introduction

import CtCILibrary.AssortedMethods

object MergeSort {

  def mergesort(array: Array[Int]): Unit = {
    val helper = new Array[Int](array.length)
    mergesort(array, helper, 0, array.length - 1)
  }

  def mergesort(array: Array[Int], helper: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      val middle = low + (high - low) / 2
      mergesort(array, helper, low, middle)
      mergesort(array, helper, middle + 1, high)
      merge(array, helper, low, middle, high)
    }
  }

  def merge(array: Array[Int], helper: Array[Int], low: Int, middle: Int, high: Int): Unit = {
    for (i <- low to high) {
      helper(i) = array(i)
    }

    var helperLeft = low
    var helperRight = middle + 1
    var current = low

    while (helperLeft <= middle && helperRight <= high) {
      if (helper(helperLeft) <= helper(helperRight)) {
        array(current) = helper(helperLeft)
        helperLeft += 1
      } else {
        array(current) = helper(helperRight)
        helperRight += 1
      }
      current += 1
    }

    val remaining = middle - helperLeft
    for (i <- 0 to remaining) {
      array(current + i) = helper(helperLeft + i)
    }
  }

  def main(args: Array[String]): Unit = {
    val size = 20
    val array = AssortedMethods.randomArray(size, 0, size - 1)
    val validate = new Array[Int](size)
    AssortedMethods.printIntArray(array)
    for (i <- array.indices) {
      validate(array(i)) = validate(array(i)) + 1
    }
    mergesort(array)
    for (i <- array.indices) {
      validate(array(i)) = validate(array(i)) - 1
    }
    AssortedMethods.printIntArray(array)
    for (i <- array.indices) {
      if (validate(i) != 0 || (i < (size - 1) && array(i) > array(i + 1))) {
        println("ERROR")
      }
    }
  }
}
