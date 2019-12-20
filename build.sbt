lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-simple",
    version := "0.1.0",

    scalaVersion := "2.13.1",

    libraryDependencies += ("com.typesafe.akka" %% "akka-actor-typed" % "2.6.1"),
    libraryDependencies += ("com.typesafe.akka" %% "akka-slf4j" % "2.6.1"),
    libraryDependencies += ("ch.qos.logback"     % "logback-classic" % "1.2.3")
  )
