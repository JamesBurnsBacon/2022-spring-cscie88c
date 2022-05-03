package org.cscie88c.week10

import org.apache.spark.sql.SparkSession
import com.typesafe.scalalogging.{LazyLogging}
import org.cscie88c.config.{ConfigUtils}
import org.cscie88c.utils.{SparkUtils}
import org.apache.spark.sql._
import pureconfig.generic.auto._
//import org.apache.spark.rdd.PairRDDFunctions
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

case class FTSparkConfig(name: String, masterUrl: String, transactionFile: String)

// data is logged before importing bc too big for Long type
// run with: sbt "runMain org.cscie88c.week10.FortuneTellerApp"
object FortuneTellerApp {
  val CONFIG_PATH="org.cscie88c.fortune-teller"

  val csvImportSchema = StructType(Array(
    StructField("timestamp", StringType, true),
    StructField("USD", DoubleType, true),
    StructField("hashrate", DoubleType, true),
    StructField("activeAccounts", DoubleType, true))
    )
 
  // application entry point
  def main(args: Array[String]): Unit = {
    implicit val conf:FTSparkConfig = readConfig()                         // 1. read configuration
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)          // 2. initialize spark session
    val DF = loadData(spark)                                                  // 3.load data
    //val normDF = normalize(DF)                                               //4. normalize data
    //val rddTransactions = lineToTransactions(rddLines)                      // 4. convert lines to transaction objects
    // val yearlyTransactionsRDD = transactionsAmountsByYear(rddTransactions)  // 5. transform data
    // printTransactionsAmountsByYear(yearlyTransactionsRDD)                   // 6. print results
    spark.stop()                                                            // 7. stop spark cluster
  }

  def readConfig(): FTSparkConfig = {
    ConfigUtils.loadAppConfig[FTSparkConfig](CONFIG_PATH)
    //ConfigUtils.loadAppConfig[FTSparkConfig](CONFIG_PATH) 
    //configuration values or csv values in case class?
  }

  def loadData(spark: SparkSession)(implicit conf: FTSparkConfig): DataFrame = {
    //spark.sparkContext.textFile(conf.transactionFile)
    import spark.implicits._
    spark
      .read
      .format("csv")
      .option("header", "true")
      .schema(csvImportSchema)
      .load() // works?
  }

  // def lineToTransactions(lines: RDD[String]): RDD[FortuneTeller] = {
  //   lines.map( FortuneTeller.apply(_)
  //     .getOrElse(FortuneTeller(
  //         timestamp = "0",
  //         usd = 0,
  //         hashrate = 0,
  //         activeAccounts = 0
  //         )))
  //    // .collect{case x if x != None => x} //use week 9 .get //none .get error needs fixed :)
  //   //https://stackoverflow.com/questions/6389063/convert-scala-list-to-list-with-another-type
  //   //https://stackoverflow.com/questions/26766026/is-there-a-way-to-skip-throw-out-ignore-records-in-spark-during-a-map
  // }

  def normalize(df: DataFrame) = {
    val priceMean = df.select(mean("USD"))
    val priceSD = df.select(stddev_pop("USD"))
    val HashMean = df.select(mean("hashrate"))
    val HashSD = df.select(stddev_pop("hashrate"))
    val AAMean = df.select(mean("activeAccounts"))
    val AASD = df.select(stddev_pop("activeAccounts"))
    val df2 = df.withColumn("USD", (df("USD") - priceMean) / priceSD)
    val df3 = df2.withColumn("hashrate", (df("hashrate") - HashMean) / HashSD)
    val df4 = df3.withColumn("activeAccounts", (df("activeAccounts") - AAMean) / AASD)
    df4
    // Built for data from glassnode
    
    // Takes natural log of raw data
    // Subtracts mean of logged data from result
    // Divides by standard deviation of mean subtracted data
    // Returns normalized data column
    // Method from Bhambhwani et al.
  }

  // https://sparkbyexamples.com/pyspark/pyspark-update-a-column-with-value/
  // https://stackoverflow.com/questions/47995188/how-to-calculate-mean-and-standard-deviation-given-a-pyspark-dataframe
  // https://stackoverflow.com/questions/31789939/calculate-the-standard-deviation-of-grouped-data-in-a-spark-dataframe
  // https://www.edureka.co/blog/dataframes-in-spark/
  // https://linuxhint.com/mean-pyspark/
  // https://stackoverflow.com/questions/39926411/provide-schema-while-reading-csv-file-as-a-dataframe
  // https://stackoverflow.com/questions/56849138/java-lang-runtimeexception-unsupported-literal-type-class-org-joda-time-datetim

  // def transactionsAmountsByYear(transactions: RDD[CustomerTransaction]): RDD[(String, Double)] = {
  //   val txtemp = transactions.map( x => ((x.transactionDate.takeRight(2)),x.transactionAmount)) //can also call transactionYear
  //   txtemp.reduceByKey(_ + _)
  //   //     val txtemp = transactions.map( x => x.transactionDate.takeRight(2))
  //   // txtemp.reduceByKey(_ + _)
  //   //val withoutIDtx = txtemp.filter{ case (a,b,c) => b <= a}
  //   //https://stackoverflow.com/questions/10995129/scala-get-last-two-characters-from-string
  //   //https://sparkbyexamples.com/apache-spark-rdd/spark-reducebykey-usage-with-examples/
  // }

  // def printTransactionsAmountsByYear(transactions: RDD[(String, Double)]): Unit = {
  //   transactions.foreach(println)
  // }
}