package org.cscie88c.week9

import com.typesafe.scalalogging.LazyLogging
import scala.util.{Try, Success, Failure}
import scala.io.Source
import org.cscie88c.config.{ConfigUtils}
import pureconfig.generic.auto._
import pureconfig.ConfigFieldMapping
import java.io.FileNotFoundException
import pureconfig._

// // write case class here
// case class FileAndMonth(fileName: String, month: String)

// // run with: sbt "runMain org.cscie88c.week9.SimpleApp2"
// object SimpleApp2 extends LazyLogging{
//   val CONFIG_PATH="org.cscie88c.simple-app-2"
//   val conf = ConfigUtils.loadAppConfig[FileAndMonth](CONFIG_PATH)

//   def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
//     Try {
//       LazyList.from(Source.fromResource(fileName).getLines())
//     }.toOption
  
//   def monthLines(month: String)(lines: LazyList[String]): LazyList[String] = {
//     val MonthLazyList: LazyList[String] = lines.filter(_.contains(month))
//     MonthLazyList
//   }
      
//   def main(args: Array[String] = Array(conf.fileName)): Unit =  {
//     try {
//       val TxInMonth = (monthLines(conf.month)(lineStreamFromFile(conf.fileName).getOrElse(LazyList("Month")))).length
//       println(s"Transactions in ${conf.month}: "+ TxInMonth)
//     } catch {
//         case e: FileNotFoundException => println("No Transactions found for Month Selected")
//         case e: NoSuchElementException => println("No Transactions found for Month Selected")
//     }
//   }
// }
