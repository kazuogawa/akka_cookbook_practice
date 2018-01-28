import akka.actor.{ActorSystem, Props}

object Communication extends App{
  import Messages._
  val actorSystem = ActorSystem("HelloAkka")
  val randomNumberGeneratorActor = actorSystem.actorOf(Props[RandomNumberGeneratorActor], "RandomNumberGeneratorActor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "QueryActor")
  while (true){
    queryActor ! Start(randomNumberGeneratorActor)
    Thread.sleep(1000)
  }
}
