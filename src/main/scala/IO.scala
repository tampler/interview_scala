package exchange

import scalaz.zio.{ IO, UIO }
import java.io.{ File, FileInputStream }

object zio_resources {

//--------------------------------------------------------------------------------------------
// Binary File Processing
//--------------------------------------------------------------------------------------------
  class InputStream private (is: FileInputStream) {
    def read: IO[Exception, Option[Byte]] =
      IO.effectTotal(is.read).map(i => if (i < 0) None else Some(i.toByte))
    def close: IO[Exception, Unit] =
      IO.effectTotal(is.close())
  }

  object InputStream {

    def openFile(file: File): IO[Exception, InputStream] =
      IO.effectTotal(new InputStream(new FileInputStream(file)))

    def openFile(fin: String): IO[Exception, Stream[String]] = {

      // Wrap unsafe operation into a safe IO Monad
      val stream = IO.effectTotal {
        val source = scala.io.Source.fromFile(fin)
        source.getLines.toStream
      }
      stream
    }

    def closeFile(f: File): UIO[Unit] = IO.succeedLazy(???)
  }
}
