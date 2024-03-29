import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName = "FearMyPower"
    val appVersion = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "javax.mail" % "mail" % "1.4.5",
      "mysql" % "mysql-connector-java" % "5.1.18"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here
    )

}