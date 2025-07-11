package snake

import scala.util.Random

final case class Coordinates(x: Int, y: Int) {
  def move(direction: Direction, maxX: Int, maxY: Int): Coordinates = {
    val (newX, newY) = direction match {
      case Direction.NORTH => (x, y - 1)
      case Direction.NORTH_EAST => (x + 1, y - 1)
      case Direction.EAST => (x + 1, y)
      case Direction.SOUTH_EAST => (x + 1, y + 1)
      case Direction.SOUTH => (x, y + 1)
      case Direction.SOUTH_WEST => (x - 1, y + 1)
      case Direction.WEST => (x - 1, y)
      case Direction.NORTH_WEST => (x - 1, y - 1)
    }
    
    Coordinates(newX, newY)
  }
}

object Coordinates {
  def random(maxX: Int, maxY: Int): Coordinates = {
    Coordinates(Random.nextInt(maxX), Random.nextInt(maxY))
  }
}
