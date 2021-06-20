package domain;

import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.mockito.Matchers.anyString;

public class WordCounterImplTests {

    @Test
    public void getWordsTest() throws Exception{
        WebPageClient webPageClientMock = Mockito.mock(WebPageClient.class);
        Logger logger = Mockito.mock(Logger.class);
        Mockito.when(webPageClientMock.getText(anyString())).thenReturn("В качестве результата работы пользователь " +
                "должен получить статистику по количеству уникальных слов в тексте.");
        WordCounter wordCounter = new WordCounterImpl(webPageClientMock, logger);

        HashMap<String, Integer> statistics = wordCounter.getWords("https://www.simbirsoft.com/");

        Assert.assertTrue(statistics.containsKey("в"));
        Assert.assertEquals(Integer.valueOf(2), statistics.get("в"));
    }
}