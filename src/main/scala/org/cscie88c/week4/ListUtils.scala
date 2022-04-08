package org.cscie88c.week4

import scala.collection.mutable.ListMap

object ListUtils {
  // complete the function below
  def initDoubleList(initValue: Double)(size: Int): List[Double] = List.fill(size)(initValue)

  // complete the functions below using currying
  def ones: Int => List[Double] = {
    initDoubleList(1.0)(_)
  }
  def zeros: Int => List[Double] = {
    initDoubleList(0.0)(_)
  }

  // complete the functions below
  def charCounts(sentence: String): Map[Char, Int] = {
    val sentenceLowercased = sentence.toLowerCase().replaceAll("\\s","")
    (sentenceLowercased.groupBy(identity).transform((k,v) => v.size))
  }

  def topN(n: Int)(frequencies: Map[Char, Int]): Map[Char, Int] = {
    val frequenciesSorted = frequencies.toList.sortWith(_._2 > _._2)
    frequenciesSorted.take(n).toMap
  }

}
