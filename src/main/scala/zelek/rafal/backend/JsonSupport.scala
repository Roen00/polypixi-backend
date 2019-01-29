package zelek.rafal.backend

import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport
import io.circe._
import io.circe.generic.semiauto._
import zelek.rafal.backend.UserRegistryActor.ActionPerformed

trait JsonSupport extends ErrorAccumulatingCirceSupport {
  implicit val userDecoder: Decoder[User] = deriveDecoder
  implicit val userEncoder: Encoder[User] = deriveEncoder


  implicit val usersDecoder: Decoder[Users] = deriveDecoder
  implicit val usersEncoder: Encoder[Users] = deriveEncoder

  implicit val actionPerformedDecoder: Decoder[ActionPerformed] = deriveDecoder
  implicit val actionPerformedEncoder: Encoder[ActionPerformed] = deriveEncoder
}
