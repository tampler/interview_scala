
package Resources_pkg

import java.io.{File, FileInputStream}
import scalaz.zio.{IO}

//--------------------------------------------------------------------------------------------
// Binary File Processing
//--------------------------------------------------------------------------------------------

class InputStream private (is: FileInputStream) {
  def read: IO[Exception, Option[Byte]] =
    IO.syncException(is.read).map(i => if (i < 0) None else Some(i.toByte))
  def close: IO[Exception, Unit] =
    IO.syncException(is.close())
}

object InputStream {
  def openFile(file: File): IO[Exception, InputStream] =
    IO.syncException(new InputStream(new FileInputStream(file)))
}

//--------------------------------------------------------------------------------------------
// ASCII File Processing
//--------------------------------------------------------------------------------------------

final object Temp {

def readFile (fin:String): IO[Exception, Stream[String]] = {

  // Wrap unsafe operation into a safe IO Monad
  val stream = IO.syncException {
    val source = scala.io.Source.fromFile(fin)
    source.getLines.toStream
  }

  stream 
}

}

