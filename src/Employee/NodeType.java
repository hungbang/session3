package Employee;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NodeType {
	public static void printNodes(Document d){
		printElement((Node) d, " ");
	}

	private static void printElement(Node d, String string) {
		int nodeType = d.getNodeType();
		switch (nodeType) {
		case Node.CDATA_SECTION_NODE:
			System.out.println(string + "CDATA_SECTION_NODE");
			break;
		case Node.COMMENT_NODE:
			System.out.println(string + "COMMENT_NODE");
			break;
		case Node.DOCUMENT_FRAGMENT_NODE:
			System.out.println(string + "DOCUMENT_FRAGMENT_NODE");
			break;
		case Node.DOCUMENT_NODE:
			System.out.println(string + "DOCUMENT_NODE");
			break;
		case Node.DOCUMENT_TYPE_NODE:
			System.out.println(string + "DOCUMENT_TYPE_NODE");
			break;
		case Node.ELEMENT_NODE:
			System.out.println(string + "ELEMENT_NODE");
			break;
		case Node.ENTITY_REFERENCE_NODE:
			System.out.println(string + "ENTITY_REFERENCE_NODE");
			break;
		case Node.NOTATION_NODE:
			System.out.println(string + "NOTATION_NODE");
			break;
		case Node.PROCESSING_INSTRUCTION_NODE:
			System.out.println(string + "PROCESSING_INSTRUCTION_NODE");
			break;
		case Node.TEXT_NODE:
			System.out.println(string + "TEXT_NODE");
			break;
		default:
			System.out.println(string + "Unknown node");
			break;
		}
		NodeList nodeLst = d.getChildNodes();
		for(int i = 0; i < nodeLst.getLength(); i++){
			printElement(nodeLst.item(i), string + " ");
		}
	}
	
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new FileInputStream("/Users/KAI/servjsp/Session3/src/domparse/Employee.xml"));
			printNodes(document);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
