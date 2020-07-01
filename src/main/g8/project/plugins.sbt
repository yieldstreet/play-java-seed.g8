// yieldstreet-play-sbt-plugin
resolvers += "YS" at "https://nexus.ops.yieldstreet.net/repository/maven-public/"
addSbtPlugin("yieldstreet" % "yieldstreet-play-sbt-plugin" % "1.0.1")

// sbt-protoc
addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.34")
libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.10.6"

// sbt-dotenv
addSbtPlugin("au.com.onegeek" %% "sbt-dotenv" % "2.1.146")
