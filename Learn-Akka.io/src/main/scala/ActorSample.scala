import akka.actor.{ Actor, Props, ActorSystem }
import scala.io.StdIn


class Actor1 extends Actor {
  override def receive: Receive = {
    case "nomor1" =>
      val Actor1 = context.actorOf(Props.empty, "actor-satu")
      println(s"Actor1: ${Actor1}")
    case "nomor2" =>
      val Actor2 = context.actorOf(Props[Actor2], "actor-dua")
      println(s"Actor2: ${Actor2}")
      Actor2 ! "nomor2"
  }
}

class Actor2 extends Actor {
  override def receive: Receive = {
    case "nomor2" =>
      val Actor22 = context.actorOf(Props.empty,"actor-22")
      println(s"Actor22: ${Actor22}")
  }
}

object ActorSample extends App {
  val system = ActorSystem("testSystem")

  val firstRef = system.actorOf(Props[Actor1], "first-actor")
  println(s"First: $firstRef")
  firstRef ! "nomor2"

  println(">>> Press ENTER to exit <<<")
  try StdIn.readLine()
  finally system.terminate()
}