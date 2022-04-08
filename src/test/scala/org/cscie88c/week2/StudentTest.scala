package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Student below

class StudentTest extends StandardTest {
  "Student" when {
    val JamesBurns: Student =
      Student.apply("1,James,Burns,jab1132@g.harvard.edu,Male,United States")
    "instantiated" should {
      "demonstrate that the CSV data constructors work correctly, via apply method" in {
        JamesBurns.country should be("United States")
      }
    }
    "studentNamesByCountry" should {
      "return a list of student names associated with China" in {
        Student.studentNamesByCountry("China") should be(
          List("Emmy Conrart", "Jesse Chismon", "Jocelyn Blaxlande")
        )
      }
    }
    "studentTotalsByCountry" should {
      "return the number of students in China" in {
        Student.studentTotalsByCountry("China") should be(3)
      }
    }
  }
}
