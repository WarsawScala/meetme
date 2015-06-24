package pl.warsawscalania.meetup.controller

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Tests [[pl.warsawscalania.meetme.controller.Meetme]] controller
 */
@RunWith(classOf[JUnitRunner])
class MeetmeSpec extends Specification {


    "Meetme" should {

      "show send position" in new WithApplication{
        val position = route(FakeRequest(PUT, "/position/marek/123/321")).get

        status(position) must equalTo(OK)
        contentType(position) must beSome.which(_ == "text/plain")
        contentAsString(position) must contain ("Position(123.0,321.0,marek)")
      }

      "report error when lat can't be converted to double" in new WithApplication {
        val position = route(FakeRequest(PUT, "/position/marek/abc/321")).get

        status(position) must equalTo(BAD_REQUEST)
        contentType(position) must beSome.which(_ == "text/plain")
        contentAsString(position) must contain ("Wrong lat `abc` or long `321`")
      }

      "report error when long can't be converted to double" in new WithApplication {
        val position = route(FakeRequest(PUT, "/position/marek/123/abc")).get

        status(position) must equalTo(BAD_REQUEST)
        contentType(position) must beSome.which(_ == "text/plain")
        contentAsString(position) must contain ("Wrong lat `123` or long `abc`")
      }

    }

}
