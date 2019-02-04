
package task0

import org.scalatest.{FlatSpec, Matchers}

class InitUnitTest extends FlatSpec with Matchers { 

  "Transactor" should "read input files correctly" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"

    val transactor  = Transactor(1, clientsFile, ordersFile)
    transactor.init() should be (true)

    val clientData  = transactor.readFile(clientsFile)
    transactor.show(clientData) should be (true)
  } 

}

