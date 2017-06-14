/**
 * Created by revan on 6/13/2017.
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


public class questionEngine {

    public static void main(String[] args) throws IOException {
        PrintWriter out;
        out = new PrintWriter("C:\\Users\\revan\\Desktop\\KDM\\step2.txt");

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos,lemma,ner,parse,dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation;
        String readString = null;
        PrintWriter pwrite = null;
        BufferedReader bread = null;
        bread = new BufferedReader(new FileReader("C:\\Users\\revan\\Desktop\\KDM\\001.txt"));
        pwrite = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\revan\\Desktop\\KDM\\step1.txt", false)));
        String s = null;

        int i=0;

        System.out.println("What all organizations were involved ? \n");

        while ((readString = bread.readLine()) != null && i<5) {
            pwrite.println(readString);
            String ss = readString;
            s = ss;
            annotation = new Annotation(s);

            pipeline.annotate(annotation);
            pipeline.prettyPrint(annotation, out);

            List<CoreMap> lines = annotation.get(CoreAnnotations.SentencesAnnotation.class);

            for (CoreMap line : lines) {
                for (CoreLabel token : line.get(CoreAnnotations.TokensAnnotation.class)) {
                    String NER = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                   /* System.out.println(token);*/
                    String w = token.get(CoreAnnotations.TextAnnotation.class);

                    /*if (NER.contains("PERSON")) {
                        System.out.println("Identity: " + w);
                    }*/
                    /*if (NER.contains("LOCATION")) {
                        System.out.println("Country:" + w);
                    }*/
                     if (NER.contains("ORGANIZATION")) {
                        System.out.println("Organization:" + w);
                    }
                }


            }
        }
        bread.close();
        pwrite.close();
        System.out.println("Hurray Success");

//            try {
//                BufferedReader b = new BufferedReader(new FileReader(""));
//                String line = null;
//                int i = 0;
//                while ((line = b.readLine()) != null && i < 10) {
//                    System.out.println(line);
//                    i++;
//                }
//                b.close();
//            } catch (Exception e) {
//            }





    }}


