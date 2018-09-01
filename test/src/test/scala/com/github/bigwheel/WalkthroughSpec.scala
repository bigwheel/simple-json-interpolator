package com.github.bigwheel

import com.github.bigwheel.util.json.Interpolator.SimpleJsonInterpolator
import org.scalatest.{FunSuite, Matchers}

class WalkthroughSpec extends FunSuite with Matchers {

  {
    import com.github.bigwheel.util.json.SprayJsonReader.sprayJsonReader
    import spray.json.JsonParser.ParsingException
    import spray.json._

    test("can parse JSON object") {
      val actual = json"""{ "some": "JSON source" }"""

      actual should be(JsObject("some" -> JsString("JSON source")))
    }

    test("can parse JSON array") {
      val actual = json"""[ 1, 2, 3 ]"""

      actual should be(JsArray(JsNumber(1), JsNumber(2), JsNumber(3)))
    }

    test("throw error if string is invalid as json format") {
      a[ParsingException] should be thrownBy json"""[ 1, 2, 3, ]"""
    }

    test("can process variable expand") {
      val number = 4
      val actual = json"""[ 1, $number, 3 ]"""

      actual should be(JsArray(JsNumber(1), JsNumber(4), JsNumber(3)))
    }

    test("doesn't care expanded variable type (i.e. doesn't add double quotes for string)") {
      val str = "def"

      a[ParsingException] should be thrownBy json"""[ "abc", $str, "ghi" ]"""
    }
  }

  {
    test("can use arbitrary json library") {
      import argonaut.Argonaut._
      import argonaut._
      import com.github.bigwheel.util.json.ArgonautReader.argonautJsonReader

      json"""[1, 2, 3]""" should be(Json.array(jNumber(1), jNumber(2), jNumber(3)))
    }
  }
}
