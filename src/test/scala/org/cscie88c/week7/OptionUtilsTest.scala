package org.cscie88c.week7

import org.cscie88c.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}
//import data.(dirty-retail-data-sample) //2022-SPRING-CSCIE88C.src.main.resources.data

class OptionUtilsTest extends StandardTest {
  "OptionUtils" when {
    "calling fileCharCount" should {
      "return the correct number of characters in a valid file" in {
        OptionUtils.fileCharCount("data/dirty-retail-data-sample.csv").get should be (195)
      }
    }
    "calling charCountString" should {
      "return the correct response for existing and not found files" in {
      OptionUtils.charCountAsString("data/dirty-retail-data-sample.csv") should be ("number of characters: 195")
      OptionUtils.charCountAsString("data/dirty-retail-data-sample.csv-x") should be ("error opening file")
      }
    }
  }

}
