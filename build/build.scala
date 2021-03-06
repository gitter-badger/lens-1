import cbt._
import java.net._
import java.io.File
import scala.collection.immutable.Seq

// cbt:https://github.com/cvogt/cbt.git#cf7a66b7dfde8bb4386efe93a41f68996335db35
class Build(context: cbt.Context) extends cbt.PublishBuild(context){
  override def defaultScalaVersion = "2.11.8"

  override def defaultVersion = "1.0.0"
  override def artifactId = "lens"
  override def groupId = "ai.x"

  object monocle{
    val version = "1.2.0"
    val org = "com.github.julien-truffaut"
    val core = org %% "monocle-core" % version
    val generic = org %% "monocle-generic" % version
    val macro_ = org %% "monocle-macro" % version
    val all = Seq(core, generic, macro_)
  }

  override def dependencies = super.dependencies ++ Resolver( mavenCentral ).bind( monocle.all: _* )
  override def scalacOptions = super.scalacOptions ++ Seq( "-language:experimental.macros" )

  override def url = new URL("http://github.com/xdotai/lens")
  override def licenses = Seq(
    License("Two-clause BSD-style license",
    new URL("http://github.com/xdotai/lens/blob/master/LICENSE.txt"))
  )
  override def developers = Seq(
    Developer("cvogt", "Jan Christopher Vogt", "-5", new URL("https://github.com/cvogt/"))
  )
  override def scmUrl = "git@github.com:xdotai/lens.git"
  override def scmConnection = "scm:git:git@github.com:xdotai/lens.git"
  override def description = "Convenient ad-hoc lens Syntax on top of Monocle"
  override def pomExtra =
    <inceptionYear>2016</inceptionYear>
    <organization>
        <name>x.ai</name>
        <url>http://x.ai</url>
    </organization>
}
