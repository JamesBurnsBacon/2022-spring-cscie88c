package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class ListUtilsTest extends StandardTest {
<<<<<<< Updated upstream
  // "ListUtils" when {
  //   "calling ones" should {
  //     "return the correct value" in {
  //       // write unit test here
  //     }
    
  //   }

  //   // write unit tests for zeroes, and other functions here
  // }

=======
  val DogSentence: String = "The quick brown fox jumps over the lazy dog"
 // val SimplifyCharCountsOutput: Set[Char] = (s: String) => ListUtils.charCounts(_).keySet
  //val Alphabet: Set[Char] = ('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
  "ListUtils" when {
    "calling ones" should {
      "return the correct value" in {
        ListUtils.ones(4) should contain only (1)
      }
    }
    "calling zeros" should {
      "return the correct value" in {
        ListUtils.zeros(4) should contain only (0)
      }
    }
    "calling charCounts" should {
      "verify the char frequencies for 'Hello world' correctly" in {
        ListUtils.charCounts("Hello world") should be (Map('e' -> 1, 'l' -> 3, 'h' -> 1, 'w' -> 1, 'r' -> 1, 'o' -> 2, 'd' -> 1))
      }
      "verify the sentence 'The quick brown fox jumps over the lazy dog' is a pangram" in {
        ListUtils.charCounts(DogSentence).keySet should contain allOf ('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
      }
    }
    "calling topN" should {
      "verify the top 2 elements were pulled from the map of chars, by count size" in {
        ListUtils.topN(2)(ListUtils.charCounts("Hello world")) should be (Map('l' -> 3, 'o' -> 2))
      }
    }
  }
>>>>>>> Stashed changes
}

// class ListUtilsTest
//     extends AnyFunSuite
//        with Matchers
//        with ScalaCheckPropertyChecks {
//            test("ListUtils ones list test") {
//             forAll { (x: Int) =>
//               ListUtils.ones(x) should contain only (0)
//             }
//            test("ListUtils ones list test") {
//             forAll { (x: Int) =>
//               ListUtils.ones(x) should contain only (1)
//             }
//     }
// }
