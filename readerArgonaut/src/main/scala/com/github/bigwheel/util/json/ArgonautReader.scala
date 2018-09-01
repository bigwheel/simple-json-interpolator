package com.github.bigwheel.util.json

import argonaut._
import com.github.bigwheel.util.json.Interpolator.SimpleJsonReader

object ArgonautReader {

  implicit object argonautJsonReader extends SimpleJsonReader[Json] {
    override def read(json: String): Json = Parse.parse(json) match {
      case Right(parsed) => parsed
      case Left(errorMessage) =>
        val description = s"""Argument $json cannot be parsed. Error message is :$errorMessage"""
        throw new IllegalArgumentException(description)
    }
  }

}
