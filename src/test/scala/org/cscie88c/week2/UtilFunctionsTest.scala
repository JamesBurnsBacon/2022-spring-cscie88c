package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

class UtilFunctionsTest extends StandardTest {
<<<<<<< Updated upstream
  
  // "UtilFunctions" when {
  //   "maximum" should {
  //     "return maximum of two ints when first integer is greater" in {
  //       UtilFunctions.maximum(2, 1) should be (2)
  //     }
  //     // add more unit tests for maximum below
  //   }

  //   // add unit tests for average below
    
  // }
=======

  "UtilFunctions" when {
    "maximum" should {
      "return maximum of two ints when first integer is greater" in {
        UtilFunctions.maximum(2, 1) should be(2)
      }
      // add more unit tests for maximum below
      "return maximum of two ints when second integer is greater" in {
        UtilFunctions.maximum(6, 9) should be(9)
      }
      "return maximum of two ints when second integer is very large" in {
        UtilFunctions.maximum(6, 9000) should be(9000)
      }
    }
    // add unit tests for average below
    "average" should {
      "return average of two ints 2 and 4 as 3" in {
        UtilFunctions.average(2, 4) should be(3.0)
      }
      "return average of two ints 500 and 1 as 250.5" in {
        UtilFunctions.average(500, 1) should be(250.5)
      }
    }
  }
>>>>>>> Stashed changes
}
