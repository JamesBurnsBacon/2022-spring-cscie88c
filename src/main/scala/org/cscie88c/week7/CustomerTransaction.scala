package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

final case class CustomerTransaction(
  customerId: String,
  transactionDate: String,
  transactionAmount: Double
)

object CustomerTransaction {
  def apply(csvRow: String): Option[CustomerTransaction] = Try {
    val fields = csvRow.split(",")
    CustomerTransaction(
      customerId = fields(0),
      transactionDate = fields(1),
      transactionAmount = fields(2).toDouble
    )
  }.toOption

  def readFromCSVFile(fileName: String): List[CustomerTransaction] = {
    Source.fromResource(fileName)
      .getLines()
      .toList
      .map(CustomerTransaction(_))
      .collect { case Some(cust) => cust}
  } //https://stackoverflow.com/questions/53153491/how-to-unwrap-optionmyclassname
}
  //2.5 Answer: Cleansing with options was simple to write, and helps to reduce unexpected errors! Errors can also be encoded into a data structure to keep track of them.