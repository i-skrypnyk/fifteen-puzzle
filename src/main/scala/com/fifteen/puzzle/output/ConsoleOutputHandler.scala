package com.fifteen.puzzle.output

import com.fifteen.puzzle.model.Board

object ConsoleOutputHandler extends OutputHandler {
  override def displayGameData(board: Board, message: Option[String] = None): Unit = {
    print("\033[H\033[2J")

    message.foreach(println)
    println("WASD for moving, Q to quit, R to restart.\n")
    (0 until board.size)
      .foreach { row =>
        println(board.tiles(row)
          .map(x => if (x != 0) "| %2d".format(x) else "|   ")
          .mkString(""," ", " |"))
      }
  }

  override def goodbyeMessage(): Unit = {
    print("\033[H\033[2J")
    println("See you around")
  }

  override def winMessage(): Unit = {
    print("\033[H\033[2J")
    println("Congrats! You Wix!")
    println("Q to quit, R to restart")
  }


}
