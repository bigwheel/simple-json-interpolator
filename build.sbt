ThisBuild / organization := "com.github.bigwheel"
ThisBuild / version := "1.0"
ThisBuild / scalaVersion := "2.12.6"

// about maven publish
ThisBuild / publishMavenStyle := true
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

ThisBuild / publishArtifact in Test := false
ThisBuild / licenses := Seq("BSD-3-Clause" -> url("https://github.com/bigwheel/simple-json-interpolator/blob/master/LICENSE"))
ThisBuild / homepage := Some(url("https://github.com/bigwheel/simple-json-interpolator"))
ThisBuild / pomExtra := (
  <scm>
    <url>git@github.com:bigwheel/simple-json-interpolator.git</url>
    <connection>scm:git:git@github.com:bigwheel/simple-json-interpolator.git</connection>
  </scm>
    <developers>
      <developer>
        <id>bigwheel</id>
        <name>k.bigwheel</name>
        <url>https://github.com/bigwheel</url>
      </developer>
    </developers>
  )

lazy val core = project
  .settings(
    name := "simple-json-interpolator"
  )

lazy val readerSprayjson = project
  .dependsOn(core)
  .settings(
    name := "simple-json-interpolator-reader-sprayjson",
    libraryDependencies += "io.spray" %%  "spray-json" % "[1.3.4,)"
  )

lazy val readerArgonaut = project
  .dependsOn(core)
  .settings(
    name := "simple-json-interpolator-reader-argonaut",
    libraryDependencies += "io.argonaut" %% "argonaut" % "[6.2,)"
  )

lazy val test = project
  .dependsOn(
    core % Test,
    readerSprayjson % Test,
    readerArgonaut % Test
  )
  .settings(
    name := "simple-json-interpolator-test",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    skip in publish := true
  )
