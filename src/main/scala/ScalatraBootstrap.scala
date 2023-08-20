import c.x._
import c.x.sample.RuntimeConfig
import c.x.sample.view.BlackAppMngLogicController
import org.scalatra._
import slick.jdbc.MySQLProfile.api._

import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    val db = Database.forURL(url = RuntimeConfig("mysql.url"),
      user = RuntimeConfig("mysql.user"),
      password = RuntimeConfig("mysql.password"),
      driver = "com.mysql.cj.jdbc.Driver")

    context.mount(new BlackAppMngLogicController(db), "/samp/*")
    context.mount(new stdWebProject, "/*")
  }
}
