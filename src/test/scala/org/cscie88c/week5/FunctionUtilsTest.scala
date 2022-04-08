package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import FunctionUtils.CustomerTransaction

// run using: sbt "testOnly org.cscie88c.week5.FunctionUtilsTest"
class FunctionUtilsTest extends StandardTest {
<<<<<<< Updated upstream
  // "FunctionUtils" when {
  //   // Problem 1 unit tests
  //   "calling colorToCode" should {
  //     "return the correct value for white" in {
  //       // write unit tests here
  //     }
  //   }

  //   "calling fizzBuzzString" should {
  //     "return the correct value" in {
  //       // write unit tests here
  //     }
  //   }

  //   "calling fizzBuzz" should {
  //     "return the correct value" in {
  //       // write unit tests here
  //     }
  //   }
    
  //   // Problem 2 unit tests

  //   // Problem 3 unit tests
=======
  val HVTList: List[CustomerTransaction] = List(
    CustomerTransaction("Teletubby","022222",150),
    CustomerTransaction("Barney","022222",99),
    CustomerTransaction("BabyShark","022222",1000000)
  )
  "FunctionUtils" when {
    // Problem 1 unit tests
    "calling colorToCode" should {
      "return the correct value for lime" in {
        FunctionUtils.colorToCode("lime") should be (0,255,0)
      }
      "return the correct value for White" in {
        FunctionUtils.colorToCode("White") should be (255,255,255)
      }
    }

    "calling fizzBuzzString" should {
      "return the correct value" in {
        FunctionUtils.fizzBuzzString(3) should be ("Fizz")
        FunctionUtils.fizzBuzzString(5) should be ("Buzz")
        FunctionUtils.fizzBuzzString(15) should be ("FizzBuzz")
        FunctionUtils.fizzBuzzString(0) should be ("0")
        FunctionUtils.fizzBuzzString(1) should be ("1")
      }
    }

    "calling fizzBuzz" should {
      "return the correct value" in {
        FunctionUtils.fizzBuzz(3) should be (List("1","2","Fizz"))
      }
    }
    
    // Problem 2 unit tests
    "calling tanDegrees" should {
      "return a not defined value" in {
        FunctionUtils.tanDegrees.isDefinedAt(-90) should be (false)
        FunctionUtils.tanDegrees.isDefinedAt(90) should be (false)
      }
    }
    "calling TotalHighValueTransactions" should {
      "return a list of high value transactions only" in {
        FunctionUtils.totalHighValueTransactions(HVTList) should be (1000150)
      }
    }
    // Problem 3 unit tests
    "calling flip2" should {
      "return a flipped math.pow function" in {
        FunctionUtils.flip2(math.pow)(5,2) should be (32.0)
      }
    }
    val intList: List[Int] = List(1,2,3,4,5,6,7)
    val stringList: List[String] = List("Big","Papa")
     "calling sampleList" should {
      "return the first 5 elements in a list" in {
        FunctionUtils.sampleList(intList) should be (List(1,2,3,4,5))
        FunctionUtils.sampleList(stringList) should be (List("Big", "Papa"))
      }
    }
>>>>>>> Stashed changes

  //   // Bonus unit tests
  // }

}
