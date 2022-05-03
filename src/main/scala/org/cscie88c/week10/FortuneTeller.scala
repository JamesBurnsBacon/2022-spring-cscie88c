package org.cscie88c.week10

// //import scala.util.{Try}
// import scala.math.BigInt
// //import cats.instances.long

// final case class FortuneTeller(
//   timestamp: String,
//   usd: Double,
//   hashrate: BigInt,
//   activeAccounts: Long
//   )
// {
//   def transactionYear: String = {
//     transactionDate.split("-")(2)
//   }
//   def transactionCategory: String = {
//     if (transactionAmount > 80) "High"
//     else "Standard"
//   }
// }

// object FortuneTeller {
//   def apply(csvRow: String): Option[FortuneTeller] = Try {
//     val fields = csvRow.split(",")
//     FortuneTeller(
//       timestamp = fields(0),
//       usd = fields(1).toDouble,
//       hashrate = BigInt(fields(2)), //bigint error
//       activeAccounts = fields(3).toLong
//     )
//   }.toOption
// }
//https://stackoverflow.com/questions/15717240/how-do-i-convert-a-string-to-a-biginteger
//https://stackoverflow.com/questions/18149132/is-there-a-method-which-convert-elements-in-string-to-bigint


// final case class RawTransaction(
//   customer_id: String,
//   trans_date: String,
//   tran_amount: Double
// )

// final case class CustomerTransaction(
//   customerId: String,
//   transactionDate: String,
//   transactionAmount: Double
// ) {
//   def transactionYear: String = {
//     transactionDate.split("-")(2)
//   }
//   def transactionCategory: String = {
//     if (transactionAmount > 80) "High"
//     else "Standard"
//   }
// }

// object CustomerTransaction {
//   def apply(csvRow: String): Option[CustomerTransaction] = Try {
//     val fields = csvRow.split(",")
//     CustomerTransaction(
//       customerId = fields(0),
//       transactionDate = fields(1),
//       transactionAmount = fields(2).toDouble
//     )
//   }.toOption

//   def applyy(raw: RawTransaction): CustomerTransaction = //added extra y
//     CustomerTransaction(
//       customerId = raw.customer_id,
//       transactionDate = raw.trans_date,
//       transactionAmount = raw.tran_amount)
// }
