package org.test.akka

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object Pinger {

  // My protocol
  sealed trait Command
  case object SendPing extends Command
  case object StopPingPong extends Command

  // My protocol + the responses I need to understand...
  type CommandsAndResponses = Command | PingPong.Response


  def apply(pingPong: ActorRef[PingPong.Ping]): Behavior[CommandsAndResponses] = Behaviors.setup { context =>

    Behaviors.receiveMessage {
      case StopPingPong =>
        context.log.info(s"End of the ping-pong game - calling it a day!")
        context.system.terminate()
        Behaviors.stopped
      case SendPing =>
        pingPong ! PingPong.Ping(replyTo = context.self)
        Behaviors.same
      case response : PingPong.Response =>
        context.log.info(s"Hey: I just received a $response !!!")
        Behaviors.same
    }
  }
}

