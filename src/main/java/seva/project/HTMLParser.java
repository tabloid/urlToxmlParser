package seva.project;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by v.herasymenko on 30/01/2017.
 */

public class HTMLParser {
    private String tag;
    private String text;

    private String url;
    private String selector;
    private String parseFrom;
    private String parseTo;

    public HTMLParser(String url, String selector, String parseFrom, String parseTo) {
        this.url = url;
        this.selector = selector;
        this.parseFrom = parseFrom;
        this.parseTo = parseTo;
    }


    public void parse() {
        try {
            Connection connection = Jsoup.connect(url).timeout(50000).validateTLSCertificates(false);
            Document doc = connection.get();
            Elements elementSelector = doc.select(selector);
            tag = elementSelector.toString();
            text = elementSelector.text();
            if (parseFrom != null && parseTo != null) {
                String param = parseFrom;
                int start = tag.indexOf(param) + param.length();
                int end = tag.indexOf(parseTo, start);
                if (start > -1 && end > -1)
                    text = tag.substring(start, end);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
    }

    public String getTag() {
        return tag;
    }

    public String getText() {
        return text;
    }
}
