package exchange

import scalaz.zio.{ App, DefaultRuntime, Task, UIO }

import java.io.{ File, FileInputStream }
import java.nio.charset.StandardCharsets

object Main extends App {

  val rt = new DefaultRuntime {}

  // run my bracket
  def run(args: List[String]) =
    mybracket.orDie.map(_ => 0)

  def closeStream(is: FileInputStream) =
    UIO.effectTotal(is.close())

  def convertBytes(is: FileInputStream) =
    Task.effect(println(new String(is.readAllBytes(), StandardCharsets.UTF_8)))

  val mybracket: UIO[Unit] = {

    UIO {

      val file = new File("/tmp/hello")

      val string = Task.effect(new FileInputStream(file)).bracket(closeStream)(convertBytes).orDie

      rt.unsafeRun(string)

    }
  }
}
