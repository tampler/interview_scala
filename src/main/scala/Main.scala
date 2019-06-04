package exchange

import scalaz.zio.{App, Task, UIO}
import java.io.{File, FileInputStream}

import java.nio.charset.StandardCharsets

object Main extends App {

  // run my bracket
  def run(args: List[String]) = {
    mybracket.orDie.map(_ => 0)
  }

  val mybracket:UIO[Unit] = {
    UIO {
      val file = new File("/tmp/hello")
      val mybracket = Task.effect(new FileInputStream(file)).bracket(is => UIO.effectTotal(is.close())) { is =>
        Task.effect(println(new String(is.readAllBytes(), StandardCharsets.UTF_8)))
      }
    }
  }

}
