package seva.project.XMLEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by v.herasymenko on 04/02/2017.
 */
@XmlRootElement(name = "selector")
public class Selector {
    private String parseFrom;
    private String parseTo;
    private String value;


    @XmlAttribute
    public String getParseFrom() {
        return parseFrom;
    }

    public void setParseFrom(String parseFrom) {
        this.parseFrom = parseFrom;
    }

    @XmlAttribute
    public String getParseTo() {
        return parseTo;
    }

    public void setParseTo(String parseTo) {
        this.parseTo = parseTo;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Selector{" +
                "parseFrom='" + parseFrom + '\'' +
                ", parseTo='" + parseTo + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
