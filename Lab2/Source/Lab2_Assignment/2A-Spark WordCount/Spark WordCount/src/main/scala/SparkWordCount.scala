

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Mayanka on 09-Sep-15.
 */
object SparkWordCount {

  def main(args: Array[String]) {

    val inputFile = args(0)
    val outputFile = args(1)

    System.setProperty("hadoop.home.dir","D:\\winutils");

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc=new SparkContext(sparkConf)

    val input=sc.textFile("C:\\Users\\revan\\Desktop\\CS5560- Tutorial2A-Spark WordCount\\Spark WordCount\\input")

    val wc=input.flatMap(line=>{line.split(" ")}).map(word=>(word,1)).cache()

    val output=wc.reduceByKey(_+_)

    //output.saveAsTextFile("output")

    val o=output.collect();
    output.collect().foreach(println)

    var s:String="Words:Count \n"
    o.foreach{case(word,count)=>{

      s+=word+" : "+count+"\n"

    }}

  }

}
