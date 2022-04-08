package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Subject below

class SubjectTest extends StandardTest {
  "Subject" when {
    val Painting: Subject = Subject.apply("7,Painting,false")
    "instantiated" should {
      "demonstrate that the CSV data constructors work correctly, via apply method" in {
        Painting.id should be(7)
      }
    }
    "stemSubjects" should {
      "return a list of STEM subjects" in {
        Subject.stemSubjects should be(
          List(
            Subject(1, "Physics", true),
            Subject(2, "Chemistry", true),
            Subject(3, "Math", true)
          )
        )
      }
    }
  }
}
