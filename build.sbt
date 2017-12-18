import Dependencies._

val versions = Map(
  "akka-http" -> "10.0.11",
  "akka" -> "2.5.8"
)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "darkDesire",
      scalaVersion := "2.12.3",
      version      := "0.0.1"
    )),
    name := "DiscordTrigger",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.typesafe" % "config" % "1.3.1",
      "com.typesafe.akka" %% "akka-actor" % versions("akka"),
      "com.typesafe.akka" %% "akka-testkit" %  versions("akka") % Test,
      "com.typesafe.akka" %% "akka-stream" %  versions("akka"),
      "com.typesafe.akka" %% "akka-stream-testkit" %  versions("akka") % Test,
      "com.typesafe.akka" %% "akka-http" % versions("akka-http"),
      "com.typesafe.akka" %% "akka-http-testkit" % versions("akka-http") % Test
    )
  )
