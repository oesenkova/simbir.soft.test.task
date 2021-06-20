package http;

import domain.WebPageClient;
import org.jsoup.Jsoup;

import java.io.IOException;

public class WebPageClientImpl implements WebPageClient {
    @Override
    public String getText(String message) throws IOException {
        return Jsoup.connect(message).get().text();
    }
}
