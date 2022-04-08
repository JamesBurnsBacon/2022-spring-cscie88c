package org.cscie88c.week5

import scala.math
import scala.collection.mutable.ListBuffer

object FunctionUtils {

  case class CustomerTransaction(customerId: String,transactionDate: String,transactionAmount: Double)

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) = color.toLowerCase() match {
    case "black" => (0,0,0)
    case "white" => (255,255,255)
    case "red" => (255,0,0)
    case "lime" => (0,255,0)
    case "blue" => (0,0,255)
    case "yellow" => (255,255,0)
  }

  def fizzBuzzString(n: Int): String = n match {
    case n if n == 0 => "0"
    case n if ((n % 3) == 0) && ((n % 5) == 0) => "FizzBuzz"
    case n if (n % 3) == 0 => "Fizz"
    case n if (n % 5) == 0 => "Buzz"
    case n => n.toString()
  }

  def fizzBuzz(n: Int): List[String] = {
    val returnList = new ListBuffer[String]()
    for (i <- 1 to n) { returnList += fizzBuzzString(i) }
    returnList.toList
  } 
  //https://www.tutorialspoint.com/scala/scala_for_loop.htm
  //https://alvinalexander.com/scala/how-add-elements-to-a-list-in-scala-listbuffer-immutable/

  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = {
    case t if (t != -90.0 && t != 90.0) => {scala.math.tan(scala.math.toRadians(t))}
  } //https://stackoverflow.com/questions/17806246/partialfunction-and-matcherror
    

  def totalHighValueTransactions(transactionList: List[CustomerTransaction]): Double = {
    val transactionListOfAmounts: Seq[Double] = transactionList.collect{ case CustomerTransaction(x,y,z) if (z > 100) => z}
    transactionListOfAmounts.sum
  } //https://www.geeksforgeeks.org/scala-reduce-function/
  //After figuring the syntax out, I prefer collect, because I think the resulting code is more clear. I don't know yet what function I would map with here.

  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C = {
    (A,B) => f(B,A)
  } //https://stackoverflow.com/questions/56836885/define-function-that-flips-its-arguments

  // Write a generic function sampleList parameterized by type A, that returns the first 5 elements of a list of type A.
  def sampleList[A](l: List[A]): List[A] = {
    l.take(5)
  }
}
//3.5 Answer: def deferredExecutor[A,B,C](name: A)(f: B => C) = ???
