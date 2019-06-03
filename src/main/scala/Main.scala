package exchange

import scalaz.zio._
import java.io.IOException 
import zio_resources._
import zio_resources.InputStream._

object Main extends App {

  val groupedFileData: IO[IOException, Unit] = openFile("data.json").bracket(closeFile(_)) { file =>
    for {
      data    <- decodeData(file)
      grouped <- groupData(data)
    } yield grouped
  }
}
