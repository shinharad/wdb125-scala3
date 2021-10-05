// メインメソッド
// 分かりやすさのためにあえてパッケージを省略しています。

// 従来のメインメソッド
object Hello1 { // オブジェクトの中で実装
  def main(args: Array[String]): Unit =
    println("Hello, World")
}

object Hello2 extends App { // Appトレイトをミックスイン
  println("Hello, World")
}

// @mainアノテーションを使用したメインメソッド

// メソッド名は任意の名前を付けられる
// 引数は型を持った任意の数の値を受け取れる
@main def show(kind: Int, ops: String*): Unit =
  kind match
    case 1 | 2 => println("one or two")
    case 3     => println(s"three: $ops")
    case _     => println("invalid argument!")
