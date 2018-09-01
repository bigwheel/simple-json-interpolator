package com.github.bigwheel.util.json

object Interpolator {
  trait SimpleJsonReader[T] {
    def read(json: String): T
  }
  implicit class SimpleJsonInterpolator(val sc: StringContext) extends AnyVal {
    def json[T](args: Any*)(implicit reader: SimpleJsonReader[T]): T = {
      reader.read(sc.s(args: _*))
    }
  }
}
