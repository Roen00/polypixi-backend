package zelek.rafal.backend

import java.nio.file.{Files, Paths}

import akka.actor.{ActorRef, ActorSystem}
import akka.event.Logging
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.get
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.util.Timeout
import scodec.bits.ByteVector
import zelek.rafal.pms.PmsFile

import scala.concurrent.duration._

trait MapRoutes extends JsonSupport with CORSHandler {

  implicit def system: ActorSystem

  private lazy val log = Logging(system, classOf[MapRoutes])

  def userRegistryActor: ActorRef

  private implicit lazy val timeout: Timeout = Timeout(5.seconds)

  lazy val mapRoutes: Route =
    corsHandler(
      pathPrefix("maps") {
        pathEnd {
          get {
            val byteArray = Files.readAllBytes(Paths.get("/home/rafalzel/projects/pms-parser/src/main/scala/adt/ctf_Ash.pms"))
            val hexValue = ByteVector(byteArray)

            val result = PmsFile.codec.decodeValue(hexValue.bits)
            val value = result.toOption.get.polygons.take(10)
            complete(value)
          }
        }
      }
    )

}
