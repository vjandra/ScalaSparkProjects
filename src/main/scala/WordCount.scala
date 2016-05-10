/**
  * Created by rajiv jandial on 4/29/16.
  */

import org.apache.spark.SparkContext._
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount{
  def main(args: Array[String]) {

    val filePath = "file:/home/edureka/hellospark_ip"
    val sparkConfig = new SparkConf().setAppName("Word Count").setMaster("local")
    val sparkContext = new SparkContext(sparkConfig)
    val input_file = sparkContext.textFile(filePath)

    //val wordCount = input_file.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey((a,b) => a + b)
    //val wordCount = input_file.flatMap(line => line.split(" ")).map(word => (word,1)).groupByKey()
    val wordCount = input_file.flatMap(line => line.split(" ")).map(word => (word, 1)).
      foldByKey(0)((a, b) => a + b)


    wordCount.foreach(println)










  }
}
