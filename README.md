# simple json interpolator [![Build Status](https://travis-ci.org/bigwheel/simple-json-interpolator.svg?branch=master)](https://travis-ci.org/bigwheel/simple-json-interpolator)

This is a simple json interpolator.


## Installation

simple-json-interpolator is available from maven central.

If you use SBT you can include simple-json-interpolator in your project with

```scala
libraryDependencies ++= Seq(
  "com.github.bigwheel" %% "simple-json-interpolator" % "1.0",
  // select by your json library 
  "com.github.bigwheel" %% "simple-json-interpolator-reader-sprayjson" % "1.0",
  "com.github.bigwheel" %% "simple-json-interpolator-reader-argonaut" % "1.0",
  // for other libraries, you can implement SimpleJsonReader[T] by yourself.
)
```

## Usage

[See Spec File](https://github.com/bigwheel/simple-json-interpolator/blob/master/test/src/test/scala/com/github/bigwheel/WalkthroughSpec.scala)
