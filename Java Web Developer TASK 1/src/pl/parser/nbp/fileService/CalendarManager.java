package pl.parser.nbp.fileService;


import java.util.ArrayList;
import java.util.Calendar;


public class CalendarManager {

	private String initialDate;
	private String finalDate;
	/**
	 * an amount of days between initial and final date
	 */
	private int numberOfDaysToCount;
	/**
	 * a list of dates (YYYY-MM-DD) between initial and final date INCLUDING both of them
	 */
	private ArrayList<String> datesFromInitToFin;
	
	
	
	public CalendarManager(String initDate, String finDate) {
		this.initialDate = initDate;
		this.finalDate = finDate;
		this.setNumberOfDaysToCount(this.generateNumberOfDaysBetweenDates());
		this.setDatesFromInitToFin(this.generateDatesFromInitToFin());
	}
	
	
	
	// GETTERS AND SETTERS
	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}


	public int getNumberOfDaysToCount() {
		return numberOfDaysToCount;
	}


	public void setNumberOfDaysToCount(int numberOfDaysToCount) {
		this.numberOfDaysToCount = numberOfDaysToCount;
	}

	
	public ArrayList<String> getDatesFromInitToFin() {
		return datesFromInitToFin;
	}

	public void setDatesFromInitToFin(ArrayList<String> datesFromInitToFin) {
		this.datesFromInitToFin = datesFromInitToFin;
	}
	

	
	/**
	 * 
	 * @return number of days between initial and final date
	 */
	private int generateNumberOfDaysBetweenDates(){

		Calendar cal = Calendar.getInstance();
		cal = Parsers.parseDateFromStringToCalendar(finalDate);
		long cFinal = cal.getTimeInMillis();
		
		cal = Parsers.parseDateFromStringToCalendar(initialDate);
		long cInitial = cal.getTimeInMillis();
		long differenceInMillis = cFinal - cInitial;
		long dayInMillis = 1000*60*60*24;
		return (int)(differenceInMillis/dayInMillis);
	}
	
	
	
	
	/**
	 * 
	 * @return a list that contains dates (YYYY-MM-DD) between initial and final date
	 * 			INCLUDING both of them
	 * 
	 */
	private ArrayList<String> generateDatesFromInitToFin() {
		ArrayList<String> list = new ArrayList<String>();
		Calendar day = Calendar.getInstance();
		
		day = Parsers.parseDateFromStringToCalendar(initialDate);
		list.add(Parsers.parseDateFromCalendarToString(day));
		
		for(int i = 0; i < numberOfDaysToCount; i++) {
			day.add(Calendar.DAY_OF_MONTH, 1);
			list.add(Parsers.parseDateFromCalendarToString(day));
		}

		return list;
		
	}
	
	

}
