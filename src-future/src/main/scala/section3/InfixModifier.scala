package section3.infixModifier

// infix修飾子

// infix修飾子を使わない場合
def no1(): Unit =
  case class MyNum(a: Int):
    def +(b: Int): MyNum = plus(b)
    def plus(b: Int): MyNum = copy(a + b)

  val num = MyNum(1)

  // コンパイラオプションで`-source:future`を設定しているので、
  // 以下のコメントを外すと警告メッセージが表示される
  // num plus 2    // バッククオートで囲まない

// infix修飾子を使った場合
def no2(): Unit =
  case class MyNum(a: Int):
    def +(b: Int): MyNum = plus(b)
    infix def plus(b: Int): MyNum = copy(a + b)

  val num = MyNum(1)

  // infix修飾子が付いてるので、警告メッセージは表示されない
  num plus 2    // バッククオートで囲まない
