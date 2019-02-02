
resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "http://oss.sonatype.org/content/repositories/releases"
)

addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.0.9")
