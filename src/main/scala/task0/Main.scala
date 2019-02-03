
package task0


object Main extends App {
  
  val clientsFile = "/tmp/clients.txt"
  val ordersFile  = "/tmp/orders.txt"

  
  val transactor  = Transactor(1, clientsFile, ordersFile)
  transactor.init()
  
}

