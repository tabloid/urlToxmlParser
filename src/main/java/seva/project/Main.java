package seva.project;

import seva.project.XMLEntities.Configuration;
import seva.project.XMLEntities.Selector;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String configFilePath = "configurations.xml";
        String outputFilepath = "output.xls";
        XLSWriter xlsWriter = new XLSWriter(outputFilepath);
        List<Configuration> configurationList;
        try {
            ConfigurationReader configurationReader = new ConfigurationReader(configFilePath);
            configurationList = configurationReader.getConfigurationList();
        } catch (JAXBException ex) {
            System.out.println(ex);
            return;
        }
        for (Configuration configuration : configurationList) {
            System.out.println(configuration);
            String url = configuration.getUrl();

            xlsWriter.appendRow();
            xlsWriter.appendCell(url);

            List<Selector> selectorList = configuration.getSelectorList();
            for (Selector selector : selectorList) {
                System.out.println(selector);
                String parseFrom = selector.getParseFrom();
                String parseTo = selector.getParseTo();
                String selectorValue = selector.getValue();
                HTMLParser htmlParser = new HTMLParser(url, selectorValue, parseFrom, parseTo);
                try {
                    htmlParser.parse();
                } catch (org.jsoup.select.Selector.SelectorParseException ex) {
                    System.out.println(ex);
                    continue;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex);
                    continue;
                }
                String tag = htmlParser.getTag();
                String text = htmlParser.getText();
                System.out.println("selectorTag: " + tag);
                System.out.println("selectorText: " + text);

                xlsWriter.appendCell(tag);
                xlsWriter.appendCell(text);
            }
            xlsWriter.appendDateCell();
            xlsWriter.write();
        }
    }
}
