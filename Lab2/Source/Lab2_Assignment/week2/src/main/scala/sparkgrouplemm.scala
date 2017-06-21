import org.apache.spark.{SparkConf, SparkContext}


object sparkgrouplemm {
 def main(args:Array[String]): Unit ={

   System.setProperty("hadoop.home.dir","D:\\winutils")

   val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

   val sc=new SparkContext(sparkConf)
   val call:NLP=new NLP();
   val text=sc.textFile("C:\\Users\\revan\\Desktop\\Lab1\\KDM\\cr7.txt");
   val ack1=text.map(l=>{call.lemm(l)})

   val ack2=ack1.flatMap(d=>{d.split(" ")}).filter(f=>(!(f.contains(",")|f.contains(".")|(f.isEmpty)))).map(w=>(w))
   val ack3=ack2.groupBy(g=>{g.charAt(0)})
   ack3.collect().foreach(println)
 }
}
