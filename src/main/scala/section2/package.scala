package section2.topLevelDefinitions1

// トップレベル定義(1)

// パッケージオブジェクトを使用した場合
package object p {
  val Limit: Int = 100
  def square(x: Int): Int = x * x
  type Result[T] = Either[String, T]
}
