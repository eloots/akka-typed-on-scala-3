package org.test.akka

import akka.actor.typed.scaladsl.{ActorContext, Behaviors}
import akka.actor.typed.{ActorRef, Behavior}

object Ping {
  def ping(): Unit = println(s"Pinging")
}
