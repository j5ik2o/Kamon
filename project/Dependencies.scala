/* =========================================================================================
 * Copyright © 2013-2016 the kamon project <http://kamon.io/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 * =========================================================================================
 */

import sbt._
import Keys._

object Dependencies {

  val resolutionRepos = Seq(
    "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/",
    "Kamon Repository Snapshots" at "http://snapshots.kamon.io"
  )

  val aspectJ           = "org.aspectj"               %   "aspectjweaver"         % "1.8.10"
  val hdrHistogram      = "org.hdrhistogram"          %   "HdrHistogram"          % "2.1.9"
  val slf4jApi          = "org.slf4j"                 %   "slf4j-api"             % "1.7.7"
  val slf4jnop          = "org.slf4j"                 %   "slf4j-nop"             % "1.7.7"
  val logback           = "ch.qos.logback"            %   "logback-classic"       % "1.0.13"
  val scalatest         = "org.scalatest"             %%  "scalatest"             % "3.0.1"

  def akkaDependency(moduleName: String) = Def.setting {
    scalaBinaryVersion.value match {
      case "2.10" | "2.11"  => "com.typesafe.akka" %% s"akka-$moduleName" % "2.3.15"
      case "2.12"           => "com.typesafe.akka" %% s"akka-$moduleName" % "2.4.14"
    }
  }

  def compileScope   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def testScope      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")
  def providedScope  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def optionalScope  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile,optional")
}
