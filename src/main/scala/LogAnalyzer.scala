import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object LogAnalyzer {

  def main(args: Array[String]) {
    
    val sparkContext = new SparkContext( new SparkConf().setAppName("Log Analyzer").setMaster("local"))
    //val conf = new SparkConf().setAppName("Log Analyzer")
    val logFile = "/home/edureka/server_log"
    // base RDD
    val lines  = sparkContext.textFile(logFile)
    //transformed RDD
    val errors = lines.filter(_.startsWith("ERROR"))
    val messages = errors.map(_.split("\t")).map(r=>r(1))

    messages.cache
    println("RDD Trace ::" + messages.toDebugString)

    val lines_count =lines.count
    // action 1
    val oracle = messages.filter(_.contains("oracle")).count()
    //action 2
    val msql = messages.filter(_.contains("mysql")).count
    //action 3
    val php = messages.filter(_.contains("php")).count
    //action 4
    val rail = messages.filter(_.contains("RailsApp")).count

		/*
			Now this logic right now is printing the statistics on console,
			you could save the results in a file, or DB or even pass message
			to other system here
		*/

    println("Total msgs: %s, Oracle: %s ,MySQL errs: %s, PHP errs: %s, Rails: %s".
      format(lines_count, oracle, msql, php, rail))

    
    
    
  }
}