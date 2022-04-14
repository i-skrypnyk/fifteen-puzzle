package com.fifteen.puzzle.model

import java.awt.Point

case class Board(size: Int,
                 tiles: Array[Array[Int]],
                 emptyTile: Point
                ) {
  def isSolved: Boolean = {
    tiles.flatten
      .take(size * size - 1)
      .sliding(2)
      .forall { case Array(x, y) => x < y }
  }

  def canMoveUp: Boolean = emptyTile.x > 0
  def canMoveDown: Boolean = emptyTile.x < size - 1
  def canMoveLeft: Boolean = emptyTile.y > 0
  def canMoveRight: Boolean = emptyTile.y < size - 1

  def moveUp: Board = {
    if (!canMoveUp) throw new UnsupportedOperationException("Can't move blank field up")
    val newTiles = tiles.map(_.clone())
    val temp = newTiles(emptyTile.x - 1)(emptyTile.y)
    newTiles(emptyTile.x - 1)(emptyTile.y) = 0
    newTiles(emptyTile.x)(emptyTile.y) = temp
    Board(size = size, tiles = newTiles, emptyTile = new Point(emptyTile.x - 1, emptyTile.y))
  }

  def moveDown: Board = {
    if (!canMoveDown) throw new UnsupportedOperationException("Can't move blank field down")
    val newTiles = tiles.map(_.clone())
    val temp = newTiles(emptyTile.x + 1)(emptyTile.y)
    newTiles(emptyTile.x + 1)(emptyTile.y) = 0
    newTiles(emptyTile.x)(emptyTile.y) = temp
    Board(size = size, tiles = newTiles, emptyTile = new Point(emptyTile.x + 1, emptyTile.y))
  }

  def moveLeft: Board = {
    if (!canMoveLeft) throw new UnsupportedOperationException("Can't move blank field left")
    val newTiles = tiles.map(_.clone())
    val temp = newTiles(emptyTile.x)(emptyTile.y - 1)
    newTiles(emptyTile.x)(emptyTile.y - 1) = 0
    newTiles(emptyTile.x)(emptyTile.y) = temp
    Board(size = size, tiles = newTiles, emptyTile = new Point(emptyTile.x, emptyTile.y - 1))
  }

  def moveRight: Board = {
    if (!canMoveRight) throw new UnsupportedOperationException("Can't move blank field right")
    val newTiles = tiles.map(_.clone())
    val temp = newTiles(emptyTile.x)(emptyTile.y + 1)
    newTiles(emptyTile.x)(emptyTile.y + 1) = 0
    newTiles(emptyTile.x)(emptyTile.y) = temp
    Board(size = size, tiles = newTiles, emptyTile = new Point(emptyTile.x, emptyTile.y + 1))
  }
}

object Board {

  def solvedBoard(size: Int = 4): Board = {
    val tiles = Array.ofDim[Int](size, size)
    var num = 0
    for {
      i <- 0 until size
      j <- 0 until size
    } {
      num += 1
      if (i == size - 1 && j == size - 1)
        tiles(i)(j) = 0
      else
        tiles(i)(j) = num
    }
    Board(size, tiles, new Point(size - 1, size - 1))
  }
}
