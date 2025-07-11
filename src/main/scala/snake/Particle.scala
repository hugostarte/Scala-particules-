package snake

import scalafx.scene.paint.Color
import scala.util.Random

final case class Particle(
  position: Coordinates,
  direction: Direction,
  color: Color,
  radius: Double
) {
  def move(maxX: Int, maxY: Int): Particle = {
    val newPosition = position.move(direction, maxX, maxY)
    
    if (newPosition.x < 0 || newPosition.x >= maxX || 
        newPosition.y < 0 || newPosition.y >= maxY) {
      val newDirection = bounceOffWall(direction, position, maxX, maxY)
      copy(direction = newDirection)
    } else {
     
      copy(position = newPosition)
    }
  }
  
  private def bounceOffWall(direction: Direction, position: Coordinates, maxX: Int, maxY: Int): Direction = {
    direction match {
      case Direction.NORTH_WEST if position.x == 0 => Direction.NORTH_EAST
      case Direction.WEST if position.x == 0 => Direction.EAST
      case Direction.SOUTH_WEST if position.x == 0 => Direction.SOUTH_EAST
      
      case Direction.NORTH_WEST if position.x == maxX - 1 => Direction.SOUTH_WEST
      case Direction.NORTH_EAST if position.x == maxX - 1 => Direction.NORTH_WEST
      case Direction.EAST if position.x == maxX - 1 => Direction.WEST
      case Direction.SOUTH_EAST if position.x == maxX - 1 => Direction.SOUTH_WEST
      
      case Direction.NORTH_WEST if position.y == 0 => Direction.SOUTH_WEST
      case Direction.NORTH if position.y == 0 => Direction.SOUTH
      case Direction.NORTH_EAST if position.y == 0 => Direction.SOUTH_EAST
      
      case Direction.SOUTH_WEST if position.y == maxY - 1 => Direction.NORTH_WEST
      case Direction.SOUTH if position.y == maxY - 1 => Direction.NORTH
      case Direction.SOUTH_EAST if position.y == maxY - 1 => Direction.NORTH_EAST
      
      case _ => direction
    }
  }
  
  def changeDirection(): Particle = {
   
    copy(direction = Direction.random())
  }
}

object Particle {
  def random(maxX: Int, maxY: Int): Particle = {
    Particle(
      position = Coordinates.random(maxX, maxY),
      direction = Direction.random(),
      color = randomColor(),
      radius = 5.0 
    )
  }
  
  private def randomColor(): Color = {
    val colors = List(
      Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Purple,
      Color.Orange, Color.Pink, Color.Cyan, Color.Magenta, Color.Brown
    )
    colors(Random.nextInt(colors.length))
  }
} 