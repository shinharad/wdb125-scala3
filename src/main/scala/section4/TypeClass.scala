package section4.TypeClass

// 型クラス

trait Repeatable[A]:
  extension (a: A)
    def repeat(count: Int): String

object Repeatable:
  given Repeatable[String] with
    extension (s: String)
      def repeat(count: Int): String = s * count
  given Repeatable[Int] with
    extension (i: Int)
      def repeat(count: Int): String =
        i.toString * count

@main def foo(): Unit =
  import Repeatable.given

  "abc".repeat(3) // "abcabcabc"
  123.repeat(2)   // "123123"
