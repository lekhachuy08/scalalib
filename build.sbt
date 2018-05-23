lazy val root = project.in(file(".")).
  aggregate(engineJS, engineJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val engine = crossProject.in(file(".")).
  settings(
    organization := "com.github.ornicar",
    name := "scalalib",
    version := "6.6",
    scalaVersion := "2.12.4",
    libraryDependencies += "org.scalaz" %%% "scalaz-core" % "7.2.15",
    scalacOptions := Seq(
      "-deprecation",
      "-unchecked",
      "-feature",
      "-language:_",
      "-Xfatal-warnings"),
    licenses += "MIT" -> url("http://opensource.org/licenses/MIT"),
    resolvers ++= Seq(
      "sonatype" at "http://oss.sonatype.org/content/repositories/releases"
    )
  ).
  jsSettings(
  )

lazy val engineJVM = engine.jvm
lazy val engineJS = engine.js
