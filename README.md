# simple json interpolator [![Build Status](https://travis-ci.com/bigwheel/simple-json-interpolator.svg?branch=master)](https://travis-ci.com/bigwheel/simple-json-interpolator)

This is a simple json interpolator.


## Installation

simple-json-interpolator is available from maven central.

If you use SBT you can include simple-json-interpolator in your project with

```scala
libraryDependencies += "com.github.bigwheel" %% "simple-json-interpolator" % "1.0"
```

## Usage

TBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBDTBD

```scala
import com.github.bigwheel.util.chaining._

val str = "42"
str.tap(println)
println(1 + str.pipe(_.length))


import com.github.bigwheel.util.Using

Using.resource(new PrintWriter("write-target.txt")) { pw =>
  pw.write("hello world")
  // no need to close !
}
```
