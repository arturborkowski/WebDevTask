package pl.parser.nbp.fileService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface IXMLReader {

	 /**
	  * 
	  * @param s string value representing tag's name
	  * @param e element of XML document to read a particular value from
	  * @return value of element represented by tag name
	  */
	public String getTagValue(String s, Element e);
	
	/**
	 * 
	 * @param fileName name of the file to use as a Document object
	 * @return Document object representing file of filename
	 * @throws Exception
	 */
	public Document getXMLFile(String fileName) throws Exception;
	
}
