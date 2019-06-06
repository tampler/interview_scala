resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases"
)

addSbtPlugin("org.scalameta"             % "sbt-scalafmt"  % "2.0.0")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"  % "0.1.6")
addSbtPlugin("org.scoverage"             % "sbt-scoverage" % "1.5.1")
