package com.fifteen.puzzle.logic

import com.fifteen.puzzle.input.InputHandler
import com.fifteen.puzzle.model.Board
import com.fifteen.puzzle.model.UserAction._
import com.fifteen.puzzle.output.OutputHandler

import scala.annotation.tailrec

class Game(outputHandler: OutputHandler, inputHandler: InputHandler, size: Int, shuffles: Int) {

  def start(): Unit = {
    val initBoard = Board.solvedBoard(size)
    val shuffledBoard = SolvableShuffler.shuffleBoard(initBoard, shuffles)
    move(shuffledBoard)
  }

  def quit(): Unit = {
    outputHandler.goodbyeMessage()
  }

  @tailrec
  final def win(): Unit = {
    outputHandler.winMessage()
    inputHandler.handleUserInput() match {
      case Restart => start()
      case Quit => quit()
      case _ => win()
    }
  }

  @tailrec
  final def move(board: Board, message: Option[String] = None): Unit = {
    if (board.isSolved)
      win()
    else {
      outputHandler.displayGameData(board, message)
      inputHandler.handleUserInput() match {
        case MoveUp if board.canMoveUp => move(board.moveUp)
        case MoveDown if board.canMoveDown => move(board.moveDown)
        case MoveLeft if board.canMoveLeft => move(board.moveLeft)
        case MoveRight if board.canMoveRight => move(board.moveRight)
        case Restart => start()
        case Quit => quit()
        case _ => move(board, Some("Unsupported command, try again"))
      }
    }
  }

}
