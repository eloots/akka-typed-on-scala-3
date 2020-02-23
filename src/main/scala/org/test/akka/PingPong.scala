package org.test.akka

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object PingPong {

  enum Command {
    case Ping(replyTo: ActorRef[Response])
  }
  export Command._

  enum Response {
    case Pong
  }
  export Response._

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

