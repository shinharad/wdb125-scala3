# wdb-scala3

WEB+DB PRESS Vol.125の記事「Scala 3 クイックツアー」で掲載しているサンプルコードです。

## ソースコードディレクトリについて

### srcディレクトリ

サンプルコードを配置しています。

### src-futureディレクトリ

コンパイラオプションに`-source:future`を設定したプロジェクトです。infix修飾子のサンプルコードを配置しています。

## Scala 3プログラムの実行方法

サンプルコードを実行する方法を2つ紹介します。

### ブラウザで実行する

[Scastie](https://scastie.scala-lang.org/)は、Scalaプログラムをブラウザ上で書いてそのまま実行できる便利なサイトです。環境構築の手間が省けるため、まずはScalaを試してみたい場合にお勧めです。Build SettingsのTargetを変更することでScala 3のプログラムを実行できます。

### ローカル環境を構築して実行する

Javaの開発キットであるJDKと、Scalaの標準的なビルドツールであるsbtをインストールします。インストール方法は[こちら](https://www.scala-lang.org/download/scala3.html)を参照してください。

なお、筆者の環境は以下の通りです。

```
$ java -version
openjdk version "11.0.12" 2021-07-20
OpenJDK Runtime Environment Temurin-11.0.12+7 (build 11.0.12+7)
OpenJDK 64-Bit Server VM Temurin-11.0.12+7 (build 11.0.12+7, mixed mode)

$ sbt -version
sbt version in this project: 	1.5.5
sbt script version: 1.5.5
```

IDEは、JetBrains社の[IntellJ IDEA](https://www.jetbrains.com/ja-jp/idea/download)が広く利用されており、Scala 3の機能は順次サポートされています。有償版のUltimateと無償版のCommunityとありますが、Communityで十分です。IntelliJ IDEAをインストールしたらScala pluginを追加してください。

また、Scala Language Serverの[Metals](https://scalameta.org/metals/)を使用することで、Visual Studio CodeやVim、Sublime TextなどのエディタをIDEのような高機能な開発環境にすることもできます。

準備が整ったら試しにターミナルでメインメソッドのサンプルコードを実行してみましょう。

```
$ sbt "runMain show 1"
[info] welcome to sbt 1.5.5 (Eclipse Foundation Java 11.0.12)
(省略)
[info] running show 1
one or two
[success] Total time: xx s, completed xxxx/xx/xx xx:xx:xx
```

`sbt`コマンドでsbtシェルを起動し、インタラクティブモードで実行する方法もあります。`run`と入力し、一覧から実行するメインメソッドを番号で指定してください。

```
$ sbt

sbt:root> run
(省略)
Multiple main classes detected. Select one to run:
 [1] Hello1
 [2] Hello2
 [3] section4.TypeClass.foo
 [4] section4.extensionMethods.foo
 [5] section5.opaqueTypeAliases.foo
 [6] section5.unionTypes.foo
 [7] show

Enter number: 1
[info] running Hello1
Hello, World
[success] Total time: xx s, completed xxxx/xx/xx xx:xx:xx
```

sbtシェルを終了する場合は`exit`と入力してください。

```
sbt:root> exit
[info] shutting down sbt server
```

sbtの簡単な使い方は、sbt公式ドキュメントの[sbt by example](https://www.scala-sbt.org/1.x/docs/sbt-by-example.html#Exit+sbt+shell)が参考になります。
