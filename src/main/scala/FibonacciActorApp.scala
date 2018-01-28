import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object FibonacciActorApp extends App{
  implicit val timeout: Timeout = Timeout(10 seconds)
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props[FibonacciActor])
  // asking for result from actor
  // Futureで帰ってきたものをmapTo[欲しい型]に変形
  val future: Future[Int] = (actor ? 10).mapTo[Int]
  val fiboacciNumber = Await.result(future, 10 seconds)
  println(fiboacciNumber)
}
