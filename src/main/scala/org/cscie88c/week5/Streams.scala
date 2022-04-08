package org.cscie88c.week5

import java.util.UUID
import scala.util.Random
import scala.collection.mutable.ListBuffer

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] = LazyList.range(0,100,5)

  val randIntStream: LazyList[Int] = LazyList.continually(rnd.nextInt(15))

  val trueFalseRandom: Boolean = rnd.nextBoolean() 

  val dogs: LazyList[Dog] = LazyList.iterate(Dog("dog"+uuid,rnd.nextInt(15),trueFalseRandom))(p =>
    p.copy(name = "dog"+uuid, age = rnd.nextInt(15), hasCurrentShots = trueFalseRandom))

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] = {
    dogs.collect{ case Dog(x,y,z) if (z == true) => Dog(x,y,z)}
  }

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = {
    var sumTotal: Double = 0.0
    val computedList: List[Dog] = healthyDogs(allDogs).take(sampleSize).toList
    val processedList: Seq[Double] = { computedList.collect{ case Dog(x,y,z) => y } }
    sumTotal = processedList.sum
    sumTotal / sampleSize
  }

}
