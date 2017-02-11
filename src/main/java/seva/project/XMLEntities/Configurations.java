package seva.project.XMLEntities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by v.herasymenko on 30/01/2017.
 */
@XmlRootElement(name = "configurations")
public class Configurations {
    private List<Configuration> configurationList;

    @XmlElement(name = "configuration")
    public List<Configuration> getConfigurationList() {
        return configurationList;
    }

    public void setConfigurationList(List<Configuration> configurationList) {
        this.configurationList = configurationList;
    }
}
