package c.x.sample.db

import slick.jdbc.MySQLProfile.api._
import java.sql.Timestamp

object ServiceRepo {

  case class BlackApp (
                      regNo: Long,
                      appId : Option[String],
                      memo: Option[String],
                      regDt: Option[Timestamp]
                      )

  class BlackAppSchema(tag: Tag) extends Table[BlackApp](tag, None, "TB_BLACK_APPS") {
    def regNo = column[Long]("REG_NO", O.PrimaryKey, O.AutoInc)
    def addId = column[Option[String]]("APP_ID")
    def memo = column[Option[String]]("MEMO")
    def regDt = column[Option[Timestamp]]("REG_DT")

    def * = (regNo, addId, memo, regDt) <> (BlackApp.tupled, BlackApp.unapply)
  }

  val blackAppQuery = TableQuery[BlackAppSchema]

}
