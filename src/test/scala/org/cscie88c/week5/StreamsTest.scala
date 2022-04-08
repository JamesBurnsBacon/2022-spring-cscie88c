package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
<<<<<<< Updated upstream
//import Streams.Dog
=======
import Streams.Dog
import scala.collection.mutable.ListBuffer
>>>>>>> Stashed changes

class StreamsTest extends StandardTest {
  val HealthyRover: LazyList[Dog] = (Streams.healthyDogs(Streams.dogs))
  var listOfTrues = new ListBuffer[Boolean]()
"Streams" when {
    // "calling healthyDogs" should {
    //   "return only healthy dogs current on shots" in {
    //     HealthyRover.take(5).toList.collect{ case Dog(x,y,z) => listOfTrues.append(z)} 
    //     listOfTrues(1) should be (true)
    //     listOfTrues(2) should be (true)
    //     listOfTrues(3) should be (true)
    //     listOfTrues(4) should be (true)
    //     listOfTrues(0) should be (true)
    //   }
    // }
    // "calling averageHealthyAge" should {
    //   "return the average age for a sample of healthy dogs" in {
    //     Streams.averageHealthyAge(Streams.dogs, 5) should be (7.5 +- 7.5)
    //   }
    // }
}
}