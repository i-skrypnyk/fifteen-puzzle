package com.fifteen.puzzle.input

import com.fifteen.puzzle.model.UserAction

object ConsoleInputHandler extends InputHandler {
  override def handleUserInput(): UserAction.Action = {
    Console.readLine() match {
      case "w" | "W" => UserAction.MoveDown
      case "s" | "S" => UserAction.MoveUp
      case "a" | "A" => UserAction.MoveRight
      case "d" | "D" => UserAction.MoveLeft
      case "q" | "Q" => UserAction.Quit
      case "r" | "R" => UserAction.Restart
      case _ => UserAction.Unknown
    }
  }
}
