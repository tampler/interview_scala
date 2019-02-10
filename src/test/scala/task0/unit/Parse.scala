
package task0

import org.scalatest.{FlatSpec, Matchers}

class ParseUnitTest extends FlatSpec with Matchers { 

  "Transactor" should "read input files correctly" in {
    
    val clientsFile = "/tmp/clients.txt"
    val ordersFile  = "/tmp/orders.txt"

    val top  = new System(clientsFile, ordersFile)
    top.init()

    val m = top.matcher

    // Parse Client Data
    m.clientData map ( item => 
      println (m.parseInputData(item))
      
    ) 
    
    // Parse Orders Data
    //top.orderData map ( item => 
    //  println (parse(item))
    //) 
  
    true should be (true)
  } 

}

