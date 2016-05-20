name := "SparkProjects"
version := "1.0"
scalaVersion := "2.10.4"
//libraryDependencies += "org.apache.spark" %% "spark-core" % "1.2.0"
libraryDependencies ++= Seq("org.apache.spark" % "spark-core_2.10" % "1.2.1",
"org.apache.spark" % "spark-mllib_2.10" % "1.2.1")


ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}
resolvers += "Apache Repository" at "https://repository.apache.org/content/repositories/releases/"

