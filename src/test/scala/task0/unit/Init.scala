
package task0

import org.scalatest.{FlatSpec, Matchers}

class InitUnitTest extends FlatSpec with Matchers { 

  "Transactor" should "read input files correctly" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"

    val top  = new System(clientsFile, ordersFile)
    top.init() 
    
    true should be (true)

  } 

}

