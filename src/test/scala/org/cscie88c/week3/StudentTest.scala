package org.cscie88c.week3

import org.cscie88c.testutils.{ StandardTest }

class StudentTest extends StandardTest {
<<<<<<< Updated upstream
  // "Student Management System" when {
  //   "creating a student" should {
  //     "have properties - name, email, subject and score" in {
  //       // write your test here
  //     }
  //   }

  //   // write more tests to verify items in acceptance criteria
  // }
=======
  "Student Management System" when {
    val JamesBurns: Student =
      Student.apply("JamesBurns,jab1132@g.harvard.edu,Math,99")
    val JamesFire: Student =
      Student.apply("JamesFire,jab1132@g.harvard.edu,Math,88")
    val JamesAshes: Student =
      Student.apply("JamesAshes,jab1132g.harvard.edu,English,77")
    val JamesPhoenix: Student =
      Student.apply("JamesPhoenix,jab1132@g.harvard.edu,Science,100")
    val KrystalBall: Student =
      Student.apply("KrystalBall,kball@media.com,English,95")
    val week3students: List[Student] =
      List(JamesBurns, JamesFire, JamesAshes, JamesPhoenix, KrystalBall)
    "creating a student" should {
      "have properties - name, email, subject and score" in {
        JamesBurns.name should be("JamesBurns")
        JamesBurns.email should be("jab1132@g.harvard.edu")
        JamesBurns.subject should be("Math")
        JamesBurns.score should be(99)
      }
      "have a validate email function that returns true when emails include @" in {
        Student.validateEmail(JamesFire) should be(true)
      }
      "have a validate email function that returns false when emails lack @" in {
        Student.validateEmail(JamesAshes) should be(false)
      }
      "have an average score by subject function that returns the average score for a subject for a list of students" in {
        Student.averageScoreBySubject("Math", week3students) should be(93.5)
      }
      "have an average score by student function that returns the average score for a student in a list of students" in {
        Student.averageScoreByStudent(JamesBurns, week3students) should be(99)
      }
    }

    // wrote more tests to verify items in acceptance criteria
  }
>>>>>>> Stashed changes

}
