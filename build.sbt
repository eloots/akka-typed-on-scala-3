val dottyVersion = "0.21.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-simple",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",

    libraryDependencies += ("com.typesafe.akka" %% "akka-actor-typed" % "2.6.1").withDottyCompat(scalaVersion.value),
    libraryDependencies += ("com.typesafe.akka" %% "akka-slf4j" % "2.6.1").withDottyCompat(scalaVersion.value),
    libraryDependencies += ("ch.qos.logback"     % "logback-classic" % "1.2.3").withDottyCompat(scalaVersion.value)
  )
