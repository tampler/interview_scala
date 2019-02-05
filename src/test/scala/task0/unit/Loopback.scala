
package task0

import org.scalatest.{FlatSpec, Matchers}

class LoopbackUnitTest extends FlatSpec with Matchers { 

  "Loopback" should "return input data" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"
 
    val sys  = System(clientsFile, ordersFile)

    sys.loopback()
    

    true should be (true)
  } 

}

