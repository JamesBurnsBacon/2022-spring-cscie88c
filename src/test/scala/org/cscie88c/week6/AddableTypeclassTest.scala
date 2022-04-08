package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class AddableTypeclassTest extends StandardTest {
  val LieToMe: List[Boolean] = List(
    false,
    false,
    false,
    false
  )
  val SpeakTheTruth: List[Boolean] = List(
    true,
    true
  )
  val MyFavoriteNumbers: List[Int] = List (1,69,420,1996)
  
<<<<<<< Updated upstream
  // "AddableAggregator" should {
  //   "sum a list of integers" in {
  //     // add your unit tests here
  //   }
  //   "sum a list of booleans" in {
  //     // add your unit tests here
  //   }
  //   "sum a list of employees" in {
  //     // add your unit tests here
  //   }
  // }
=======
  "AddableAggregator" should {
    "sum a list of integers" in {
      AddableAggregator.sumWithAddable(MyFavoriteNumbers) should be (2486)
    }
    "sum a list of booleans" in {
      AddableAggregator.sumWithAddable(LieToMe) should be (false)
      AddableAggregator.sumWithAddable(SpeakTheTruth) should be (true)
    }
  }
>>>>>>> Stashed changes
}
