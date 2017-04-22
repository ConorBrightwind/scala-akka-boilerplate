/*
 * Copyright (C) BrightWind - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.brightwindanalysis.actor

import akka.actor.{Actor, ActorLogging, Props}
import akka.event.LoggingReceive
import com.brightwindanalysis.actor.SkeletonActor.{RequestMessage, ResponseMessage}

object SkeletonActor {
  def props: Props = Props[SkeletonActor]

  sealed trait Message
  case object RequestMessage extends Message
  case object ResponseMessage extends Message
}

final class SkeletonActor extends Actor with ActorLogging {
  override def receive: Receive = LoggingReceive {
    case RequestMessage =>
      log.debug("message")
      sender() ! ResponseMessage
    case _ =>
      log.error("invalid message")
  }
}
