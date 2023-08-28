package Q7_03_Jukebox

class CDPlayer(var p: Playlist, var c: Option[CD] = None) {

  def getPlaylist: Playlist = p

  def setPlaylist(p: Playlist): Unit = {
    this.p = p
  }

  def getCD: Option[CD] = c

  def setCD(c: CD): Unit = {
    this.c = Some(c)
  }

  def playSong(s: Song): Unit = {
    // Implementation for playing the song
  }
}
