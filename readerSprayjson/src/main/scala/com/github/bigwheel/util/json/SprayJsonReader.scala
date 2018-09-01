package com.github.bigwheel.util.json

import com.github.bigwheel.util.json.Interpolator.SimpleJsonReader
import spray.json._

object SprayJsonReader {

  implicit object sprayJsonReader extends SimpleJsonReader[JsValue] {
    override def read(json: String): JsValue = json.parseJson
  }

}
