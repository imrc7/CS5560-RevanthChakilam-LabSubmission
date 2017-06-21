import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object qanda {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "D:\\winutils")

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val spark = new SparkContext(sparkConf)
    val call: NLP = new NLP();
    val i = 0

    val base = spark.textFile("C:\\Users\\revan\\Desktop\\Lab1\\KDM\\064.txt");
    for (a <- 0 to 2) {
      val input = scala.io.StdIn.readLine()
      if (input.contains("who")) {
        val r1 = base.map(line => {
          call.ret(line, "PERSON")
        })
        qa(r1,input)
      }
      if (input.contains("where")) {
        val r1 = base.map(line => {
          call.ret(line, "LOCATION")
        })
        qa(r1,input)
      }
      if (input.contains("what")) {
        val r1 = base.map(line => {
          call.ret(line, "ORGANIZATION")
        })
        qa(r1,input)
      }
    }

  }
  def qa(value: RDD[String], str: String)
  {

    val r2=value.flatMap(s=>{s.split(" ")}).map(w=>(w)).filter(f=>{f.length>2})
    val r3=r2.distinct()
    val out=str

    r3.take(10).foreach(println)
  }
}
