package Q7_03_Jukebox

class SongSelector(private var currentSong: Song) {
  def setSong(s: Song): Unit = currentSong = s
  def getCurrentSong: Song = currentSong
}
