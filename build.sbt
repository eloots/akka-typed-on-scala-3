val dottyVersion = "0.22.0-RC1"
//val selectedScalaVersion = dottyVersion
val selectedScalaVersion = dottyLatestNightlyBuild.get

lazy val root_project = (project.in(file(".")))
  .aggregate(
    common,
    exercise
  ).settings(
    name := "dotty-simple",
    version := "0.1.0",
    //scalaVersion := dottyLatestNightlyBuild.get,
    scalaVersion := selectedScalaVersion,
  ).settings(CommonSettings.commonSettings: _*)

lazy val common = project
  .settings(scalaVersion := selectedScalaVersion)
  .settings(CommonSettings.commonSettings: _*)


lazy val exercise = project
  .settings(scalaVersion := selectedScalaVersion)
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")

