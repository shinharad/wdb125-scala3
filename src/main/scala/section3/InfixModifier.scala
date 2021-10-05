package section3.infixModifier

// infix修飾子

// infix修飾子を使わない場合
def no1(): Unit =
  case class MyNum(a: Int):
    def +(b: Int): MyNum = plus(b)
    def plus(b: Int): MyNum = copy(a + b)

  val num = MyNum(1)

  num.+(2) // メソッド呼び出しの記法
  num + 2  // 中置記法

  num `plus` 2  // バッククオートで囲む
  num plus 2    // バッククオートで囲まない（Scala 3.0までは許容されている書き方）

// infix修飾子を使った場合
def no2(): Unit =
  case class MyNum(a: Int):
    def +(b: Int): MyNum = plus(b)
    infix def plus(b: Int): MyNum = copy(a + b)

  val num = MyNum(1)

  // infix修飾子が付いてるので、Scala 3の将来のバージョンでも許容される
  num plus 2    // バッククオートで囲まない

// src-future プロジェクト配下のサンプルコードも併せて参照してください。
// コンパイラオプションに`-source:future`を指定して、警告メッセージが表示される様子を確認できます。
