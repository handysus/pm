package controllers

import javax.inject._
import models.PajakMasukan
import play.api._
import play.api.libs.json.Json
import play.api.libs.json.Json.toJson
import play.api.mvc._
import repositories.PajakMasukanRepository

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HomeController @Inject()(pajakMasukanRepository: PajakMasukanRepository, cc: ControllerComponents)
                              (implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def findAllPm = Action.async {implicit request =>
    pajakMasukanRepository.findAll().map{
      pm => Ok(Json.toJson(pm))
    }
  }

  def findById(id: Long) = Action.async{ implicit request =>
    pajakMasukanRepository.findById(Some(id))
      .map(toJson(_))
      .map(Ok(_))
  }

  def createPm() = Action.async(parse.json) { implicit request =>
    request.body.validate[PajakMasukan].fold(
      _ => Future.successful(BadRequest(Json.obj("errorMessage" -> "Invalid Bad Request"))),
      pm => {
        pajakMasukanRepository
          .create(pm)
          .map(toJson(_))
          .map(Created(_))
      }
    )
  }

  def updatePm() = Action.async(parse.json) { implicit request =>
    request.body.validate[PajakMasukan].fold(
      _ => Future.successful(BadRequest(Json.obj("errorMessage"->"Invalid Bad Request"))),
      pm => {
        pajakMasukanRepository
          .update(pm)
          .map(toJson(_))
          .map(Accepted(_))
      }
    )
  }

  def delete(id: Long) = Action.async{ implicit request =>
    pajakMasukanRepository
      .delete(Some(id))
      .map(_ => Ok)
  }
}
