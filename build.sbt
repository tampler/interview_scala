name := "interview"
version := "1.0"
scalaVersion := "2.12.8"

scalacOptions in Test ++= Seq("-Yrangepos")

// Lint
scapegoatVersion in ThisBuild := "1.3.8"
scalaBinaryVersion in ThisBuild := "2.12"

