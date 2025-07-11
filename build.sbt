scalaVersion := "3.7.1"

libraryDependencies ++= Seq(
  "org.scalafx"   %% "scalafx"   % "24.0.0-R35",
  "org.scalatest" %% "scalatest" % "3.2.19" % "test"
)

Compile / run / mainClass := Some("snake.Main")