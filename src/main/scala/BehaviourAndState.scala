import akka.actor.Props
import akka.actor.ActorSystem
object BehaviourAndState extends App {
  val actorSystem = ActorSystem("HelloAkka")
  // creating an actor inside the actor system
  val actor = actorSystem.actorOf(Props[SummingActor], "summingActor")
  // print actor path
  println(actor.path)
  actor ! 1
}
