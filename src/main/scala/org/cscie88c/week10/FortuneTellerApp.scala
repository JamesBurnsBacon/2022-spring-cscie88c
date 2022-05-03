package org.cscie88c.week10

import org.apache.spark.sql.SparkSession
//import com.typesafe.scalalogging.{LazyLogging}
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
    implicit val conf:FTSparkConfig = readConfig()                          // 1. read configuration
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)          // 2. initialize spark session
    val DF = loadData(spark)                                                // 3. load data
    val normDF = normalize(DF)                                              // 4. normalize data
    val comparsionString = computeComparisonString(normDF)                  // 5. calculate valuation
    printResults(comparsionString)                                          // 6. print results
    spark.stop()                                                            // 7. stop spark cluster
  }
    def printResults(s: String): Unit = {println(s)}

  def readConfig(): FTSparkConfig = {
    ConfigUtils.loadAppConfig[FTSparkConfig](CONFIG_PATH)
  }

  def loadData(spark: SparkSession)(implicit conf: FTSparkConfig): DataFrame = {
    //import spark.implicits._
    spark
      .read
      .format("csv")
      .option("header", "true")
      .schema(csvImportSchema)
      .load() // test in REPL
  }

  def computeComparisonString(df: DataFrame): String = {
    val priceValue = 1.227895
    val HashValue = 1.186966
    val AAValue = 0.993721

    val priceVHash = if (priceValue < HashValue) {"undervalued"} else {"overvalued"}
    val priceVAA = if (priceValue < AAValue) {"undervalued"} else {"overvalued"}
    val percentValuedH = percentDiff(priceValue, HashValue) //round or as percent?
    val percentValuedA = percentDiff(priceValue, AAValue)

    val stringReturn = "Bitcoin at $37,716 on April 30th, 2022 was " + priceVHash + " by %"+ percentValuedH + " versus HashRate Fundamental and " + priceVAA + " by %" + percentValuedA + " versus Active Accounts Fundamental."
    stringReturn
  }

  def percentDiff(a: Double, b: Double): Double = {
      (a-b)/((a+b)/2) * 100
  }

  def normalize(df: DataFrame): DataFrame = {
    val priceMean: Double = 8.7593
    val priceSD = 1.4466
    val HashMean = 44.8053
    val HashSD =  1.7137
    val AAMean = 13.5137
    val AASD =  0.2663
    // val priceMean: DoubleType = df.groupBy("USD").mean("USD").collect//needs to return single value, not column or df
    // val priceSD = df.select(stddev_pop(df("USD"))).get(0)
    // val HashMean = df.select(mean(df("hashrate")))
    // val HashSD =  df.select(stddev_pop(df("hashrate")))
    // val AAMean = df.select(mean(df("activeAccounts")))
    // val AASD =  df.select(stddev_pop(df("activeAccounts")))
    //print("Calculated Means and SDs")
    // val df2 = df.withColumn("USD", (df("USD") - 1) / 1) //error is thrown here
    // val df3 = df2.withColumn("hashrate", (df("hashrate") - 1) / 1)
    // val df4 = df3.withColumn("activeAccounts", (df("activeAccounts") - 1) / 1)
    val df2 = df.withColumn("USD", (df("USD") - priceMean) / priceSD)
    val df3 = df2.withColumn("hashrate", (df("hashrate") - HashMean) / HashSD)
    val df4 = df3.withColumn("activeAccounts", (df("activeAccounts") - AAMean) / AASD)
    df4
    // val priceMean = df.select(mean("USD")) //needs to return single value, not column
    // val priceSD = df.select(stddev_pop("USD"))
    // val HashMean = df.select(mean("hashrate"))
    // val HashSD = df.select(stddev_pop("hashrate"))
    // val AAMean = df.select(mean("activeAccounts"))
    // val AASD = df.select(stddev_pop("activeAccounts"))
    // val df2 = df.withColumn("USD", (df("USD") - priceMean) / priceSD)
    // val df3 = df2.withColumn("hashrate", (df("hashrate") - HashMean) / HashSD)
    // val df4 = df3.withColumn("activeAccounts", (df("activeAccounts") - AAMean) / AASD)
    // df4
    // Built for data from glassnode
    
    // Takes natural log of raw data
    // Subtracts mean of logged data from result
    // Divides by standard deviation of mean subtracted data
    // Returns normalized data column
    // Method from Bhambhwani et al.
  }
}
  // geeksforgeeks.org/scala-float-round-method-with-example/
  // https://stackoverflow.com/questions/34234817/feature-normalization-algorithm-in-spark
  // https://stackoverflow.com/questions/44987336/calculate-average-using-spark-scala
  // https://stackoverflow.com/questions/45674186/calculate-mean-for-several-columns-in-spark-scala
  // https://stackoverflow.com/questions/62633946/java-lang-runtimeexception-unsupported-literal-type-class-org-apache-spark-sql
  // https://sparkbyexamples.com/pyspark/pyspark-update-a-column-with-value/
  // https://stackoverflow.com/questions/47995188/how-to-calculate-mean-and-standard-deviation-given-a-pyspark-dataframe
  // https://stackoverflow.com/questions/31789939/calculate-the-standard-deviation-of-grouped-data-in-a-spark-dataframe
  // https://www.edureka.co/blog/dataframes-in-spark/
  // https://linuxhint.com/mean-pyspark/
  // https://stackoverflow.com/questions/39926411/provide-schema-while-reading-csv-file-as-a-dataframe
  // https://stackoverflow.com/questions/56849138/java-lang-runtimeexception-unsupported-literal-type-class-org-joda-time-datetim
  // https://www.calculatorsoup.com/calculators/algebra/percent-difference-calculator.php
  
