name := "interview"
version := "1.0"
scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  // Main
  "org.scalaz"    %% "scalaz-core"            % "7.3.0-M27",
  "org.scalaz"    %% "scalaz-effect"          % "7.3.0-M27",
  "org.scalaz"    %% "scalaz-concurrent"      % "7.3.0-M27",
  //"io.argonaut"   %% "argonaut"               % "6.2.2",
  //"org.scala-stm" %% "scala-stm"              % "0.8",
  //"org.scalacheck"%% "scalacheck"             % "1.14.0" % "test",
  //"org.specs2"    %% "specs2-core"            % "4.3.5"  % "test",
  "org.scalactic" %% "scalactic"              % "3.0.5",
  "org.scalatest" %% "scalatest"              % "3.0.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos", "-Xlint")

// Lint
scapegoatVersion in ThisBuild := "1.3.8"
scalaBinaryVersion in ThisBuild := "2.12"

