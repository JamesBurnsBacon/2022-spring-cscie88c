package org.cscie88c.week11

// import cats._
// import cats.implicits._
// import org.apache.spark.sql.SparkSession
// import com.typesafe.scalalogging.{LazyLogging}
// import org.cscie88c.config.{ConfigUtils}
// import org.cscie88c.utils.SparkUtils
// import pureconfig.generic.auto._
// import org.apache.spark.sql.{Dataset}
// import org.apache.spark.sql.SaveMode
// import scala.collection.immutable
// import org.apache.spark.sql.DataFrame


// case class SparkAverageTransactionAggregateJobConfig(
//   name: String,
//   masterUrl: String,
//   inputPathTransaction: String,
//   inputPathResponse: String,
//   outputPathTransaction: String,
//   outputPathResponseTransaction: String)

// object SparkAverageTransactionAggregateJob extends LazyLogging {

//   // implicit val monoid: Monoid[AverageTransactionAggregate] = new Monoid[AverageTransactionAggregate] {
//   //   override def empty: SparkAverageTransactionAggregateJob = SparkAverageTransactionAggregateJob("","","","","","")

//   // }

// def main(args: Array[String]): Unit = {
//     logger.info("XXXX: Start of Advanced SparkApp")
//     implicit val appSettings = ConfigUtils.loadAppConfig[SparkAverageTransactionAggregateJobConfig]("org.cscie88c.spark-advanced-application")
//     val spark = SparkUtils.sparkSession(appSettings.name, appSettings.masterUrl)
//     logger.info(s"settings: $appSettings")
//     runJob(spark)
//     spark.stop()
//     logger.info("XXXX: Stopped Advanced SparkApp")
//   }

//   def runJob(spark: SparkSession)(implicit conf: SparkAverageTransactionAggregateJobConfig): Unit = {
//     val transactionDS: Dataset[RawTransaction] = loadTransactionData(spark)
//     // val responseDS: Dataset[RawResponse] = loadCampaignResponseData(spark)
//     val averageTransactionById: Map[String,AverageTransactionAggregate] = aggregateDataWithMonoid(transactionDS)
//     // val customersInCampaign: Dataset[RawTransaction] = joinTransactionAndResponseData(responseDS, transactionDS)
//     // val averageTransactionForCampaign: Map[String,AverageTransactionAggregate] = aggregateDataWithMonoid(customersInCampaign)
//     saveAverageTransactionByCustomerId(spark,averageTransactionById, conf.outputPathTransaction)
//     // saveAverageTransactionByCustomerId(spark,averageTransactionForCampaign, conf.outputPathResponseTransaction)
//     // saveAverageTransactionAsParquet(spark,averageTransactionById, conf.outputPathTransaction)
//   }

//   def loadTransactionData(spark: SparkSession)(implicit conf: SparkAverageTransactionAggregateJobConfig): Dataset[RawTransaction] = {
//     spark
//       .read
//       .format("csv")
//       .load()
//   }
//   //  def loadData(spark: SparkSession)(implicit conf: SparkRDDConfig): RDD[String] = {
//   //   spark.sparkContext.textFile(conf.transactionFile)
//   //   // import spark.implicits._
//   //   // spark
//   //   //   .read
//   //   //   .format("csv")
//   //   //   .load() // or another similar? //2.2
//   // }
//   // // def loadCampaignResponseData(spark: SparkSession)(implicit conf: SparkAverageTransactionAggregateJobConfig): Dataset[RawResponse] = ???

//   def aggregateDataWithMonoid(transactionDS: Dataset[RawTransaction]): Map[String,AverageTransactionAggregate] = ???

//   // def joinTransactionAndResponseData(responseDS: Dataset[RawResponse], transactionDS: Dataset[RawTransaction]): Dataset[RawTransaction] = ???

//   def saveAverageTransactionByCustomerId(spark: SparkSession, transactionsById: Map[String,AverageTransactionAggregate], path: String): Unit = ???

//   // def saveAverageTransactionAsParquet(spark: SparkSession, transactionsById: Map[String,AverageTransactionAggregate], path: String): Unit = ???
// }
