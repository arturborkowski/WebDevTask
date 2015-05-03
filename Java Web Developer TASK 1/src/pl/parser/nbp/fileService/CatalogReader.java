package pl.parser.nbp.fileService;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class CatalogReader {

	
	private String[] filesOfTheDay = new String[4];
	
	/**
	 * URL leading to a catalog of files. 
	 */
	private String url = "http://www.nbp.pl/kursy/xml/dir.txt";
	
	
	
	
	/**
	 * 
	 * @param date date in format YYYY-MM-DD
	 * @param type type of file in National Bank of Poland methodology.
	 * 			'a' - table of average rates of foreign currencies
	 * 			'b' - table of average rates of inconvertible currencies
	 * 			'c' - table of buying and selling rates
	 * 			'h' - table of account units rates
	 * @return file name in format 'xnnnzrrmmdd' where:
	 * 			'x' - type of file
	 * 			'nnn' - number of table in a year
	 * 			'z' - constant element
	 * 			'rrmmdd' - date in format YYMMDD
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String getFileByType(String date, char type) throws MalformedURLException, IOException {
		
		String[] fileNames = getFilesByDate(date);
		
		for(String s: fileNames) {
			if(s!=null && s.contains(String.valueOf(type).toLowerCase())) {
				return s;
			}
		}
		return null;
	}
	
	

	/**
	 * 
	 * 
	 * @param date date in format YYYY-MM-DD
	 * @return table of file names released at particular date
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private String[] getFilesByDate(String date) throws MalformedURLException, IOException {
			 
			URL u = new URL(url);
			Scanner s = new Scanner(u.openStream());
			String line = "";
			String formattedDate = Parsers.dateFormat(date);
			
			int i = 0;
			while(s.hasNextLine()) {
				line = s.nextLine();
				if(line.contains(formattedDate)) {
					filesOfTheDay[i] = line;
					i++;
				}
			}
			
			s.close();
		
		return filesOfTheDay;
	}
	

}
