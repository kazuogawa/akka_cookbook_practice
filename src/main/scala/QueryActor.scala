import akka.actor.Actor

class QueryActor extends Actor{
  import Messages._

  override def receive: Receive = {
    case Start(actorRef) => {
      println("send me the nex random number")
      actorRef ! GiveMeRandomNumber
    }
    case Done(randomNumber) => {
      println(s"reseived a random number $randomNumber")
    }
  }

}
