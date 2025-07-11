package snake

import scalafx.scene.shape.Circle
import scalafx.scene.paint.Color
import scala.util.Random

final case class GameState(particles: List[Particle]) {
  def draw(cellSize: Int): List[Circle] = {
    particles.map { particle =>
      new Circle {
        centerX = particle.position.x * cellSize + cellSize / 2.0
        centerY = particle.position.y * cellSize + cellSize / 2.0
        radius = particle.radius
        fill = particle.color
      }
    }
  }

  def move(numberOfCells: Int): GameState = {
    val movedParticles = particles.map(_.move(numberOfCells, numberOfCells))
    
    val particlesAfterCollisions = movedParticles.map { particle =>
      val isColliding = movedParticles.exists { other => 
        if (other == particle) false
        else {
          val samePosition = particle.position == other.position
          val adjacentX = math.abs(particle.position.x - other.position.x) <= 1
          val adjacentY = math.abs(particle.position.y - other.position.y) <= 1
          
          samePosition || (adjacentX && adjacentY)
        }
      }
      
      if (isColliding) {
        val newDirection = Direction.random()
        val newPosition = particle.position.move(newDirection, numberOfCells, numberOfCells)
        particle.copy(direction = newDirection, position = newPosition)
      } else {
        particle
      }
    }
    
    copy(particles = particlesAfterCollisions)
  }
}

object GameState {
  def random(numberOfParticles: Int, numberOfCells: Int): GameState = {
    GameState(List.fill(numberOfParticles)(Particle.random(numberOfCells, numberOfCells)))
  }
}

