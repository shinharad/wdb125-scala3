package section3.enumerations

// 列挙型や代数的データ型

// 従来の構文

// scala.Enumerationの例
def no1(): Unit =
  object Currency extends Enumeration:
    val JPY, USD, EUR = Value

// sealed traitの継承関係で表現した例
def no2(): Unit =
  sealed trait Currency
  object Currency:
    case object JPY extends Currency
    case object USD extends Currency
    case object EUR extends Currency

// enumキーワードを使用した列挙型
def no3(): Unit = 
  // 新しい列挙型の定義
  enum Currency:
    case JPY, USD, EUR

  // Scala 3のインポートのワイルドカードは「*」を使用
  import Currency.*

  // 静的な網羅性チェックが可能
  // （コメントを外すと警告メッセージが表示される）
  // val c: Currency = JPY
  // c match // EURのケース漏れをコンパイラが教えてくれる
  //   case JPY =>
  //   case USD =>

  // サポートメソッドが利用可能
  Currency.values // すべての要素の配列を返却
  Currency.valueOf("JPY") // 文字列から列挙型に変換

  // 列挙型の要素の順番に関するメソッドも利用可能
  val ordinal = USD.ordinal
  Currency.fromOrdinal(ordinal)

// 代数的データ型
def no4(): Unit =
  enum Tree[+A]: // 代数的データ型の例
    case Leaf(value: A)
    case Branch(left: Tree[A], right: Tree[A])

  object Tree: // コンパニオンオブジェクトも定義できる
    def depth[A](t: Tree[A]): Int = t match
      case Leaf(_) => 0
      case Branch(l, r) => 1 + (depth(l) max depth(r))

  // 定義したTreeを使用する
  import Tree.*

  val branch = Branch(
    Branch(Leaf("abc"), Leaf("def")),
    Leaf("ghi")
  )

  val result = depth(branch)
