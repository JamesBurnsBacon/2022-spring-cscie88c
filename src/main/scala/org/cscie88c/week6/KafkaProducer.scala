package org.cscie88c.week6

// define trait KafkaProducer below
trait KafkaProducer {
  def send(message: String): String = s"$message Message sent to Kafka"
}

// define the case class SimpleKafkaProducer below
case class SimpleKafkaProducer(topic: String) extends KafkaProducer {
  override def send(message: String) = send(topic)
}

// define the companion object SimpleKafkaProducer below
object SimpleKafkaProducer {
  val default = "default-topic"
  implicit val defaultKafkaProducer: KafkaProducer = { //did not specify type before
    new SimpleKafkaProducer(default)
  }
}


// uncomment the lines below once you have implemented KafkaProducer and SimpleKafkaProducer

object KafkaClient {
  // sends a status message to kafka
  def sendStatusEvent(status: String)(implicit kafkaProducer: KafkaProducer) = {
    kafkaProducer.send(status) // use the implicit KafkaProducer provided
  }  
}

//Problem 5 //The implicit scope of the companion object is used to provide an instance for the unit test.