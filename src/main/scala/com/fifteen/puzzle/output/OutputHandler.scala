package com.fifteen.puzzle.output

import com.fifteen.puzzle.model.Board

trait OutputHandler {
  def winMessage(): Unit

  def goodbyeMessage(): Unit

  def displayGameData(board: Board, message: Option[String] = None): Unit
}
