package section4.givenImports

// Givenのインポート

class C1
class C2
def m(using C1, C2): String = ???

object O:
  val Name = "abc"
  def square(i: Int): Int = i * i
  given c1: C1 = C1()
  given c2: C2 = C2()

def foo(): Unit =
  // OのすべてのGivenをインポート
  import O.given
  // Givenがスコープにあるので呼び出せる
  m
