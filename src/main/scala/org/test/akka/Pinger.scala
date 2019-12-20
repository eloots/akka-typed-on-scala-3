package org.test.akka

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object Pinger {

  sealed trait Command
  case object SendPing extends Command
  case object StopPingPong extends Command
  final case class WrappedPongResponse(pong: PingPong.Response) extends Command

  def apply(pingPong: ActorRef[PingPong.Ping]): Behavior[Command] = Behaviors.setup { context =>
    val pongResponseMapper: ActorRef[PingPong.Response] =
      context.messageAdapter(response => WrappedPongResponse(response))

    Behaviors.receiveMessage {
      case StopPingPong =>
        context.log.info(s"End of the ping-pong game - calling it a day!")
        context.system.terminate()
        Behaviors.stopped
      case SendPing =>
        pingPong ! PingPong.Ping(replyTo = pongResponseMapper)
        Behaviors.same
      case WrappedPongResponse(response) =>
        context.log.info(s"Hey: I just received a $response !!!")
        Behaviors.same
    }
  }
}

