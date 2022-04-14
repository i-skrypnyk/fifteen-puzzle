package com.fifteen.puzzle.model

object UserAction extends Enumeration {
  type Action = Value

  val MoveUp, MoveDown, MoveLeft, MoveRight, Restart, Quit, Unknown = Value
}
