package Q16_25_LRU_Cache

import scala.jdk.CollectionConverters._

object Question {
  def main(args: Array[String]): Unit = {
    val cache_size = 5
    val cache = new Cache(cache_size)

    cache.setKeyValue(1, "1")
    println(cache.getCacheAsString())
    cache.setKeyValue(2, "2")
    println(cache.getCacheAsString())
    cache.setKeyValue(3, "3")
    println(cache.getCacheAsString())
    cache.getValue(1)
    println(cache.getCacheAsString())
    cache.setKeyValue(4, "4")
    println(cache.getCacheAsString())
    cache.getValue(2)
    println(cache.getCacheAsString())
    cache.setKeyValue(5, "5")
    println(cache.getCacheAsString())
    cache.getValue(5)
    println(cache.getCacheAsString())
    cache.setKeyValue(6, "6")
    println(cache.getCacheAsString())
    cache.getValue(1)
    println(cache.getCacheAsString())
    cache.setKeyValue(5, "5a")
    println(cache.getCacheAsString())
    cache.getValue(3)
    println(cache.getCacheAsString())
  }

  class Cache(cacheSize: Int) {
    private val cache = new java.util.LinkedHashMap[Int, String](cacheSize, 0.75f, true) {
      override def removeEldestEntry(eldest: java.util.Map.Entry[Int, String]): Boolean = size() > cacheSize
    }

    def setKeyValue(key: Int, value: String): Unit = {
      cache.put(key, value)
    }

    def getValue(key: Int): String = {
      cache.getOrDefault(key, "")
    }

    def getCacheAsString(): String = {
      cache.entrySet().asScala.map(entry => s"${entry.getKey} -> ${entry.getValue}").mkString("->")
    }
  }
}