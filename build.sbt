val dottyVersion = "0.22.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-simple",
    version := "0.1.0",

    //scalaVersion := dottyLatestNightlyBuild.get,
    scalaVersion := dottyVersion,

    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",

    libraryDependencies ++= Seq(
       "com.typesafe.akka" %% "akka-actor-typed" % "2.6.3",
       "com.typesafe.akka" %% "akka-slf4j"       % "2.6.3",
       "org.scalatest"     %% "scalatest"        % "3.1.0" % "test",
    ).map(_.withDottyCompat(scalaVersion.value))
  )
