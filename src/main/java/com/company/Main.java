package com.company;

import domain.WebPageClient;
import http.WebPageClientImpl;
import domain.WordCounter;
import domain.WordCounterImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Logger logger = (Logger) LogManager.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WebPageClient webPageClient = new WebPageClientImpl();
        WordCounter wordCounter = new WordCounterImpl(webPageClient, logger);

        try {
            HashMap<String, Integer> words = wordCounter.getWords(scanner.nextLine());
            printStatistics(words);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private static void printStatistics(HashMap<String, Integer> words) {
        for (String word : words.keySet()) {
            System.out.println(word + " - " + words.get(word) + ";");
        }
    }
}

