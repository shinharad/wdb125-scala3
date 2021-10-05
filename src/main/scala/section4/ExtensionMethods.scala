package section4.extensionMethods

// 拡張メソッド

extension [A](seq: Seq[A])
  def secondOption: Option[A] =
    tailOption.flatMap(_.headOption)
  def tailOption: Option[Seq[A]] =
    if seq.nonEmpty then Some(seq.tail) else None

@main def foo(): Unit =
  Seq.empty.secondOption    // None
  Seq(1, 2, 3).secondOption // Some(2)
