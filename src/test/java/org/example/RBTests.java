package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RBTests {
    private final RegularExpressionController controller = new RegularExpressionController();

    @Test
    void find3Questions() {
        List<String> sentences = Arrays.asList(
                "Is this a question?",
                "This is not a question.",
                "What's your name?",
                "Are you sure?"
        );
        List<String> result = controller.findQuestions(sentences);
        List<String> expected = Arrays.asList(
                "Is this a question?",
                "What's your name?",
                "Are you sure?"
        );
        assertEquals(expected, result);
    }
    @Test
    void findNoQuestions() {
        List<String> sentences = Arrays.asList(
                "Is this a question.",
                "This is not a question.",
                "What's your name.",
                "Are you sure."
        );
        List<String> result = controller.findQuestions(sentences);
        List<String> expected = new ArrayList<>();
        assertEquals(expected, result);
    }

    @Test
    void findWordsOfLength5() {
        List<String> sentences = Arrays.asList(
                "This is a test sentence with some words.",
                "What's the length of these words?",
                "This has some words of varying lengths."
        );
        int length = 5;
        List<String> result = controller.findWordsOfCertainLength(sentences, length);
        List<String> expected = Arrays.asList(
                "these",
                "words"
        );
        assertEquals(expected, result);
    }
    @Test
    void findNoWordsOfLength8() {
        List<String> sentences = Arrays.asList(
                "This is a test sentence with some words.",
                "What's the length of these words?",
                "This has some words of varying lengths."
        );
        int length = 8;
        List<String> result = controller.findWordsOfCertainLength(sentences, length);
        List<String> expected = new ArrayList<>();
        assertEquals(expected, result);
    }
}