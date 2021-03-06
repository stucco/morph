import sbt._
import Keys._

object MorphBuild extends Build {
  lazy val root = Project("morph", file("."))
    .dependsOn(jsonjava)

  // This has to be the customized JSON-java that is hosted
  // on GitHub at stucco/JSON-java
  //
  // The required version is tagged 'morph'
  lazy val jsonjava = GitHub("stucco", "JSON-java", "morph")

  def GitHub(user: String, project: String, tag: String) =
    RootProject(
      uri("https://github.com/%s/%s.git#%s".format(user, project, tag))
    )
}
