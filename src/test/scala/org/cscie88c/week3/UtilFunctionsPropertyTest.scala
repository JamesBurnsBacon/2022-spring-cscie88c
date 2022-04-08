package org.cscie88c.week3

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
//import org.scalacheck._

class UtilFunctionsPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

<<<<<<< Updated upstream
  // val triplesGen: Gen[(Int, Int, Int)] = ???

  // test("mult2 result test") {
  //   forAll { (x: Int, y: Int) =>
  //     UtilFunctions.mult2(x, y) shouldBe x * y
  //   }
  // }

  // // write more property tests below
=======
  val triplesGen: Gen[(Int, Int, Int)] = Gen.oneOf(UtilFunctions.pythTriplesUpto100)

  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      UtilFunctions.mult2(x, y) shouldBe x * y
    }
  }
  test("mult2 distributive test") {
    forAll { (a: Int, b: Int, c: Int) =>
      UtilFunctions.mult2(a, (b+c)) shouldBe ((a*b)+(a*c))
    }
  }
  test("If (x, y, z) is a pythagorean triple, then (y, x, z) is also a pythagorean triple") {
    forAll(triplesGen) { case(x,y,z) =>
      UtilFunctions.pythTest(x,y,z) should be (UtilFunctions.pythTest(y,x,z))
    }
  }
  test("If (x, y, z) is a pythagorean triple, then (2y, 2x, 2z) is also a pythagorean triple") {
    forAll(triplesGen) { case(x,y,z) =>
      UtilFunctions.pythTest(x,y,z) should be (UtilFunctions.pythTest(y*2,x*2,z*2))
    }
  }

>>>>>>> Stashed changes
}
