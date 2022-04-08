package org.cscie88c.week7

import scala.concurrent.{Future}
import scala.util.{Try, Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.collection.parallel.CollectionConverters._

object FutureUtils {
  
  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = Future {
    rnd.between(300, 800)
  } //https://stackoverflow.com/questions/39402567/get-random-number-between-two-numbers-in-scala

  def printCreditScore(applicantId: Int): Unit = {
    creditScoreAPI(applicantId).onComplete {
      case Success(score) =>
        println(s"${applicantId} is: ${creditScoreAPI(score)}")
      case Failure(_) =>
        println(s"Cannot get credit score for ${applicantId} at this time")
    }
  }

  def passedCreditCheck(applicantId: Int): Future[Boolean] = {
      creditScoreAPI(applicantId).map { x =>
            if (x > 600) true else false
          }
  }

  def futureFactorial(n: Int): Future[Int] = Future {
    var factorial = 1
    for(i <- 1 to n)
      factorial = factorial*i
    factorial
  } //https://www.includehelp.com/scala/find-factorial-of-a-number.aspx

  def futurePermuations(n: Int, r: Int): Future[Int] = {
    for {
      factorialOfN <- futureFactorial(n).map { x => x }
      factorialofNMinusR <- futureFactorial(n-r).map { x => x }
    } yield {
      factorialOfN * factorialofNMinusR
    }
  }

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] = {
    val tempList = idList
      .map { id =>
        creditScoreAPI(id).map { x =>
          x.toDouble
        }
      }
    val tempSum = Future.sequence(tempList).map(_.sum)
    tempSum.map { x => x/tempList.length}
  }

  def slowMultiplication(x: Long, y: Long): Long = {
    Thread.sleep(1000)
    x*y
  }

  // def concurrentFactorial(n: Long): Long = {
  //   //create a list of n's components eg 3 => 3.2.1, .par that list
  //   //map or fold using slowmultiplication all elements in list
  //   n.par.map(_.slowMultiplication)
  // }

  def sequentialFactorial(n: Long): Long = {
    var factorial: Long = 1
    for(i <- 1 to n.toInt)
      factorial = slowMultiplication(i,factorial)
    factorial
  }

}
