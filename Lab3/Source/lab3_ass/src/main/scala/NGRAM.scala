
/**
  * Created by Mayanka on 19-06-2017.
  */
object NGRAM {

  def main(args: Array[String]): Unit = {
    val a = getNGrams("The dog saw John in the park. \nThe little bear saw the fine fat trout " +
      "in the rocky brook. \nThe dog started chasing John. \nThe little bear caught a fish in " +
      "the rocky brook.",2)
    a.foreach(f=>println(f.mkString(" ")))

  }

  def getNGrams(sentence: String, n:Int): Array[Array[String]] = {
    val words = sentence
    val ngrams = words.split(' ').sliding(n)
    ngrams.toArray
  }

}


