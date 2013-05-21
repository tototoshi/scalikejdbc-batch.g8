import scalikejdbc._
import scalikejdbc.config._

object Main {

  def main(args: Array[String]): Unit = {
    DBs.setupAll()

    DB readOnly { implicit session =>
      SQL("SELECT 'HELLO' as hello").foreach { rs =>
        println(rs.string("hello"))
      }
    }

    DBs.closeAll()
  }

}
