package org.cscie88c.week7

import org.cscie88c.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class CustomerTransactionTest extends StandardTest {
  "CustomerTransaction" should {
    "load and clean raw CSV data file" in {
      CustomerTransaction("id1,customer-A,84.5") should be (Some(CustomerTransaction("id1","customer-A",84.5)))
      CustomerTransaction("id1,customer-A,84.5x") should be (None)
    }
    "verify that 5 valid customer records are read" in {
      CustomerTransaction.readFromCSVFile("data/dirty-retail-data-sample.csv").length should be (5)
    }
  }

}
