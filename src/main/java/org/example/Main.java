package org.example;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        String filePath = "D:\\mine\\code\\JavaProjects\\Lab5\\src\\main\\resources\\text.txt";

        text = TextFileReader.readTextFromFile(filePath);

        ListPrinter.printList(text);

    }
}