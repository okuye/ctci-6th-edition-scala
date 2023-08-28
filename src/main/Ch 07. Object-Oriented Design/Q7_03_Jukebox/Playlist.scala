package Q7_03_Jukebox

import scala.collection.mutable.Queue

class Playlist(private var song: Song, private var queue: Queue[Song]) {

  def getNextSongToPlay: Song = queue.headOption.getOrElse(null)

  def queueUpSong(s: Song): Unit = {
    queue.enqueue(s)
  }
}
