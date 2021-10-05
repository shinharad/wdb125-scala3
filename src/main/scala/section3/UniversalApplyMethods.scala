package section3.universalApplyMethods

// newキーワードは省略可能

// ケースクラスの場合
case class A(v: Int)
// ケースクラスはapplyが自動的に作成される
val a1 = A.apply(123)
// applyは省略できるので結果的にnewは不要
val a2 = A(123)

// 通常のクラスの場合
class B(v: Int)
// Scala 2はインスタンス生成にnewが必須だった
val b0 = new B(123)
// Scala 3ではapplyが自動的に作成される
val b1 = B.apply(123)
// applyは省略できるので結果的にnewは不要
val b2 = B(123)

// Javaのクラスもnewは省略可

// Scala 3のインポート時のリネームは「as」を使用する
import java.util.HashMap as JHashMap
// Javaのクラスもnewは省略可
val map = JHashMap[String, String]
