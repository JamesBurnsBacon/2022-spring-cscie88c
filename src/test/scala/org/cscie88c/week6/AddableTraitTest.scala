package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class AddableTraitTest extends StandardTest {

  // "plus" should {

<<<<<<< Updated upstream
  //   "add two MyInt values correctly" in {
  //     // add your unit tests for MyInt below
  //   }

  //   "add two MyBool values correctly" in {
  //     // add your unit tests for MyBool below
  //   }
  //  } 
=======
    "add two MyInt values correctly" in {
      MyInt(5).plus(MyInt(3)) should be (MyInt(8))
    }

    "add two MyBool values correctly" in {
      MyBool(true).plus(MyBool(false)) should be (MyBool(true))
      MyBool(true).plus(MyBool(true)) should be (MyBool(true))
      MyBool(false).plus(MyBool(false)) should be (MyBool(false))
    }
   } 
>>>>>>> Stashed changes
}
