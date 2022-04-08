package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for University employee below
class UniversityEmployeeTest extends StandardTest {
<<<<<<< Updated upstream
  // "UniversityEmployee" when {
  //   "instantiated" should {
  //     "have a name property" in {
  //       true shouldBe true
  //     }
  //   }
  // }
=======
  "UniversityEmployee" when {
    val LightningMcQueen: UniversityEmployee =
      new UniversityEmployee("LightningMcQueen", "iamspeed@nascar.com")
    val TowMater: UniversityEmployee =
      new UniversityEmployee("TowMater", "rusty@aol.com")
    "instantiated" should {
      "have a name property" in {
        LightningMcQueen.name should startWith("LightningMcQueen")
      }
      "have an email property" in {
        TowMater.email should include(".com")
      }
      "description includes name" in {
        LightningMcQueen.description should include("Lightning")
      }
      "description includes email" in {
        LightningMcQueen.description should include("iamspeed@nascar.com")
      }
    }
  }
>>>>>>> Stashed changes
}
