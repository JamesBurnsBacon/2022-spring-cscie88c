package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class KafkaProducerTest extends StandardTest {
<<<<<<< Updated upstream
  // "KafkaClient" should {
  //   "send a message to the default topic" in {
  //     // add your unit tests for KafkaClient.send here
  //     // uncomment line below to provide the default KafkaProducer instance to call KafkaClient.sendStatusEvent
  //     // import SimpleKafkaProducer._
  //   }
  // }
=======
  "KafkaClient" should {
    "send a message to the default topic" in {
      // add your unit tests for KafkaClient.send here
      // uncomment line below to provide the default KafkaProducer instance to call KafkaClient.sendStatusEvent
      // import SimpleKafkaProducer._
      // KafkaClient.sendStatusEvent(SimpleKafkaProducer.default) should include ("default-topic")
    }
  }
>>>>>>> Stashed changes
}
