name := """pm"""
organization := "com.example.pm"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.5"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.3"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1212"


//libraryDependencies += "com.h2database" % "h2" % "1.4.196"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.pm.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.pm.binders._"