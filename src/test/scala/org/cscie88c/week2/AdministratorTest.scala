package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Administrator below
class AdministratorTest extends StandardTest {
  "Administrator" when {
    val MichaelDrake: Administrator = new Administrator(
      "Michael Drake",
      "mdrake@universityofcalifornia.edu",
      8675309
    )
    "instantiated" should {
      "description includes name" in {
        MichaelDrake.description should include("Drake")
      }
      "description includes email" in {
        MichaelDrake.description should include(
          "mdrake@universityofcalifornia.edu"
        )
      }
      "description includes budget" in {
        MichaelDrake.description should include("8675309")
      }
    }
  }
}
