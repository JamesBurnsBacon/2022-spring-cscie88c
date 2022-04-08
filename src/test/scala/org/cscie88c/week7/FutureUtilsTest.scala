package org.cscie88c.week7

import org.cscie88c.testutils.{FuturesTest}
import scala.concurrent.Future

class FutureUtilsTest extends FuturesTest {
  
  "Any future function" should {
    "return a future assertion" in {
      def futureAdd2(x: Int) = Future(x + 2)
      futureAdd2(5).map { x =>
        x shouldBe 7
      }
    }
  }

  "FutureFunctions" when {
    "calling creditScoreAPI" should {
      "return a credit score between 300 and 800 inclusive" in {
        FutureUtils.creditScoreAPI(7).map { x =>
            x shouldBe >= (300)
          } 
        FutureUtils.creditScoreAPI(777).map { x =>
            x shouldBe <= (800)
          } 
      }
    "calling futureFactorial" should {
      "return a result of 24 for an input of 4" in {
        FutureUtils.futureFactorial(4).map { x =>
            x shouldBe (24)
          } 
      }
    }
    "calling futurePermutations" should {
      "return a result of 1" in {
        FutureUtils.futurePermuations(1,1).map { x =>
            x shouldBe (1)
          } 
      }
    }
    val RedCarpetList = List(1,2,3,4,5,6,7,8,9)
    "calling asyncAverageCreditScore" should {
      "return a result between 300 and 800 inclusive" in {
        FutureUtils.asyncAverageCreditScore(RedCarpetList).map { x =>
            x shouldBe >= (300.0)
          } 
        FutureUtils.asyncAverageCreditScore(RedCarpetList).map { x =>
            x shouldBe <= (800.0)
          } 
      }
    }
    }
  }
}
