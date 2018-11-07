package io.digitalcat.publictransportation.services.identity.api.response

import play.api.libs.json.{Format, Json}

case class GeneratedIdDone(id: String)
object GeneratedIdDone {
  implicit val format: Format[GeneratedIdDone] = Json.format
}
