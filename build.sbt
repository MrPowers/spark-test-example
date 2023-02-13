name := "spark-test-example"

version := "0.0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

libraryDependencies += "com.github.mrpowers" %% "spark-daria" % "0.39.0"

libraryDependencies += "com.github.mrpowers" %% "spark-fast-tests" % "0.23.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:+CMSClassUnloadingEnabled")