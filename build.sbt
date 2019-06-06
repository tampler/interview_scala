name := "interview"
version := "1.0"
scalaVersion := "2.12.8"
maxErrors := 3

libraryDependencies ++= Seq(
  // Main
  "org.scalaz"    %% "scalaz-zio"             % "0.6.1", 
  "org.scalatest" %% "scalatest"              % "3.0.5" % "test"
)

 scalacOptions := Seq(
      "-Xlint", 
      "-feature",
      "-deprecation",
      "-explaintypes",
      "-unchecked",
      "-Xfuture",
      "-encoding", "UTF-8",
      "-language:higherKinds",
      "-language:existentials",
      "-Ypartial-unification",
      //"-Xfatal-warnings",
      "-Xlint:-infer-any,_",
      "-Ywarn-value-discard",
      "-Ywarn-numeric-widen",
      "-Ywarn-extra-implicit",
      "-Ywarn-unused:_",
      "-Ywarn-inaccessible",
      "-Ywarn-nullary-override",
      "-Ywarn-nullary-unit",
      "-opt:l:inline"
)

// Lint
scapegoatVersion in ThisBuild := "1.3.8"
scalaBinaryVersion in ThisBuild := "2.12"

