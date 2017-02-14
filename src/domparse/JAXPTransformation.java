package domparse;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class JAXPTransformation {
	public static JAXPTransformation newInstance(){
		return new JAXPTransformation();
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		JAXPTransformation transformation = JAXPTransformation.newInstance();
		transformation.transformDom();
		
	}

	private void transformDom() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new FileInputStream("/Users/KAI/servjsp/Session3/src/domparse/Employee.xml"));
		DOMSource source = new DOMSource(document);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		System.out.println("==transformerFactory.getClass()=="+ transformerFactory.getClass());
		Transformer transformer = transformerFactory.newTransformer(new StreamSource(new FileInputStream("/Users/KAI/servjsp/Session3/src/domparse/emp.xsl")));
		StreamResult result = new StreamResult(System.out);
		transformer.transform(source, result);
		
		
	}
}
