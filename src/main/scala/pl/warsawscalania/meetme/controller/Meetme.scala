package pl.warsawscalania.meetme.controller

import pl.warsawscalania.meetme.model.Position

import scala.util._
import play.api.mvc._


/**
 * Created by marun on 24.06.2015.
 */
class Meetme extends Controller{

  def position(id : String, lat : String, long : String) =  Action {
    request =>

      Try {
        val latitude = lat.toDouble
        val longitude = long.toDouble

        (latitude, longitude)
      } match {
        case Success( (lat, long) ) =>
          Ok(Position(lat, long, id).toString)
        case Failure(t) =>
          BadRequest(s"Wrong lat `$lat` or long `$long`")
      }
  }
}
