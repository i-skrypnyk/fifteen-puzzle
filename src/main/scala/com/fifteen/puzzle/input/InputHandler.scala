package com.fifteen.puzzle.input

import com.fifteen.puzzle.model.UserAction

trait InputHandler {
  def handleUserInput(): UserAction.Action
}
