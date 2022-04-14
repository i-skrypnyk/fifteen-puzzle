package com.fifteen.puzzle.output

import java.util.Properties

object OutputHandlerFactory {

  def getOutputHandler(properties: Properties): OutputHandler = {
    properties.getProperty("game.io.provider") match {
      case "console" => ConsoleOutputHandler
      case t => throw new IllegalArgumentException(s"Cannot initialize Output Handler for type $t")
    }
  }
}
