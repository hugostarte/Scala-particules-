package snake

import scalafx.animation.KeyFrame
import scalafx.animation.Timeline
import scalafx.animation.Timeline.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.ObjectProperty
import scalafx.scene.Scene
import scalafx.scene.paint.Color.*
import scalafx.util.Duration

object Main extends JFXApp3 {

  private val windowSize: Int = 1000
  val cellSize: Int           = 4
  val numberOfCells: Int      = windowSize / cellSize
  val numberOfParticles: Int  = 200

  override def start(): Unit = {
    val gameState: ObjectProperty[GameState] = ObjectProperty(
      GameState.random(numberOfParticles, numberOfCells)
    )

    stage = new PrimaryStage {
      title = "Particuuuules"
      width = windowSize
      height = windowSize
      scene = new Scene {
        fill = White
        content = gameState.value.draw(cellSize)
        gameState.onChange {
          content = gameState.value.draw(cellSize)
        }
      }
    }

    new Timeline {
      keyFrames = List(
        KeyFrame(
          time = Duration(30),
          onFinished = _ => gameState.update(gameState.value.move(numberOfCells))
        )
      )
      cycleCount = Indefinite
    }.play()
  }
}
