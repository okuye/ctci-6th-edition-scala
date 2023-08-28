package Q7_03_Jukebox

class JukeBox(cdPlayer: CDPlayer, var user: User, cdCollection: Set[CD], ts: SongSelector) {

  def getCurrentSong: Song = ts.getCurrentSong

  def setUser(u: User): Unit = {
    this.user = u
  }
}
