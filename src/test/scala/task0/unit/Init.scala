
package task0

import org.scalatest.{FlatSpec, Matchers}

class InitUnitTest extends FlatSpec with Matchers { 

  "Transactor" should "read input files correctly" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"

    val top  = Transactor(1, clientsFile, ordersFile)
    top.init() should be (true)
    top.parse (top.clientData)

    val clientData  = top.readFile(clientsFile)
    top.show(clientData) should be (true)
  } 

}

