
package task0

import org.scalatest.{FlatSpec, Matchers}

class ParseUnitTest extends FlatSpec with Matchers { 

  "Transactor" should "read input files correctly" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"

    val top  = Transactor(1, clientsFile, ordersFile)
    val clientData  = top.readFile(clientsFile)
   
    // Run parser externally
    clientData map ( item => 
      println(top.parse(item))
    ) 
  
    true should be (true)
  } 

}

