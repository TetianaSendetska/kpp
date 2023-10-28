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
    public List<String> findWordsOfCertainLength(List<String> sentences, int length ){
        if(sentences.isEmpty()){
            throw new IllegalArgumentException("There are no text");
        }
        List<String> text = findQuestions(sentences);
        List<String> words = new ArrayList<>();
        String regex = "\\b\\w{" + length + "}\\b";
        Pattern pattern = Pattern.compile(regex);
        for (String sentence: text) {
            Matcher matcher = pattern.matcher(sentence);
            while(matcher.find()){
                words.add(matcher.group());
            }
        }
        return words;
    }
}
