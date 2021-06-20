package domain;

import java.io.IOException;
import java.util.HashMap;

public interface WordCounter {
    HashMap<String, Integer> getWords(String message) throws IOException;
}
