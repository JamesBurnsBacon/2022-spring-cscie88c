package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class TrigUtilsTest extends StandardTest {
  
<<<<<<< Updated upstream
  // "TrigUtils" when {
  //   "calling sin" should {
  //     "return the correct value for 90" in {
  //       // write unit test below
  //     }
    
  //   }

  //   // write tests for cos and squared below
  // }
=======
  "TrigUtils" when {
    "calling sin" should {
      "return the correct value for 90" in {
        TrigUtils.sinDegrees(90) should be (1.0)
      }
       "return the correct value for 0" in {
        TrigUtils.sinDegrees(0) should be (0.0)
      }
    }
    "calling cosine" should {
      "return the correct value for 90" in {
        TrigUtils.cosDegrees(90) should equal (0.0 +-.00001)
      }
      "return the correct value for 0" in {
        TrigUtils.cosDegrees(0) should be (1.0 +-.00001)
      }
    }
    "calling squared" should {
      "return the square of the input value for 5" in {
        TrigUtils.squared(5) should be (25)
      }
    }
  }
>>>>>>> Stashed changes
}
