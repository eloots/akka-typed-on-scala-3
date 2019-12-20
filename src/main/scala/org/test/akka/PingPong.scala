package org.test.akka

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object PingPong {


  sealed trait Command
  final case class Ping(replyTo: ActorRef[Response]) extends Command

  sealed trait Response
  case object Pong extends Response

  def apply(): Behavior[Command] = Behaviors.setup { context =>
    (new PingPong).run()
  }
}

class PingPong {
  import PingPong._

  def run(): Behavior[Command] = Behaviors.receiveMessage {
    case Ping(replyTo) =>
      replyTo ! Pong
      Behaviors.same
  }

}
