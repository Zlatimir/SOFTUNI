package softuni.exam.instagraphlite.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <O> O fromFile(Class<O> objectClass, String filePath) throws JAXBException;

    <O> void exportToXml(O object, Class<O> objectClass, String path) throws JAXBException;
}
