package section5.opaqueTypeAliases

// Opaque Type Aliases

object Balance:
  // Opaque Type Aliasesを宣言
  // スコープの中は単なる型メンバ
  opaque type Amount = Double

  object Amount:
    // Amountのファクトリ
    def apply(amount: Double): Amount = amount

  // スコープの外に公開する振る舞いは、
  // 拡張メソッドで定義する。
  extension (self: Amount)
    def +(a: Amount): Amount = self + a
    def -(a: Amount): Amount = self - a
    def toDouble: Double = self

@main def foo(): Unit =
  import Balance.*
  
  // Opaque Type Aliasesを生成
  val a1 = Amount(1000.0)
  val a2 = Amount(2000.0)
  
  // 拡張メソッドはスコープの外から使用可能
  a1 + a2
  a1 - a2
  
  // 実体であるDouble型のメソッドは使用不可
  // a1.toInt // NG
