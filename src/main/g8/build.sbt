lazy val `$name$-api` = (project in file("$name$-api"))
  .settings(
    autoScalaLibrary := false,
    crossVersion := CrossVersion.disabled,
    compile / javacOptions ++= Seq("--release", "8"),
    Compile / PB.targets := Seq(
      PB.gens.java -> (Compile / sourceManaged).value
    )
  )

lazy val `$name$-play` = (project in file("$name$"))
  .dependsOn(`$name$-api`)
  .enablePlugins(YieldstreetPlayPlugin)
  .settings(
    version := "1.0.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      jdbi3Core,
      mysqlConnectorJava,
      lagomPersistenceJdbi3,
      lagomJavadslPersistenceJdbc,

      // akka version upgrades
      "com.typesafe.akka" %% "akka-cluster-sharding-typed" % "2.6.5",
      "com.typesafe.akka" %% "akka-discovery" % "2.6.5",
      "com.typesafe.akka" %% "akka-persistence-query" % "2.6.5",
      "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.5",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.12",

      // test libraries
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.5" % Test,
      "com.typesafe.akka" %% "akka-persistence-testkit" % "2.6.5" % Test
    )
  )

lazy val `$name$` = (project in file("."))
  .aggregate(`$name$-api`, `$name$-play`)
  .settings(publish / skip := true)
