package $organization$.identity.impl

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity
import $organization$.identity.api.response.{IdentityStateDone, GeneratedIdDone}
import play.api.libs.json.{Format, Json}

sealed trait IdentityCommand

case class RegisterClient(
 company: String,
 firstName: String,
 lastName: String,
 email: String,
 username: String,
 password: String
) extends PersistentEntity.ReplyType[GeneratedIdDone] with IdentityCommand
object RegisterClient {
  implicit val format: Format[RegisterClient] = Json.format
}

case class CreateUser(
 firstName: String,
 lastName: String,
 email: String,
 username: String,
 password: String
) extends PersistentEntity.ReplyType[GeneratedIdDone] with IdentityCommand
object CreateUser {
  implicit val format: Format[CreateUser] = Json.format
}

case class GetIdentityState() extends PersistentEntity.ReplyType[IdentityStateDone] with IdentityCommand