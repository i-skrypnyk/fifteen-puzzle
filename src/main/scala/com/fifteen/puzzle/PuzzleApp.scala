package com.fifteen.puzzle

import com.fifteen.puzzle.input.InputHandlerFactory
import com.fifteen.puzzle.logic.Game
import com.fifteen.puzzle.output.OutputHandlerFactory

import java.io.FileNotFoundException
import java.util.Properties
import scala.io.Source

object PuzzleApp extends App {

  val properties = readProperties()

  new Game(
    OutputHandlerFactory.getOutputHandler(properties),
    InputHandlerFactory.getInputHandler(properties),
    properties.getProperty("game.size", "4").toInt,
    properties.getProperty("game.shuffles", "1000").toInt
  )
    .start()

  def readProperties() = {
    val url = getClass.getResource("/application.properties")
    val properties: Properties = new Properties()

    if (url != null) {
      val source = Source.fromURL(url)
      properties.load(source.bufferedReader())
    }
    else {
      throw new FileNotFoundException("Properties file not found")
    }
    properties
  }

}
