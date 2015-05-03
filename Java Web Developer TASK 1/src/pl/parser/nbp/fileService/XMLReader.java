package pl.parser.nbp.fileService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class XMLReader implements IXMLReader {

	private CatalogReader cat = new CatalogReader();
	private String fileName;
	
	
	/**
	 * 
	 * @param currencyCode code representing currency e.g. USD, EUR, GBP etc.
	 * @param date date (YYYY-MM-DD) to get currencies information of
	 * @param tagNameOfData a name of tag in XML document to get data from, e.g. "kurs_kupna"
	 * @return string value represented by given tag name in XML file
	 * @throws Exception
	 */
	protected String getDataFromCurrency(String currencyCode, String date, String tagNameOfData) throws Exception {
		
		fileName = cat.getFileByType(date, 'c');
		Document doc = getXMLFile(fileName);
		
		NodeList nodeList = doc.getElementsByTagName("pozycja");

		for(int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;
				
				if(getTagValue("kod_waluty", e).equals(currencyCode.toUpperCase())) 
					return getTagValue(tagNameOfData, e);
			}
		}
		return null;		
	}
	

}
