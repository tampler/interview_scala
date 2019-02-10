
package task0

import org.scalatest.{FlatSpec, Matchers}

class SystemTest extends FlatSpec with Matchers { 

  "System" should "work OK" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"
 
    val sys  = new System(clientsFile, ordersFile)

    sys.main()
    
    true should be (true)
  } 

}

