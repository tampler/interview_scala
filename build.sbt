name := "interview"
version := "1.0"
scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  // Main
  "org.scalaz"    %% "scalaz-core"            % "7.3.0-M27",
  "org.scalaz"    %% "scalaz-zio"             % "0.6.1", 
  "org.scalatest" %% "scalatest"              % "3.0.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos", "-Xlint")

// Lint
scapegoatVersion in ThisBuild := "1.3.8"
scalaBinaryVersion in ThisBuild := "2.12"

