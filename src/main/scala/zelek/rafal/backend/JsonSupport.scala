package zelek.rafal.backend

import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport
import io.circe._
import io.circe.generic.semiauto._
import zelek.rafal.backend.UserRegistryActor.ActionPerformed
import zelek.rafal.pms._

trait JsonSupport extends ErrorAccumulatingCirceSupport
  with UserJsonSupport
  with PmsFileJsonSupport

trait UserJsonSupport {
  implicit val userDecoder: Decoder[User] = deriveDecoder
  implicit val userEncoder: Encoder[User] = deriveEncoder


  implicit val usersDecoder: Decoder[Users] = deriveDecoder
  implicit val usersEncoder: Encoder[Users] = deriveEncoder

  implicit val actionPerformedDecoder: Decoder[ActionPerformed] = deriveDecoder
  implicit val actionPerformedEncoder: Encoder[ActionPerformed] = deriveEncoder
}

trait PmsFileJsonSupport {
  implicit val pmsColorDecoder: Decoder[PmsColor] = deriveDecoder
  implicit val pmsColorEncoder: Encoder[PmsColor] = deriveEncoder

  implicit val pmsVertexDecoder: Decoder[PmsVertex] = deriveDecoder
  implicit val pmsVertexEncoder: Encoder[PmsVertex] = deriveEncoder

  implicit val pmsVectorDecoder: Decoder[PmsVector] = deriveDecoder
  implicit val pmsVectorEncoder: Encoder[PmsVector] = deriveEncoder

  implicit val pmsPolyTypeDecoder: Decoder[PmsPolyType] = deriveDecoder
  implicit val pmsPolyTypeEncoder: Encoder[PmsPolyType] = deriveEncoder

  implicit val pmsPolygonDecoder: Decoder[PmsPolygon] = deriveDecoder
  implicit val pmsPolygonEncoder: Encoder[PmsPolygon] = deriveEncoder
}