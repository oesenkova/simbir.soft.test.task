package domain;

import java.io.IOException;

public interface WebPageClient {
    String getText(String message) throws IOException;
}
