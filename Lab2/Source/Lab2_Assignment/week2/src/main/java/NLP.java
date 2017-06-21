import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import jdk.nashorn.internal.ir.WhileNode;

import javax.xml.bind.Element;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.*;


public class NLP implements Serializable {

Multimap<String, String> map2 = HashMultimap.create();
    public String lemm(String data) {

        Properties prop = new Properties();

        StringBuilder res = new StringBuilder();
        prop.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(prop);
        Annotation doc = new Annotation(data);

        pipeline.annotate(doc);

        List<CoreMap> lemms = doc.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : lemms) {
            for (CoreLabel c : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String output = c.get(CoreAnnotations.LemmaAnnotation.class);
                res.append(output + " ");
            }
        }
        return res.toString();
    }
    public void entities(String pack)
    {
        Properties tees=new Properties();
        tees.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(tees);
        Annotation ann = new Annotation(pack);
        pipeline.annotate(ann);
        List<CoreMap> cm=ann.get(CoreAnnotations.SentencesAnnotation.class);
        for(CoreMap line:cm){
            for(CoreLabel t:line.get(CoreAnnotations.TokensAnnotation.class))
            {
                String ren=t.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                String spec=t.get(CoreAnnotations.TextAnnotation.class);
                    map2.put(ren, spec);

                }
            }
        }
public String ret(String ques,String solution)
{
    entities(ques);
    Collection<String> c=map2.get(solution);

    StringBuilder sbuild=new StringBuilder();
    for(String ele:c)
    {
        sbuild.append(ele+" ");
    }

    return sbuild.toString();
}

    }


