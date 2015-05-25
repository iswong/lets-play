package controllers

import play.api._
import play.api.libs.iteratee.Enumerator
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def echo = Action { request =>
    Ok("Got request [" + request.headers + "]")
  }

  def rest(id: Long) = Action { request =>
    Result(
      header = ResponseHeader(200, Map(CONTENT_TYPE -> "application/json")),
      body = Enumerator(s"Hello world $id".getBytes())
    )
  }

  def bodyParser = Action(parse.tolerantText) { request =>
    Ok(request.body)
  }
}