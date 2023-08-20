package c.x

import org.scalatra.test.scalatest._

class stdWebProjectTests extends ScalatraFunSuite {

  addServlet(classOf[stdWebProject], "/*")

  test("GET / on stdWebProject should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
