package org.test.akka

import akka.NotUsed
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior, Terminated}

object MainPingPong {

  def apply(): Behavior[NotUsed] = Behaviors.setup { context =>
    val pingPong = context.spawn(PingPong(), "ping-pong")
    val pinger = context.spawn(Pinger(pingPong), "pinger")

    for (_ <- 1 to 3) {
      pinger ! Pinger.SendPing
      Thread.sleep(1000)
    }
    pinger ! Pinger.StopPingPong

    Behaviors.receiveSignal {
      case (_, Terminated(_)) =>
        Behaviors.stopped
    }
  }
}

object PingPongMain extends App {

  val system = ActorSystem[NotUsed](MainPingPong(), "ping-pong-system")

}

