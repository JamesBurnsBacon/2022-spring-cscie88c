package org.cscie88c.week10

import org.apache.spark.sql.SparkSession
import com.typesafe.scalalogging.{LazyLogging}
import org.cscie88c.config.{ConfigUtils}
import org.cscie88c.utils.{SparkUtils}
import org.apache.spark.rdd.{RDD}
import pureconfig.generic.auto._
import org.apache.spark.rdd.PairRDDFunctions

// write case class below
//case class basicConfig(customer_id: String,trans_date: String,tran_amount: Int)
case class SparkRDDConfig(name: String, masterUrl: String, transactionFile: String)
//case class CustomerTransaction(customer_id: String,trans_date: String,tran_amount: Int) 


// run with: sbt "runMain org.cscie88c.week10.SparkRDDApplication"
object SparkRDDApplication {
  val CONFIG_PATH="org.cscie88c.spark-rdd-application" //better way?
  //val conf = ConfigUtils.loadAppConfig[BasicConfig](CONFIG_PATH) //better way?

  // application entry point
  def main(args: Array[String]): Unit = {
    implicit val conf:SparkRDDConfig = readConfig()                         // 1. read configuration
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)          // 2. initialize spark session
    val rddLines = loadData(spark)                                          // 3.load data
    val rddTransactions = lineToTransactions(rddLines)                      // 4. convert lines to transaction objects
    val yearlyTransactionsRDD = transactionsAmountsByYear(rddTransactions)  // 5. transform data
    printTransactionsAmountsByYear(yearlyTransactionsRDD)                   // 6. print results
    spark.stop()                                                            // 7. stop spark cluster
  }

  def readConfig(): SparkRDDConfig = {
    ConfigUtils.loadAppConfig[SparkRDDConfig](CONFIG_PATH)
    //ConfigUtils.loadAppConfig[SparkRDDConfig](CONFIG_PATH) 
    //configuration values or csv values in case class?
  }

  def loadData(spark: SparkSession)(implicit conf: SparkRDDConfig): RDD[String] = {
    spark.sparkContext.textFile(conf.transactionFile)
    // import spark.implicits._
    // spark
    //   .read
    //   .format("csv")
    //   .load() // or another similar? //2.2
  }

  def lineToTransactions(lines: RDD[String]): RDD[CustomerTransaction] = {
    lines.map( CustomerTransaction.apply(_)
      .getOrElse(CustomerTransaction(customerId = "0",
          transactionDate = "00",
          transactionAmount = 0)))
     // .collect{case x if x != None => x} //use week 9 .get //none .get error needs fixed :)
    //https://stackoverflow.com/questions/6389063/convert-scala-list-to-list-with-another-type
    //https://stackoverflow.com/questions/26766026/is-there-a-way-to-skip-throw-out-ignore-records-in-spark-during-a-map
  }

  def transactionsAmountsByYear(transactions: RDD[CustomerTransaction]): RDD[(String, Double)] = {
    val txtemp = transactions.map( x => ((x.transactionDate.takeRight(2)),x.transactionAmount)) //can also call transactionYear
    txtemp.reduceByKey(_ + _)
    //     val txtemp = transactions.map( x => x.transactionDate.takeRight(2))
    // txtemp.reduceByKey(_ + _)
    //val withoutIDtx = txtemp.filter{ case (a,b,c) => b <= a}
    //https://stackoverflow.com/questions/10995129/scala-get-last-two-characters-from-string
    //https://sparkbyexamples.com/apache-spark-rdd/spark-reducebykey-usage-with-examples/
  }

  def printTransactionsAmountsByYear(transactions: RDD[(String, Double)]): Unit = {
    transactions.foreach(println)
  }
}