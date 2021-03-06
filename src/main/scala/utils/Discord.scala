package utils

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.client.RequestBuilding._
import akka.http.scaladsl.model._
import com.typesafe.config.{ConfigFactory, ConfigRenderOptions}

object Discord {
  implicit val system = ActorSystem()
  implicit val ec = system.dispatcher
  val config = ConfigFactory.load().getConfig("discord")
  val messages = config.getConfig("messages")
  val webHookUri = config.getString("webhook")

  def sendMessage(name: String): Unit = {
    if (messages.hasPath(name)) {
      Http().singleRequest(Post(
        webHookUri,
        HttpEntity(MediaTypes.`application/json`, s"${messages.getConfig(name).root().render(ConfigRenderOptions.concise())}")
      ))
    }
  }
}
