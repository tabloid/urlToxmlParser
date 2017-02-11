package seva.project;

import seva.project.XMLEntities.Configuration;
import seva.project.XMLEntities.Configurations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by v.herasymenko on 30/01/2017.
 */
public class ConfigurationReader {
    private Unmarshaller unmarshaller;
    private String filePath;

    public ConfigurationReader(String filePath) throws JAXBException {
        this.unmarshaller = getUnmarshaller();
        this.filePath = filePath;
    }

    private Unmarshaller getUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Configurations.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller;
    }
    public List<Configuration> getConfigurationList() throws JAXBException {
        File file = new File(filePath);
        Configurations configurations = (Configurations) unmarshaller.unmarshal(file);
        return configurations.getConfigurationList();
    }

}
