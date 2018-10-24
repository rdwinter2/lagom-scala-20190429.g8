package com.example.common.authentication

import java.util.UUID

import play.api.libs.json.{Format, Json}

case class TokenContent(clientId: UUID, userId: UUID, username: String, isRefreshToken: Boolean = false)
object TokenContent {
  implicit val format: Format[TokenContent] = Json.format
}