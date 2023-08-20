package c.x.sample.view

import c.x.sample.db.ServiceRepo
import c.x.sample.db.ServiceRepo.BlackApp
import org.scalatra._
import org.scalatra.forms._
import org.scalatra.i18n.I18nSupport
import org.slf4j.LoggerFactory
import slick.jdbc.MySQLProfile.api._

trait BalckAppMngLogic extends ScalatraServlet with FormSupport with I18nSupport with FutureSupport {
  val logger =  LoggerFactory.getLogger(getClass)
  def db: Database

  get("/blackApp") {
    logger.info("Request Black App ..")

    db.run((ServiceRepo.blackAppQuery.take(20).result)).map { ba =>
      layouts.html.baseFrame.render("BlackList Apps", pagem.html.blackApp(ba))
    }
  }

  post("/updateApp") {
    "TBD"
  }

}

class BlackAppMngLogicController(val db: Database)  extends ScalatraServlet with FutureSupport with BalckAppMngLogic {
  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global
}