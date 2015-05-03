package pl.parser.nbp.fileService;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataValidator {

	private String[] validCurrencyCodes = {"ATS","AUD","BEF","CZK","DKK","EEK","FIM",
											"FRF","GRD","ESP","NLG","IEP","JPY","CAD",
											"LUF","NOK","PTE","EUR","USD","CHF","SEK",
											"HUF","GBP","ITL","XDR"};
	
	
	
	/**
	 * 
	 * @param date string with date to check
	 * @return true if the date is in acceptable format (YYYY-MM-DD)
	 */
	public boolean isDateValid(String date) {
		
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher match = pattern.matcher(date);
		Calendar c = Calendar.getInstance();
		
		if(match.find()) {
			String[] dateFactors = date.split("-");
			String y,m,d;
			y=dateFactors[0];
			m=dateFactors[1];
			d=dateFactors[2];
			
			if(Integer.parseInt(y) <= c.get(Calendar.YEAR)
				&& Integer.parseInt(m) <=12
				&& Integer.parseInt(d) <= 31) 
				return true;
			else {
				System.err.println("Wrong date format!");
				return false;
			}
		}
		else {
			System.err.println("Wrong date format!");
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param init  string with first date
	 * @param fin   string with second date
	 * @return true if second date is later date than the first one
	 */
	public boolean isInitialDateEarlierThanFinal(String init, String fin) {
		Calendar c = Parsers.parseDateFromStringToCalendar(init);
		Calendar f = Parsers.parseDateFromStringToCalendar(fin);
		
		if(c.getTimeInMillis() < f.getTimeInMillis())
			return true;
		else {
			System.err.println("Initial date must be an earlier date than the final!");
			return false;
		}
	}
	
	
	
	/**
	 * 
	 * @param currencyCode string representing currency
	 * @return  true if the code exists in previously declared set of codes
	 */
	public boolean isCurrencyCodeValid(String currencyCode) {
		for(String curr: validCurrencyCodes) {
			if(curr.equals(currencyCode.toUpperCase())) return true;
		}
		System.err.println("Currency code is unrecognizable!");
		return false;
	}
	
	
	
	/**
	 * 
	 * @param currencyCode string representing currency
	 * @param initDate  string with first date
	 * @param finDate   string with second date
	 * @return true if all of the parameters are valid values
	 */
	public boolean validate(String currencyCode, String initDate, String finDate) {
		if(isDateValid(initDate) && isDateValid(finDate) 
				&& isInitialDateEarlierThanFinal(initDate, finDate) 
				&& isCurrencyCodeValid(currencyCode))
			return true;
		else
			return false;
	}

}
