import sbt._
import sbt.Keys._
import dotty.tools.sbtplugin.DottyPlugin.autoImport.DottyCompatModuleID


object CommonSettings {
  lazy val commonSettings = Seq(
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",

    libraryDependencies ++= Seq(
       "com.typesafe.akka" %% "akka-actor-typed" % "2.6.3",
       "com.typesafe.akka" %% "akka-slf4j"       % "2.6.3",
       "org.scalatest"     %% "scalatest"        % "3.1.0" % "test",
    ).map(_.withDottyCompat(scalaVersion.value))
  )
}
