package Q7_10_Minesweeper

class UserPlayResult(private val success: Boolean, private val resultingState: GameState.Value) {
  def successfulMove(): Boolean = success
  def getResultingState(): GameState.Value = resultingState
}
