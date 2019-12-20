# Running an Akka Typed application using Scala 3

This sample project demonstrates:

- Out-of-the-box interoperability of Scala 3 (`0.21.0-RC1`) with
  existing 2.13.1 artifacts (Akka, logback)
- Using `Union types`, a Scala feature unique to Scala 3 to our
  benefit

The project contains:

- Initial commit: the original sample app in Akka Typed (2.6.1) and Scala 2.13.1
- Second commit: running the sample app unmodified (!) on Scala 3
- Third commit: swapping a protocol adapter for responses for a `Union type`
  based approach enhancing readability and reduced complexity
