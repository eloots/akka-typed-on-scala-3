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

# Run the examples

- Select a commit
- `sbt run`

### Sample output

```
/lbt/dottyAkkatest on  master! ⌚ 17:03:40
$ sbt run
[info] Loading settings for project global-plugins from idea.sbt ...
[info] Loading global plugins from /Users/ericloots/.sbt/1.0/plugins
[info] Loading settings for project dottyakkatest-build from plugins.sbt ...
[info] Loading project definition from /lbt/dottyAkkatest/project
[info] Loading settings for project root from build.sbt ...
[info] Set current project to dotty-simple (in build file:/lbt/dottyAkkatest/)
[info] Running org.test.akka.PingPongMain
17:03:51.974 [ping-pong-system-akka.actor.default-dispatcher-3] INFO akka.event.slf4j.Slf4jLogger - Slf4jLogger started
SLF4J: A number (1) of logging calls during the initialization phase have been intercepted and are
SLF4J: now being replayed. These are subject to the filtering rules of the underlying logging system.
SLF4J: See also http://www.slf4j.org/codes.html#replay
17:03:52.037 [ping-pong-system-akka.actor.default-dispatcher-6] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:53.036 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:54.038 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:55.043 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:56.044 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:57.044 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:58.048 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:03:59.051 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:04:00.052 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:04:01.056 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - Hey: I just received a Pong !!!
17:04:02.059 [ping-pong-system-akka.actor.default-dispatcher-5] INFO org.test.akka.Pinger$ - End of the ping-pong game - calling it a day!
[success] Total time: 12 s, completed Dec 20, 2019 5:04:02 PM

/lbt/dottyAkkatest on  master! ⌚ 17:04:02/
```
