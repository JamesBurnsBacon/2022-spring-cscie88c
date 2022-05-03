package org.cscie88c.week11

// import cats._
// import cats.implicits._

// final case class WritableRow(
//   customerId: String,
//   averageAmount: Double
// )

// final case class AverageTransactionAggregate(
//   customerId: String,
//   totalAmount: Double,
//   count: Long
// ) {
//   def averageAmount: Double = totalAmount / count
// }


// object AverageTansactionAggregate {
//   def apply(raw: RawTransaction): AverageTransactionAggregate = {
//     AverageTansactionAggregate(raw.customer_id, raw.tran_amount, 1)
//   }

//   implicit val averageTransactionMonoid: Monoid[AverageTransactionAggregate] = {
//     override def empty
//   }
// }


// final case class RawTransaction(
//   customer_id: String,
//   trans_date: String,
//   tran_amount: Double
// )