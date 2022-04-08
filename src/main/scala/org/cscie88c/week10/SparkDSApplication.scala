package org.cscie88c.week10

// import org.apache.spark.sql.SparkSession
// import com.typesafe.scalalogging.{LazyLogging}
// import org.cscie88c.config.{ConfigUtils}
// import org.cscie88c.utils.{SparkUtils}
// import org.apache.spark.sql.{Dataset}
// import pureconfig.generic.auto._
// import org.cscie88c.prereq.CustomerTransaction

// // write config case class below
// case class SparkDSConfig(name: String, masterUrl: String, transactionFile: String)

// // run with: sbt "runMain org.cscie88c.week10.SparkDSApplication"
// object SparkDSApplication {

//   // application main entry point
//   def main(args: Array[String]): Unit = {
//     implicit val conf:SparkDSConfig = readConfig()
//     val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)
//     val transactionDS = loadData(spark)
//     val totalsByCategoryDS = transactionTotalsByCategory(spark,transactionDS)
//     printTransactionTotalsByCategory(totalsByCategoryDS)
//     spark.stop()
//   }

//   def readConfig(): SparkDSConfig = {
//   ConfigUtils.loadAppConfig[SparkDSConfig]("spark-ds-application")
// }
  
//   def loadData(spark: SparkSession)(implicit conf: SparkDSConfig): Dataset[CustomerTransaction] = {
//       import spark.implicits._
//     spark
//       .read
//       .format("csv")
//       .load() // or another similar? //2.2
//       .as[CustomerTransaction] //from Dataframe to DS
//       //https://stackoverflow.com/questions/44516627/how-to-convert-a-dataframe-to-dataset-in-apache-spark-in-scala
    
//   }

//   def transactionTotalsByCategory(spark: SparkSession, transactions: Dataset[CustomerTransaction]): Dataset[(String, Double)] = {
//     //use mapvalues before reducebygroup //can call high value transactions from TransactionCategory
//     import spark.implicits._ //unused? need encoder to work
//     val txtemp = transactions.map( x => ((x.transactionDate.takeRight(2)),x.transactionAmount))
//     txtemp
//     // txtemp.groupByKey
//     // txtemp.reduceGroups(_ + _) //mapValues?
//     // transactions.map( CustomerTransaction.apply(_).get)
//     //   .collect{case x if x != None => x}
//   }

//   def printTransactionTotalsByCategory(ds: Dataset[(String, Double)]): Unit = {
//     ds.foreach(println)
//   }
// }
