package org.cscie88c.week9

import com.typesafe.scalalogging.LazyLogging
import scala.util.{Try, Success, Failure}
import scala.io.Source
import shapeless.Lazy
import java.io.FileNotFoundException

// run using: sbt "runMain org.cscie88c.week9.SimpleApp1 <args>"
//sbt "runMain org.cscie88c.week9.SimpleApp1 data/Retail_Data_Transactions.csv"
object SimpleApp1 extends LazyLogging {
  
  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try {
      LazyList.from(Source.fromResource(fileName).getLines())
    }.toOption
  
  def monthLines(month: String)(lines: LazyList[String]): LazyList[String] = {
    val MonthLazyList: LazyList[String] = lines.filter(_.contains(month))
    MonthLazyList
  }
      
  def main(args: Array[String]): Unit = {
    try {
      val TxInJan = (monthLines("Jan")(lineStreamFromFile(args(0)).getOrElse(LazyList("Month")))).length
      println("Transactions in Jan: "+ TxInJan)
    } catch {
        case e: FileNotFoundException => println("No Transactions found for Jan")
        case e: NoSuchElementException => println("No Transactions found for Jan")
    }
  }

}
