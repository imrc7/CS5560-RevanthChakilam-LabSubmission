/**
 * Created by revan on 6/10/2017.
 */
import java.io.*;
import java.util.*;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import edu.stanford.nlp.hcoref.CorefCoreAnnotations;
import edu.stanford.nlp.hcoref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;


public class TestCoreNLP {

    public static void main(String[] args) throws IOException {
        PrintWriter out;
        out = new PrintWriter("C:\\Users\\revan\\Desktop\\KDM\\output1.txt");

        Properties props=new Properties();
        props.setProperty("annotators","tokenize, ssplit, pos,lemma, ner,parse,dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation;
        String readString = null;
        PrintWriter pwriter = null;
        BufferedReader breader = null;
        breader = new BufferedReader ( new FileReader ( "C:\\Users\\revan\\Desktop\\KDM\\064.txt" )  ) ;
        pwriter = new PrintWriter ( new BufferedWriter ( new FileWriter ( "C:\\Users\\revan\\Desktop\\KDM\\output.txt", false )  )  ) ;
        String s = null;
        while  (( readString = breader.readLine ())  != null)   {
            pwriter.println ( readString ) ;
            String ss=readString;
            s=ss;
            annotation = new Annotation(s);

            pipeline.annotate(annotation);
            pipeline.prettyPrint(annotation, out);
        }
        breader.close (  ) ;
        pwriter.close (  ) ;
        System.out.println("Test Success");


    }

}
