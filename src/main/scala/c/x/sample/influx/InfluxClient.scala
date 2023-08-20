package c.x.sample.influx

import akka.actor.ActorSystem
import c.x.sample.RuntimeConfig
import com.influxdb.client.scala.InfluxDBClientScalaFactory

import java.sql.Timestamp
import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDate, LocalDateTime}
import java.util.Date
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object  InfluxClient {
  implicit val system: ActorSystem = ActorSystem("influxConn")

  val url = RuntimeConfig("influx.url")
  val token = RuntimeConfig("influx.authToken")
  val org = RuntimeConfig("influx.org")
  val bucket = "tfStudySample"

  val client = InfluxDBClientScalaFactory.create(url, token.toCharArray, org, bucket)

  def getProdCount(seedNo: Long, term: String, startDt: String, endDt: String, windowSizeDt: String) = {
    val query =
      s"""
         |from(bucket: "tfStudySample")
         |  |> range(start: ${startDt}, stop: ${endDt})
         |  |> filter(fn: (r) => r["_measurement"] == "term_tf")
         |  |> filter(fn: (r) => r["_field"] == "tf")
         |  |> filter(fn: (r) => r["seedId"] == "${seedNo}")
         |  |> filter(fn: (r) => r["term"] == "${term}")
         |  |> aggregateWindow(every: ${windowSizeDt}, fn: sum, createEmpty: true)
         |  |> yield(name: "sum")
         |""".stripMargin

//    val result = client.getQueryScalaApi().query(query)
//    var resData = Seq[DatePeriodCount]()
//
//    def date2long(ts: String) = {
//      try {
//        val localDate = LocalDateTime.parse(ts, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))
//        Timestamp.valueOf(localDate).getTime
//      } catch {
//        case e: Exception => println
//      }
//      -1L
//    }
//
//    Await.result(result.runForeach(f => {
//      if (f.getValue != null)
//        resData = resData :+ DatePeriodCount(f.getTime.toEpochMilli, f.getValue.toString.toLong)
//      else
//        resData = resData :+ DatePeriodCount(f.getTime.toEpochMilli, 0L)
//    }), Duration.Inf)
//
//    resData
  }

}
