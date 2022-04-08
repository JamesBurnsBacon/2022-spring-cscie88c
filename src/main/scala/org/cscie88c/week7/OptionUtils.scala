package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}
//import shapeless.Lazy

object OptionUtils {
  
  def fileCharCount(fileName: String): Try[Long] = Try {
    Source.fromResource(fileName).mkString.length() - Source.fromResource(fileName).getLines().length
  }

  def charCountAsString(fileName: String): String = {
      fileCharCount(fileName)
    } match {
      case Success(value) => "number of characters: "+ value //.toString
      case Failure(e) => { 
      println(s"error opening file: ${e.getMessage}")
      "error opening file"}
    }


  def lineStreamFromFile(fileName: String): Option[LazyList[String]] = {
    val stringIterator = scala.io.Source.fromResource(fileName).mkString.linesIterator
    val stringStream: Option[LazyList[String]] = Some(LazyList.from(stringIterator))
    stringStream
  }
}
