
package task0

import org.scalatest.{FlatSpec, Matchers}

class ParseUnitTest extends FlatSpec with Matchers { 

  "Transactor" should "read input files correctly" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"

    val top  = Transactor(1, clientsFile, ordersFile)
    val parse = top.parseInputData(_)
    
    // Parse Client Data
    top.clientData map ( item => 
      println (parse(item))
      
    ) 
    
    // Parse Orders Data
    top.orderData map ( item => 
      println (parse(item))
    ) 
  
    true should be (true)
  } 

}

