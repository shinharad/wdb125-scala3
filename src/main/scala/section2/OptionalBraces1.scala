package section2.optionalBraces1

// インデントベース構文(1)

// インデントベース構文の例
class A: // クラスを定義（波括弧の代わりに「:」を記述）
  def f: Int = // メソッドのブロック
    val a = 1
    val b = 2
    a + b

trait B: // トレイトを定義
  def f: Int
  def g: String

val b = new B: // トレイトからインスタンスを生成
  def f: Int = 10
  def g: String = "abc"

def foo(): Unit =
  // 引数の波括弧は省略できない
  Vector(1, 2, 3).map { x =>
    val y = x + 1
    y
  }

  // これはできない
  // Vector(1, 2, 3).map:
  //   x =>
  //     val y = x + 1
  //     y
