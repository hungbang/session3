package domparse;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AppMain {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Load and parse document
			Document document = builder
					.parse(new FileInputStream("/Users/KAI/servjsp/Session3/src/domparse/Employee.xml"));
			Element element = document.getDocumentElement();

			NodeList list = element.getElementsByTagName("Employee");
			
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("==current element=="+ node.getNodeName());
				
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element2 = (Element)node;
					System.out.println("==attribute=="+ element2.getAttribute("id"));
					System.out.println("==First NAme=="+ element2.getElementsByTagName("FirstName").item(0).getTextContent());
					System.out.println("==Last Name=="+ element2.getElementsByTagName("LastName").item(0).getTextContent());
					System.out.println("==Location=="+ element2.getElementsByTagName("Location").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException | IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
