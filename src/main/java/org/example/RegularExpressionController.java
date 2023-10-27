package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class RegularExpressionController {
    public List<String> findQuestions(List<String> sentences){
        List<String> questions = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\?");
        for (String sentence: sentences) {
            Matcher matcher = pattern.matcher(sentence);
            if(matcher.find() && matcher.start() == sentence.length()-1){
                questions.add(new String(sentence));
            }
        }
        return questions;
    }
}
