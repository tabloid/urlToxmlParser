package seva.project.XMLEntities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by v.herasymenko on 30/01/2017.
 */
@XmlRootElement(name = "configuration")
public class Configuration {
    private String url;
    private List<Selector> selectorList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(name = "selector")
    public List<Selector> getSelectorList() {
        return selectorList;
    }

    public void setSelectorList(List<Selector> selectorList) {
        this.selectorList = selectorList;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "url='" + url + '\'' +
                ", selectorList=" + selectorList +
                '}';
    }
}
