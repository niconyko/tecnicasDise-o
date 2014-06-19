
package ar.com.grupo1.tecnicas.Logging;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 

public class ParserFileXml extends ParserFile {
	
	public ParserFileXml (String fileProperties, String logName){
		filename = fileProperties;
		sourceName = logName;
	}

	public ArrayList<String> parser() {
		
		File fXmlFile = new File(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();		
			
			NodeList nList = doc.getElementsByTagName("settings");		
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				Node nNode = nList.item(temp); 
					 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;	
					String tag = eElement.getElementsByTagName("tag").item(0).getTextContent();
					if( tag.equals(sourceName) ){
						processFormat(eElement.getElementsByTagName("format").item(0).getTextContent() );
						this.delimeter = process(eElement.getElementsByTagName("delimeter").item(0).getTextContent());
						this.level = process(eElement.getElementsByTagName("level").item(0).getTextContent());		
					}
				}
			}		
					
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		return listConf;
	}
	

	
}
