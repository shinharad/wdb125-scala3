package section2.newControlSyntax

// 新しい制御構文

// ifの場合
def no1(): String =
  val x = 10
  val y = 10

  // 新しい制御構文
  if x == y then // 条件式の括弧は省略可
    "EQ"
  else if x < y then
    "LT"
  else
    "GT"

  // 従来の構文
  if (x == y) {
    "EQ"
  } else if (x < y) {
    "LT"
  } else {
    "GT"
  }

// forの場合
def no2(): Unit =
  val seq = Seq(-1, 5, 0, 4, 1)

  val a = for // 波括弧は省略可
    i <- seq if i > 0
    j <- i to 3
  yield i * j

  // forループ
  for
    i <- seq if i > 0
    j <- i to 3
  do println(i * j)

  // 従来の構文
  val a2 = for { // 波括弧は省略可
    i <- seq if i > 0
    j <- i to 3
  } yield i * j

  for {
    i <- seq if i > 0
    j <- i to 3
  } println(i * j)

  // 1行で書いた場合
  val b = for i <- seq if i > 0 yield i    // 新しい制御構文
  val c = for (i <- seq if i > 0) yield i  // 従来の構文

  for i <- seq if i > 0 do println(i)      // 新しい制御構文
  for (i <- seq if i > 0) println(i)       // 従来の構文
