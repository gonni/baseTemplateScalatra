package c.x

import org.scalatra._

class stdWebProject extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
