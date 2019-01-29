lazy val akkaHttpVersion = "10.1.7"
lazy val akkaVersion    = "2.5.19"
lazy val akkaHttpCirceVersion = "1.24.3"
lazy val circeVersion = "0.11.1"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "zelek.rafal.backend",
      scalaVersion    := "2.12.7"
    )),
    name := "polypixi-backend",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
      "de.heikoseeberger" %% "akka-http-circe"      % akkaHttpCirceVersion,
      "io.circe"          %% "circe-core"           % circeVersion,
      "io.circe"          %% "circe-generic"        % circeVersion,
      "io.circe"          %% "circe-parser"         % circeVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.0.5"         % Test
    )
  )
