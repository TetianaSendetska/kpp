package org.example;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
    public static List<String> readTextFromFile(String filePath)
    {
        List<String> sentences = new ArrayList<>();
        StringBuilder currentSentence = new StringBuilder();

        try {
            File file = new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                currentSentence.append(line);

                if (line.endsWith(".")|| line.endsWith("?") || line.endsWith("!")) {
                    sentences.add(currentSentence.toString());
                    currentSentence.setLength(0);  // Очищаємо рядок для наступного речення
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sentences;
    }
}
