package org.cscie88c.week3
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class StudentPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

<<<<<<< Updated upstream
  // val studentGen: Gen[Student] = ???

  // // complete the student list generator below if attempting bonus problem
  // // val studentListGen: Gen[List[Student]] = ???

  // test("description contains name and email") {
  //   // write your property test below
=======
  val nameGen: Gen[String] = Gen.oneOf(List("Jerry", "Elaine", "Kramer"))
  val emailGen: Gen[String] =
    Gen.alphaChar + "@" + Gen.stringOfN(3, Gen.alphaChar) + ".com"
  val subjectGen: Gen[String] = Gen.oneOf(List("English", "Math", "Science"))
  val scoreGen: Gen[Int] = Gen.choose(0, 100)
  val studentGen: Gen[Student] = for {
    name <- nameGen
    email <- emailGen
    subject <- subjectGen
    score <- scoreGen
  } yield Student(name, email, subject, score) //types, removed .apply

  // complete the student list generator below if attempting bonus problem
  val studentListGen: Gen[List[Student]] = Gen.listOf(studentGen)

  test("description contains name and email") {
    forAll(studentGen) { (s: Student) =>
      s.description should include(s.name)
      s.description should include(s.email)
    }
  }
  // test("averageScoreBySubject < 100 for Math") {
  //   forAll(studentListGen) {
  //     Student.averageScoreBySubject("Math", studentListGen.sample.get) should be < (100)
  //   }
  //   }
  // }
  //   forAll(studentListGen) { (s: List[Student]) => { case(s)) =>
  //     UtilFunctions.pythTest(x,y,z) should be (UtilFunctions.pythTest(y*2,x*2,z*2))
  //   }
  //     s.description should include(s.name)
  //     s.description should include(s.email)
  //   }
>>>>>>> Stashed changes
  // }
}
// "description includes name" in {
//         RichardAlpert.description should include ("Richard")
//       }
