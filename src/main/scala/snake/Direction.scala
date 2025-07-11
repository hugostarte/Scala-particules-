package snake

import scala.util.Random

enum Direction {
  case NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST
}

object Direction {
  def random(): Direction = {
    val directions = Direction.values
    directions(Random.nextInt(directions.length))
  }
  
}
