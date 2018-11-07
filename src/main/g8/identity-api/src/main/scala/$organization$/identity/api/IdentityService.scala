package $organization$.identity.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import $organization$.identity.api.request.{ClientRegistration, UserCreation, UserLogin}
import $organization$.identity.api.response.{IdentityStateDone, TokenRefreshDone, UserLoginDone, GeneratedIdDone}

trait IdentityService extends Service {
  def registerClient(): ServiceCall[ClientRegistration, GeneratedIdDone]
  def loginUser(): ServiceCall[UserLogin, UserLoginDone]
  def refreshToken(): ServiceCall[NotUsed, TokenRefreshDone]
  def getIdentityState(): ServiceCall[NotUsed, IdentityStateDone]
  def createUser(): ServiceCall[UserCreation, GeneratedIdDone]

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("identity-service").withCalls(
      restCall(Method.POST, "/api/client/registration", registerClient _),
      restCall(Method.POST, "/api/user/login", loginUser _),
      restCall(Method.PUT, "/api/user/token", refreshToken _),
      restCall(Method.GET, "/api/state/identity", getIdentityState _),
      restCall(Method.POST, "/api/user", createUser _)
    ).withAutoAcl(true)
    // @formatter:on
  }


}

