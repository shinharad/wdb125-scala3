package section5.unionTypes

// Union Types

case class Ok()
case class Error(i: Int, s: String)

def handle(result: Ok | Error): Unit =
  result match
    case Ok()        => println("Ok")
    case Error(i, s) => println(s"error: $i / $s")

@main def foo(): Unit =
  handle(Ok())            // "Ok"
  handle(Error(1, "abc")) // "error: 1 / abc"

case class OtherError(s: String)

def show(result: Ok | Error | OtherError): Unit =
  result match
    case Ok() => println("Ok")
    case Error(i, s) => println(s"error: $i / $s")
    case OtherError(s) => println(s"error: $s")

// エイリアスを定義しておくと便利
def extra(): Unit =
  type ErrorOf[A] = A | Error | OtherError
  def show(result: ErrorOf[Ok]): Unit = ???
