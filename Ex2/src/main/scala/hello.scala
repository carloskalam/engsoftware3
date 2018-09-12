import akka.actor._

class HelloActor extends Actor{
    
    override def receive: Receive = {
        case "ola" => println("Ola do akka")
        case "teste" => println("Teste")
        case "child" => {
            //DISPARAMOS UM NOVO NO FILHO DE HELLOACTOR
            val filho = context.actorOf(Props.empty,"flihoDoHello")
            println(filho)
        }
        case _ => println("Erro")
    }
    
}

object Main{
    def main(args: Array[String]): Unit = {
        val system = ActorSystem("HelloSystem")
        val act = system.actorOf(Props[HelloActor],"act")
        println(act)
        act ! "child"
    }
}