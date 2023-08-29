package Q16_04_Tic_Tac_Win

sealed trait Piece

object Piece {
  case object Empty extends Piece
  case object Red extends Piece
  case object Blue extends Piece
}
