package com.fifteen.puzzle.input

import java.util.Properties

object InputHandlerFactory {
  def getInputHandler(properties: Properties): InputHandler = {
    properties.getProperty("game.io.provider") match {
      case "console" => ConsoleInputHandler
      case t => throw new IllegalArgumentException(s"Cannot initialize Input Handler for type $t")
    }
  }
}
