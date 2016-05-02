/**
  * Created by rajiv jandial on 4/29/16.
  */

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount{
  def main(args: Array[String]) {

    val filePath = ""
    val sparkConfig = new SparkConf().setAppName("Word Count").setMaster("local")
    val sparkContext = new SparkContext(sparkConfig)
    val input_file = sparkContext.textFile(filePath)














  }
}
