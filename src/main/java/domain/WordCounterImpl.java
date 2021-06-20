package domain;

import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.util.HashMap;

public class WordCounterImpl implements WordCounter {
    private WebPageClient client;
    private Logger logger;
    final String separatorsRegex = "[\\p{Punct}\\s\\u2014\\u00ab\\u00bb]+";

    public WordCounterImpl(WebPageClient client, Logger logger) {
        this.client = client;
        this.logger = logger;
    }

    @Override
    public HashMap<String, Integer> getWords(String url) throws IOException {
        logger.info("Start executing method getWords with URL: " + url);
        String text = client.getText(url).toLowerCase();

        String[] words = text.split(separatorsRegex);
        HashMap<String, Integer> countedWords = new HashMap<String, Integer>();
        for (String word : words) {
            if (countedWords.containsKey(word)) {
                countedWords.put(word, countedWords.get(word) + 1);
            } else {
                countedWords.put(word, 1);
            }
        }
        logger.info("End executing method getWords");
        return countedWords;
    }
}
