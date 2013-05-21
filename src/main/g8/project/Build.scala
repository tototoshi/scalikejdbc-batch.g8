import sbt._
import Keys._

import com.typesafe.sbt.SbtStartScript

object MyBuild extends Build {

  lazy val root = Project (
    id = "$name;format="hyphen"$",
    base = file ("."),
    settings = Defaults.defaultSettings ++ Seq (
      name := "$name$",
      organization := "$organization$",
      scalaVersion := "$scalaVersion$",
      libraryDependencies ++= Seq(
        "org.slf4j" % "slf4j-simple" % "1.7.2",
        "com.github.seratch" %% "scalikejdbc" % "[1.6,)",
        "com.github.seratch" %% "scalikejdbc-config" % "[1.6,)",
        "com.github.seratch" %% "scalikejdbc-interpolation" % "[1.6,)",
        "com.h2database" % "h2" % "[1.3,)",
        //"postgresql" % "postgresql" % "9.1-901.jdbc4"
        "org.scalatest" %% "scalatest" % "1.9.1" % "test"
      ),
      scalacOptions <<= scalaVersion.map { sv =>
        if (sv.startsWith("2.10")) {
          Seq(
            "-deprecation",
            "-language:_"
          )
        } else {
          Seq("-deprecation")
        }
      }
    ) ++ SbtStartScript.startScriptForClassesSettings
  )
}

