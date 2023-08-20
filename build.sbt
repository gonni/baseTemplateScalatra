val ScalatraVersion = "2.8.2"

ThisBuild / scalaVersion := "2.13.9"
ThisBuild / organization := "c.x"

lazy val hello = (project in file("."))
  .settings(
    name := "stdViewTemplate",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "org.scalatra" %% "scalatra-forms" % ScalatraVersion,
      "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.43.v20210629" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "com.influxdb" % "influxdb-client-scala_2.13" % "6.0.0",
      "org.json4s" %% "json4s-jackson" % "4.1.0-M1",
      "com.typesafe" % "config" % "1.4.2",
      "org.apache.httpcomponents" % "httpclient" % "4.3.5",
      "com.typesafe.slick" %% "slick" % "3.3.2",
      //      "org.slf4j" % "slf4j-nop" % "1.6.4",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
      "mysql" % "mysql-connector-java" % "8.0.27",
      "org.mariadb.jdbc" % "mariadb-java-client" % "2.7.8",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.35.v20201120" % "container;compile",
    ),
  )

enablePlugins(SbtTwirl)
enablePlugins(JettyPlugin)
