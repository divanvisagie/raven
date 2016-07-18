name := "raven"
moduleName := "raven"
version := "0.0.1"
publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/content/repositories/snapshots")
licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
homepage := Some(url("https://github.com/scalaza/raven"))
scalaVersion := "2.11.7"

lazy val versions = new {
  val utils = "6.35.0"
  val scalatest = "2.2.4"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "util-core" % versions.utils,
  "org.scalatest" %% "scalatest" % versions.scalatest,

  "org.scalatest" %% "scalatest" % versions.scalatest % "test"
)


