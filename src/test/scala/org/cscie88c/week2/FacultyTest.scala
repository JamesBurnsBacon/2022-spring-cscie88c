package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Faculty below
class FacultyTest extends StandardTest {
  "Faculty" when {
    val RichardAlpert: Faculty =
      new Faculty("Richard Alpert", "babaramdas@lsd.com", "Psychology420")
    "instantiated" should {
      "description includes name" in {
        RichardAlpert.description should include("Richard")
      }
      "description includes email" in {
        RichardAlpert.description should include("babaramdas@lsd.com")
      }
      "description includes course ID" in {
        RichardAlpert.description should include("Psychology420")
      }
    }
  }
}
