package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class FunctionUtilsTest extends StandardTest {
  def add5(x: Int) = (x + 5)
  val myDeferredFunction = FunctionUtils.deferredExecutor("CPU Pool")(add5)
  val result = myDeferredFunction(4)


<<<<<<< Updated upstream
  //  "FunctionUtils" when {
  //   "calling applyNtimes" should {
  //     "return the correct value" in {
  //       // write unit test here
  //     }
    
  //   }

  //   // write unit tests for other functions here
  // }
=======
   "FunctionUtils" when {
    "calling applyNtimes" should {
      "return the correct value" in {
        FunctionUtils.applyNtimes(5)(0)(add5) should be (25)
        FunctionUtils.applyNtimes(10)(0)(add5) should be (50)
      }
    }
    "calling myPositivePower" should {
      "return the correct value" in {
        FunctionUtils.myPositivePower(0,1) should be (0)
      }
    }
    "calling myDeferredFunction" should {
      "return the correct value" in {
        result should be (9)
      }
    }
    
  }
>>>>>>> Stashed changes
 
}
