/**
 * Created by Mayanka on 23-Jul-15.
 */
object MainClass {

  def main(args: Array[String]) {
    val sentimentAnalyzer: SentimentAnalyzer = new SentimentAnalyzer
    val tweetWithSentiment: TweetWithSentiment = sentimentAnalyzer.findSentiment("The dog saw john in the park")
    System.out.println("Sentiment Analysis Output:")
    System.out.println(tweetWithSentiment)
  }
}
