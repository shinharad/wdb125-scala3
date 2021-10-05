package section4.givenAndUsingClauses

// GivenとUsing句

class C // コンテキストを表現したクラス

// コンテキストパラメータの例
def no1(): Unit =
  // Using句でコンテキストを受け取る
  def m(v: Int)(using c: C): Seq[Int] = ???

  // Givenでコンテキストを与える
  given c: C = C()

  m(100) // コンテキストの受け渡しを省略

// コンテキストを引き回す
def no2(): Unit =
  def m(v: Int)(using c: C): Seq[Int] = m2(v)
  def m2(v: Int)(using c: C): Seq[Int] = ???

  // Givenでコンテキストを与える
  given c: C = C()

  m(100) // コンテキストの受け渡しを省略

// GivenとUsing句の名前は使用しないのであれば省略できる
def no3(): Unit =
  def m(v: Int)(using C): Seq[Int] = m2(v)
  def m2(v: Int)(using C): Seq[Int] = ???

  given C = C()

  m(100) // コンテキストの受け渡しを省略

// Using句はパラメータリストのどの位置でも書ける
def no4(): Unit =
  class D

  // 先頭のパラメータリストでUsing句を使う
  def m1(using C)(v: Int): Seq[Int] = ???
  // 前後にUsing句を使う
  def m2(using C)(v: Int)(using D): Seq[Int] = ???

  given C = C()
  given D = D()

  m1(100)
  m2(200)