import Dependencies._

ThisBuild / organization := "org.cscie88c"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / semanticdbEnabled := true // enable SemanticDB
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision // use Scalafix compatible version

lazy val root = (project in file(".")).
  settings(
    name := "2022SpringScalaIntro",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:postfixOps",
      "-language:higherKinds", // HKT required for Monads and other HKT types
      "-Wunused", // for scalafix
    ),
// <<<<<<< HEAD
    // libraryDependencies ++= Dependencies.core ++ Dependencies.scalaTest ++ Dependencies.algeBird,
    // assembly / mainClass := Some("org.cscie88c.MainApp"),
    // assembly / assemblyJarName := "2022SpringScalaIntro.jar",
// =======
    libraryDependencies ++= Dependencies.core ++ Dependencies.scalaTest,
    // assembly / mainClass := Some("org.cscie88c.MainApp"),
    // assembly / assemblyJarName := "2022SpringScalaIntro.jar",
    assembly / mainClass := Some("org.cscie88c.week11.SparkAverageTransactionAggregateJob"),
    assembly / assemblyJarName := "2022SpringSparkJob.jar",
// >>>>>>> a7501d877ce3c560b518071a2704d450e0d8820d
    assembly / test := {},
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case "application.conf"            => MergeStrategy.concat
      case x =>
        val oldStrategy = (assembly / assemblyMergeStrategy).value
        oldStrategy(x)
    },
    // see shading feature at https://github.com/sbt/sbt-assembly#shading
    assembly / assemblyShadeRules := Seq(
      ShadeRule.rename("shapeless.**" -> "shadeshapeless.@1").inAll
    )
  )

// Custom task to zip files for homework submission
lazy val zipHomework = taskKey[Unit]("zip files for homework submission")

zipHomework := {
  val bd = baseDirectory.value
  val targetFile = s"${bd.getAbsolutePath}/scalaHomework.zip"
  val ignoredPaths =
    ".*(\\.idea|target|\\.DS_Store|\\.bloop|\\.metals|\\.vsc)/*".r.pattern
  val fileFilter = new FileFilter {
    override def accept(f: File) =
      !ignoredPaths.matcher(f.getAbsolutePath).lookingAt
  }
  println("zipping homework files ...")
  IO.delete(new File(targetFile))
  IO.zip(
    Path.selectSubpaths(new File(bd.getAbsolutePath), fileFilter),
    new File(targetFile)
  )
}

