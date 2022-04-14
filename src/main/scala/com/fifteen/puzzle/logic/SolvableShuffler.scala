package com.fifteen.puzzle.logic

import com.fifteen.puzzle.model.Board

import scala.util.Random

object SolvableShuffler {

  def shuffleBoard(initBoard: Board, moves: Int = 1000): Board = {
    (1 to moves)
      .foldLeft(initBoard) { case (board: Board, _: Int) =>
        val moves = List(
          (board.canMoveUp, () => board.moveUp),
          (board.canMoveDown, () => board.moveDown),
          (board.canMoveRight, () => board.moveRight),
          (board.canMoveLeft, () => board.moveLeft)
        ).filter(_._1).map(_._2)
        moves(Random.nextInt(moves.size)).apply()
      }
  }




}
