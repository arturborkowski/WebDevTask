package pl.parser.nbp.fileService;



import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class XMLFileReader extends XMLReader {

	
	private String fileName = "";
	private String url = "http://www.nbp.pl/kursy/xml/";
	private String date = "";
	
	
			
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * 
	 * @param currencyCode code representing currency e.g. USD, EUR, GBP etc.
	 * @param date date (YYYY-MM-DD) to get currencies information of
	 * @return string representing buying rate of given currency on particular date
	 * @throws Exception
	 */
	public String getCurrencyBuingRate(String currencyCode, String date) throws Exception {
			return getDataFromCurrency(currencyCode, date, "kurs_kupna");
		}
	
	
	/**
	 * 
	 * @param currencyCode code representing currency e.g. USD, EUR, GBP etc.
	 * @param date date (YYYY-MM-DD) to get currencies information of
	 * @return string representing selling rate of given currency on particular date
	 * @throws Exception
	 */
	public String getCurrencySellingRate(String currencyCode, String date) throws Exception {
		return getDataFromCurrency(currencyCode, date, "kurs_sprzedazy");		
	}
	
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see pl.parser.nbp.dataFiles.IXMLReader#getTagValue(java.lang.String, org.w3c.dom.Element)
	 */
	public String getTagValue(String s, Element e) {
		NodeList nl = e.getElementsByTagName(s).item(0).getChildNodes();
		Node n = (Node) nl.item(0);
		return n.getNodeValue();
	}


	@Override
	/*
	 * (non-Javadoc)
	 * @see pl.parser.nbp.dataFiles.IXMLReader#getXMLFile(java.lang.String)
	 */
	public Document getXMLFile(String fileName) throws Exception {
		String urlToExec = url+fileName+".xml";
		URL u = new URL(urlToExec);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(u.openStream());
		return doc;
	}
	
	
	
	
}
