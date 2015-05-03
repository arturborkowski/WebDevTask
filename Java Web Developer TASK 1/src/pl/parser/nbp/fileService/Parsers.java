package pl.parser.nbp.fileService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Parsers {

	
		/**
		 * 
		 * @param date date in format YYYY-MM-DD
		 * @return string representing date in format YYMMDD
		 */
		public static String dateFormat(String date) {
		
			String y,m,d;
			String[] dateFactors = date.split("-");
			y=dateFactors[0];
			m=dateFactors[1];
			d=dateFactors[2];
			
			y = y.substring(2);
			return y+m+d;
		}

		
		/**
		 * 
		 * @param c Calendar object to translate into string
		 * @return string representing date in format YYYY-MM-DD
		 */
		public static String parseDateFromCalendarToString(Calendar c) {
			
			String y, m, d;
			y=String.valueOf(c.get(Calendar.YEAR));
			m=String.valueOf((c.get(Calendar.MONTH)+1));
			if(m.length()<2)
				m="0"+m;
			d=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			if(d.length()<2)
				d="0"+d;
			return y+"-"+m+"-"+d;
		}

		

		/**
		 * 
		 * @param date date in format YYYY-MM-DD
 		 * @return  Calendar object representing given date
		 */
		public static Calendar parseDateFromStringToCalendar(String date) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(dateFormat.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return cal;
		}
		
		
		/**
		 * 
		 * @param s string representing a number
		 * @return double type number
		 */
		public static double parseStringToDouble(String s) {
			
			double number;
			if(s.contains(","))
				s = s.replace(',', '.');
			else
				s+=".0";
			number = Double.parseDouble(s);
			return number;
		}
}
