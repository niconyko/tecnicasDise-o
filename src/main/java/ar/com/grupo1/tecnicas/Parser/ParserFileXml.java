
package ar.com.grupo1.tecnicas.Parser;
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

import ar.com.grupo1.tecnicas.Configuration.Level;
import ar.com.grupo1.tecnicas.Configuration.Level.enumLevel;
 

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
			System.err.println("Parser Counfiguration Error");
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
						this.level = enumLevel.valueOf( process(eElement.getElementsByTagName("level").item(0).getTextContent()));		
					}
				}
			}		
					
		} catch (SAXException e) {
			System.err.println("SAX Error");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Input-Output Error");
			e.printStackTrace();
		}	
	
		return listConf;
	}
	

	
}
