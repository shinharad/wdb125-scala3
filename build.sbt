// 本稿が対象とするScalaのバージョン
ThisBuild / scalaVersion := "3.0.2"

// 2021/10にScala 3.1.0がリリースされました。
// Scala 3.1.xは後方互換性があるため、本稿のサンプルコードはそのまま実行することができます。
// ThisBuild / scalaVersion := "3.1.0"

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:implicitConversions",
  "-unchecked"
)

lazy val root =
  project
    .in(file("."))
    .settings(commonSettings)
    .aggregate(
      `src-future`
    )

// コンパイラオプションの`-source:future`を指定したプロジェクト
// infix修飾子のサンプルコードが格納されています。
lazy val `src-future` =
  project
    .in(file("src-future"))
    .settings(scalacOptions ++= Seq("-source", "future"))
    .settings(commonSettings)

lazy val commonSettings = consoleScalacOptions

lazy val consoleScalacOptions = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value
)
